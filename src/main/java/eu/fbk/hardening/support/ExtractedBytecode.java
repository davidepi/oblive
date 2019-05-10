package eu.fbk.hardening.support;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

/**
 * Class holding every statement extracted from the original bytecode and some method useful to process and rearrange
 * them. Can be seen as a single method represented by a collection of statements.
 *
 * @author D.Pizzolotto
 */
public class ExtractedBytecode {
    /**
     * List containing every bytecode opcode transformed in C. Every entry of this list correspond to an opcode ready
     * to be written in the C file
     */
    public List<String> statements;

    /**
     * List containing every label found in the method, in order
     */
    public List<String> labels; //ordered labels

    /**
     * List containing every try-catch block, represented with an ad-hoc structure
     */
    public List<TryCatchBlock> tryCatchBlocks; //these are needed after gathering every label

    /**
     * Set containing the list of labels (as they can be found in labels) used by the C code
     */
    public Set<String> usedLabels;

    /**
     * A set containing the list of every catch block that can be found anywhere in the method code. This is used to
     * know which block should be undefined after every basic block
     */
    public Set<String> catchedStatements;

    /**
     * Maximum size of the opcode stack
     */
    public int maxStack;

    /**
     * Maximum size of the variables array
     */
    public int maxLVar;

    /**
     * True if the method is static
     */
    public boolean isStatic;

    /**
     * Flag used to indicate where should be put the code checking indicating if an exception has been caught
     */
    public static final String POSTPROCESS_IS_CATCHED = "$$_EXCEPTION_CHECK";

    /**
     * Flag used to indicate where should be inserted the 'exception cleanup' code
     */
    public static final String POSTPROCESS_EXCEPTION_CLEAR = "$$_EXCEPTION_CLEAR";

    /**
     * Initialize this class
     *
     * @param staticMethod true if the method is flagged as static
     */
    public ExtractedBytecode(boolean staticMethod) {
        statements = new ArrayList<>();
        tryCatchBlocks = new ArrayList<>();
        labels = new ArrayList<>();
        usedLabels = new HashSet<>();
        catchedStatements = new HashSet<>();
        this.isStatic = staticMethod;
    }

    /**
     * After collecting the extent of every try-catch block, and thus after the method reading is finished, this
     * method is used to compute the length of every try-catch block. The length of these blocks can be used to know
     * which is the innermost block in case they are nested (pro tip: the innermost is the shortest one)
     */
    private void computeTryCatchLength() {
        for (TryCatchBlock current : tryCatchBlocks) {
            current.startIndex = labels.indexOf(current.start);
            current.endIndex = labels.indexOf(current.end);
            if (current.startIndex < 0 || current.endIndex < 0) {
                throw new IllegalPatternError("Inconsistents try-catch blocks");
            } else {
                current.length = current.endIndex - current.startIndex;
            }
        }
    }

    /**
     * Returns the C preprocessor defines used to signal that every catch has been exited. Note that this class
     * defines catch blocks at the beginning of every basic block and undefines them at the end of it. This method
     * generates the string that undefines them.
     *
     * @return The string representing a list of statements undefining every catch block preprocessor directive
     */
    @NotNull
    private String generateExitCatchs() {
        //generate the string undefining every catch statements
        StringBuilder sb = new StringBuilder();
        for (String s : this.catchedStatements) {
            sb.append("#undef CATCH_");
            sb.append(s.replaceAll("/", "_"));
            sb.append("\n");
        }
        return sb.toString();
    }


    /**
     * Given a list of TryCatchBlock and a list of labels, returns the map (Label,(CatchStmt,TryCatchBlock)) where for
     * each label pairs (catched exception, trycatch block) are recorded. Only the innermost try-catch for each label is
     * saved
     *
     * @return The reorganized list of try-catch blocks (check above description)
     */
    private Map<String, Map<String, TryCatchBlock>> reorganizeTryCatchs() {

        //calculate the length of every try-catch block
        this.computeTryCatchLength();

        //<Label<Catch stmt,TryCatchBlock>>
        Map<String, Map<String, TryCatchBlock>> defines = new HashMap<>();
        //add try-catchs to every basic block
        for (TryCatchBlock current : tryCatchBlocks) { //for every try-catch
            for (int i = current.startIndex; i < current.endIndex; i++) { //for every label affected by the try-catch
                Map<String, TryCatchBlock> map = defines.get(labels.get(i));
                if (map == null) { //this is the first try catch of that label
                    map = new HashMap<>();
                    map.put(current.catched, current);
                    defines.put(labels.get(i), map);
                } else { //another try-catch already exists
                    TryCatchBlock mapped = map.get(current.catched);
                    if (mapped == null) { //the try-catch was catching another exception
                        map.put(current.catched, current); //add the current catch
                    } else { //nested catch, need to keep the shortest one
                        if (mapped.length > current.length) { //mine is the shortest, the other one is removed
                            map.remove(current.catched);
                            map.put(current.catched, current);
                        }
                        /* else
                            the other one is the shortest, do nothing
                        */
                    }
                }
            }
        }
        return defines;
    }

    /**
     * Flatten the result of a reorganizeTryCatch() in order to get a pair (Label,String) where for each string the
     * prepared `#ifdef catchedexception goto handle are used`
     *
     * @param reorgTryCatchRes The result of a reorganizeTryCatch() call
     * @return The Map<Label,String> defined in the method description
     */
    private Map<String, String> flattenTryCatchs(@NotNull Map<String, Map<String, TryCatchBlock>> reorgTryCatchRes) {
        //now flatten the <Label<Catch stmt, TryCatchBlock>> into a <Label,Catch_stmt> by appending the TryCatchBlock
        // handle
        HashMap<String, String> retval = new HashMap<>();
        for (Map.Entry<String, Map<String, TryCatchBlock>> pair : reorgTryCatchRes.entrySet()) {
            StringBuilder catchstring = new StringBuilder();
            for (Map.Entry<String, TryCatchBlock> inner : (pair.getValue()).entrySet()) {
                catchstring.append("#define CATCH_");
                catchstring.append(inner.getKey().replaceAll("/", "_"));
                catchstring.append(" LABEL_");
                catchstring.append(inner.getValue().handle);
                catchstring.append("\n");
            }
            retval.put((pair.getKey()), catchstring.toString());
        }
        return retval;
    }

    /**
     * Removes every unnecessary label, add and reorganize try-catch blocks for the method of this class. This MUST
     * be called after the entire method has been visited
     */
    public void postprocess() {
        String exitCatchBlock = generateExitCatchs();
        Map<String, Map<String, TryCatchBlock>> tryCatches = reorganizeTryCatchs(); //<label,catched stmt,
        // trycatchblock>
        Map<String, String> enterCatchBlock = flattenTryCatchs(tryCatches); //<label,#define1...#define2...>
        ListIterator<String> it = statements.listIterator();
        String labelpure = "";
        while (it.hasNext()) {
            String value = it.next();
            if (value.length() > 6 && value.substring(0, 6).equals("LABEL_")) {
                String label = value.substring(0, value.length() - 3);
                labelpure = value.substring(6, value.length() - 3);
                String catchme;
                if (!usedLabels.contains(label)) {
                    it.remove();
                }
                it.add(exitCatchBlock);
                if (enterCatchBlock.containsKey(labelpure)) {
                    catchme = enterCatchBlock.get(labelpure);
                    it.add(catchme);
                }
            } else if (value.equals(POSTPROCESS_IS_CATCHED) || value.equals(POSTPROCESS_EXCEPTION_CLEAR)) {
                //need to add a dynamic type checking for the user-defined exceptions

                //add also the ExceptionClear() block. For exceptions generated in the JVM and catched in the JNI
                boolean clear = value.equals(POSTPROCESS_EXCEPTION_CLEAR);

                it.remove();
                // last label used, since I'm not right after a label ----------v
                Map<String, TryCatchBlock> currentLabelCatch = tryCatches.get(labelpure);
                if (currentLabelCatch == null) { //no catchblock for the current basic block, so throw the exception
                    it.add("(*env)->Throw(env,_stack[0].l);\nRETURN_EXCEPTION;\n");
                } else { //inside a catchblock, so if(raised exception instance of catched exception) goto catch, else
                    // throw
                    //flatten into array
                    List<TryCatchBlock> list = new ArrayList<TryCatchBlock>(currentLabelCatch.values());
                    //reorder array otherwise I could break inheritance (catching in the wrong block)

                    list.sort(Comparator.comparingInt(block -> (block.order)));
                    for (TryCatchBlock catched : list) {
                        //no need to if-elif-else since every if is broken by a goto
                        it.add("if(_ExceptionInstanceOf(env,_stack,\"" + catched.catched + "\")){\n");
                        if (clear) {
                            it.add("(*env)->ExceptionClear(env);\n");
                        }
                        it.add("goto LABEL_" + catched.handle + ";\n}\n");
                    }
                    it.add("(*env)->Throw(env,_stack[0].l);\nRETURN_EXCEPTION;\n");
                }
            }
        }
    }
}
