package it.se.obfuscator.support;

import it.se.obfuscator.IllegalPatternException;

import java.lang.reflect.Array;
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

    //remove unnecessary labels and add try-catch defines
    public void preprocess()
    {
        //generate the string undefining every catch statements
        StringBuilder sb = new StringBuilder();
        for(String s : this.catchedStatements)
        {
            sb.append("#undef CATCH_"+s.replaceAll("/","_")+"\n");
        }
        String undefAllCatch = sb.toString();

        //calculate the length of every try-catch block
        this.computeTryCatchLength();

        //<Label<Catch stmt,TryCatchBlock>>
        Map<String,HashMap<String,TryCatchBlock>> defines = new HashMap<>();
        //add try-catchs to every basic block
        for(TryCatchBlock current : tryCatchBlocks) //for every try-catch
        {
            for(int i=current.startIndex;i<current.endIndex;i++) //for every label affected by the try-catch
            {
                HashMap<String,TryCatchBlock> map = defines.get(labels.get(i));
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
                        if(mapped.length>current.length) //mine is the shorted, the other one is removed
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

        //now flatten the <Label<Catch stmt, TryCatchBlock>> into a <Label,Catch_stmt> by appending the TryCatchBlock handle
        HashMap<String,String> definesProcessed = new HashMap<>();
        Iterator it0 = defines.entrySet().iterator();
        while(it0.hasNext())
        {
            Map.Entry pair = (Map.Entry)it0.next();
            StringBuilder catchstring = new StringBuilder();
            Iterator it1 = ((HashMap<String,TryCatchBlock>)pair.getValue()).entrySet().iterator();
            while(it1.hasNext())
            {
                Map.Entry inner = (Map.Entry)it1.next();
                 catchstring.append("#define CATCH_");
                 catchstring.append(((String)inner.getKey()).replaceAll("/","_"));
                 catchstring.append(" LABEL_");
                 catchstring.append(((TryCatchBlock)inner.getValue()).handle);
                 catchstring.append("\n");
            }
            definesProcessed.put(((String)pair.getKey()),catchstring.toString());
        }

        ListIterator<String> it = statements.listIterator();
        while(it.hasNext())
        {
            String value = it.next();
            if(value.length()>6 && value.substring(0,6).equals("LABEL_"))
            {
                String label = value.substring(0,value.length()-1);
                String labelpure = value.substring(6,value.length()-1);
                String catchme;
                if(!usedLabels.contains(label))
                    it.remove();
                it.add(undefAllCatch);
                if(definesProcessed.containsKey(labelpure))
                {
                    catchme = definesProcessed.get(labelpure);
                    it.add(catchme);
                }
            }
        }
    }
}
