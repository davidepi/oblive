package eu.fbk.hardening.support;

import eu.fbk.hardening.IllegalPatternException;

import java.util.*;

public class ExtractedBytecode
{
    public List<String> statements;
    public List<String> labels; //ordered labels
    public List<TryCatchBlock> tryCatchBlocks; //these are needed after gathering every label
    public Set<String> usedLabels;
    public Set<String> catchedStatements;
    public int maxStack;
    public int maxLVar;
    public boolean isStatic;
    public final static String postprocessIsCatched = "$$_EXCEPTION_CHECK";
    public final static String postprocessExceptionClear = "$$_EXCEPTION_CLEAR";

    public ExtractedBytecode(boolean isStatic)
    {
        statements = new ArrayList<String>();
        tryCatchBlocks = new ArrayList<>();
        labels = new ArrayList<String>();
        usedLabels = new HashSet<String>();
        catchedStatements = new HashSet<>();
        this.isStatic = isStatic;
    }

    private void computeTryCatchLength()
    {
        for(TryCatchBlock current : tryCatchBlocks)
        {
            current.startIndex = labels.indexOf(current.start);
            current.endIndex = labels.indexOf(current.end);
            if(current.startIndex<0 || current.endIndex<0)
                throw new IllegalPatternException("Inconsistents try-catch blocks");
            else
                current.length = current.endIndex-current.startIndex;
        }
    }

    private String generateExitCatchs()
    {
        //generate the string undefining every catch statements
        StringBuilder sb = new StringBuilder();
        for(String s : this.catchedStatements)
        {
            sb.append("#undef CATCH_");
            sb.append(s.replaceAll("/","_"));
            sb.append("\n");
        }
        return sb.toString();
    }



    /**
     * Given a list of TryCatchBlock and a list of labels, return the map (Label,(CatchStmt,TryCatchBlock)) where for
     * each label pairs (catched exception, trycatch block) are recorded. Only the innermost trycatch for each label is
     * saved
     * @return
     */
    private Map<String,Map<String,TryCatchBlock>> reorganizeTryCatchs()
    {

        //calculate the length of every try-catch block
        this.computeTryCatchLength();

        //<Label<Catch stmt,TryCatchBlock>>
        Map<String,Map<String,TryCatchBlock>> defines = new HashMap<>();
        //add try-catchs to every basic block
        for(TryCatchBlock current : tryCatchBlocks) //for every try-catch
        {
            for(int i=current.startIndex;i<current.endIndex;i++) //for every label affected by the try-catch
            {
                Map<String,TryCatchBlock> map = defines.get(labels.get(i));
                if(map == null) //this is the first try catch of that label
                {
                    map = new HashMap<>();
                    map.put(current.catched,current);
                    defines.put(labels.get(i),map);
                }
                else //another try-catch already exists
                {
                    TryCatchBlock mapped = map.get(current.catched);
                    if(mapped==null) //the try-catch was catching another exception
                    {
                        map.put(current.catched,current); //add the current catch
                    }
                    else //nested catch, need to keep the shortest one
                    {
                        if(mapped.length>current.length) //mine is the shortest, the other one is removed
                        {
                            map.remove(current.catched);
                            map.put(current.catched,current);
                        }
                        else
                            /*the other one is the shortest, do nothing */;
                    }
                }
            }
        }
        return defines;
    }

    /**
     * flatten the result of a reorganizeTryCatch() in order to get a pair (Label,String) where for each string the prepared
     * #ifdef catchedexception goto handle are used
     * @param reorganizeTryCatchRes The result of a reorganizeTryCatch() call
     * @return
     */
    private Map<String,String> flattenTryCatchs(Map<String,Map<String,TryCatchBlock>> reorganizeTryCatchRes)
    {
        //now flatten the <Label<Catch stmt, TryCatchBlock>> into a <Label,Catch_stmt> by appending the TryCatchBlock handle
        HashMap<String,String> retval = new HashMap<>();
        Iterator<Map.Entry<String, Map<String, TryCatchBlock>>> it0 = reorganizeTryCatchRes.entrySet().iterator();
        while(it0.hasNext())
        {
            Map.Entry<String, Map<String, TryCatchBlock>> pair = it0.next();
            StringBuilder catchstring = new StringBuilder();
            Iterator<Map.Entry<String, TryCatchBlock>> it1 = (pair.getValue()).entrySet().iterator();
            while(it1.hasNext())
            {
                Map.Entry<String, TryCatchBlock> inner = it1.next();
                catchstring.append("#define CATCH_");
                catchstring.append(inner.getKey().replaceAll("/","_"));
                catchstring.append(" LABEL_");
                catchstring.append(inner.getValue().handle);
                catchstring.append("\n");
            }
            retval.put((pair.getKey()),catchstring.toString());
        }
        return retval;
    }

    //remove unnecessary labels and add try-catchs in C
    public void postprocess()
    {
        String exitCatchBlock = generateExitCatchs();
        Map<String,Map<String,TryCatchBlock>> tryCatches = reorganizeTryCatchs(); //<label,catched stmt, trycatchblock>
        Map<String,String> enterCatchBlock = flattenTryCatchs(tryCatches); //<label,#define1...#define2...>
        ListIterator<String> it = statements.listIterator();
        String labelpure = "";
        while(it.hasNext())
        {
            String value = it.next();
            if(value.length()>6 && value.substring(0,6).equals("LABEL_"))
            {
                String label = value.substring(0,value.length()-1);
                labelpure = value.substring(6,value.length()-1);
                String catchme;
                if(!usedLabels.contains(label))
                    it.remove();
                it.add(exitCatchBlock);
                if(enterCatchBlock.containsKey(labelpure))
                {
                    catchme = enterCatchBlock.get(labelpure);
                    it.add(catchme);
                }
            }
            //need to add a dynamic type checking for the user-defined exceptions
            else if(value.equals(postprocessIsCatched) || value.equals(postprocessExceptionClear))
            {
                //add also the ExceptionClear() block. For exceptions generated in the JVM and catched in the JNI
                boolean clear = value.equals(postprocessExceptionClear);

                it.remove();
                // last label used, since I'm not right after a label ----------v
                Map<String,TryCatchBlock> currentLabelCatch = tryCatches.get(labelpure);
                if(currentLabelCatch == null) //no catchblock for the current basic block, so throw the exception
                {
                    it.add("(*env)->Throw(env,_stack[0].l);\nRETURN_EXCEPTION;\n");
                }
                else //inside a catchblock, so if(raised exception instance of catched exception) goto catch, else throw
                {
                    //flatten into array
                    List<TryCatchBlock> list = new ArrayList<TryCatchBlock>(currentLabelCatch.values());
                    //reorder array otherwise I could break inheritance (catching in the wrong block)

                    list.sort(Comparator.comparingInt(block -> (block.order)));
                    for(TryCatchBlock catched : list)
                    {
                        //no need to if-elif-else since every if is broken by a goto
                        it.add("if(_ExceptionInstanceOf(env,_stack,\"" + catched.catched + "\")){\n");
                        if(clear)
                            it.add("(*env)->ExceptionClear(env);\n");
                        it.add("goto LABEL_" + catched.handle + ";\n}\n");
                    }
                    it.add("(*env)->Throw(env,_stack[0].l);\nRETURN_EXCEPTION;\n");
                }
            }
        }
    }
}
