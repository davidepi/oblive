package it.se.obfuscator.support;

import java.util.*;

public class ExtractedBytecode
{
    public List<String> statements;
    public Set<String> usedLabels;
    public int maxStack;
    public int maxLVar;
    public boolean isStatic;

    public ExtractedBytecode(boolean isStatic)
    {
        statements = new ArrayList<String>();
        usedLabels = new HashSet<String>();
        this.isStatic = isStatic;
    }

    //remove unnecessary labels
    public void stripLabels()
    {
        Iterator<String> it = statements.iterator();
        while(it.hasNext())
        {
            String value = it.next();
            if(value.length()>6 && value.substring(0,6).equals("LABEL_"))
            {
                String label = value.substring(6,value.length()-1);
                if(!usedLabels.contains(label))
                    it.remove();
            }
        }
    }
}
