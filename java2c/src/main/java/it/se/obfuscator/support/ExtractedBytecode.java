package it.se.obfuscator.support;

import java.util.ArrayList;

public class ExtractedBytecode
{
    public ArrayList<String> statements;
    public int maxStack;
    public int maxLVar;
    public boolean isStatic;

    public ExtractedBytecode(boolean isStatic)
    {
        statements = new ArrayList<String>();
        this.isStatic = isStatic;
    }
}
