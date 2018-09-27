package eu.fbk.hardening.support;

public class ClassMethodPair
{
    private String className;
    private String methodName;
    private String desc;
    private MethodSignature signature;
    public boolean overloaded;

    public ClassMethodPair(String sclass, String smethod, String ssignature)
    {
        this.className = sclass;
        this.methodName = smethod;
        this.desc = ssignature;
        this.signature = new MethodSignature(ssignature);
        //cannot set this variable until every method has been processed
        overloaded = false;
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

    public MethodSignature getSignature()
    {
        return signature;
    }

    public void setSignature(String signature)
    {
        this.signature = new MethodSignature(signature);
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
