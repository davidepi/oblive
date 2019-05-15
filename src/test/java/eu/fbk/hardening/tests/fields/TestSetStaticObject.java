package eu.fbk.hardening.tests.fields;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;

public class TestSetStaticObject extends AbstractTestCorrectnessTemplate
{

    private Class<?> className = testclasses.fields.SetStaticObject.class;
    private String[] methodTest = {"getStatic"};
    private Class[][] methodParam = {new Class[]{}};
    private Object[][] methodArgs = {new Object[]{}};
    private String[] annotatedMethod = {"setStatic"};
    private Class[][] annotatedParams = {new Class[]{java.lang.String.class}};


    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String[] getTestMethodName()
    {
        return methodTest;
    }

    @Override
    public Class<?>[][] getTestMethodParams()
    {
        return methodParam;
    }

    @Override
    public Object[][] getTestMethodArgs()
    {
        return methodArgs;
    }

    @Override
    public String getAnnotatedMethodName(int position)
    {
        return annotatedMethod[position];
    }

    @Override
    public int getAnnotatedMethodSize()
    {
        return this.annotatedMethod.length;
    }

    @Override
    public Class<?>[] getAnnotatedMethodParams(int position)
    {
        return this.annotatedParams[position];
    }
}
