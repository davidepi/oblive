package it.se.obfuscator.support;

import java.util.*;

public class ExtractedBytecode
{
    public List<String> statements;
    public List<String> labels; //ordered labels
    public Set<String> usedLabels;
    public Map<String,String> tryCatchEntryPoint;
    public Map<String,String> tryCatchExitPoint;
    public Set<String> catchedStatements;
    public int maxStack;
    public int maxLVar;
    public boolean isStatic;

    public ExtractedBytecode(boolean isStatic)
    {
        statements = new ArrayList<String>();
        labels = new ArrayList<String>();
        usedLabels = new HashSet<String>();
        catchedStatements = new HashSet<>();
        tryCatchEntryPoint = new HashMap<>();
        tryCatchExitPoint = new HashMap<>();
        this.isStatic = isStatic;
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

        ListIterator<String> it = statements.listIterator();
        while(it.hasNext())
        {
            String value = it.next();
            if(value.length()>6 && value.substring(0,6).equals("LABEL_"))
            {
                String label = value.substring(0,value.length()-1);
                String got;
                if(!usedLabels.contains(label))
                    it.remove();
                it.add(undefAllCatch);
                if(tryCatchEntryPoint.containsKey(label))
                {
                    got = tryCatchEntryPoint.get(label);
                    it.add(got);
                }
            }
        }
    }
}
