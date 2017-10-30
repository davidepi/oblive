package it.se.obfuscator;

public class ClassMethodPair
{
    private String className;
    private String methodName;
    private String signature;

    public ClassMethodPair(String sclass, String smethod, String ssignature)
    {
        this.className = sclass;
        this.methodName = smethod;
        this.signature = ssignature;
    }

    public String getClassName()
    {
        return className;
    }

    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getMethodName()
    {
        return methodName;
    }

    public void setMethodName(String methodName)
    {
        this.methodName = methodName;
    }

    public String getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = signature;
    }
}
