package eu.fbk.hardening.tests.arithmetic;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestDDiv extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.arithmetic.DDiv.class;
    private String[] methodTest = {"exec","exec"};
    private Class[][] methodParam = {new Class[]{double.class,double.class},new Class[]{double.class,double.class}};
    private Object[][] methodArgs = {new Object[]{3.5,2.5},new Object[]{3.5,0}};


    @Override
    public Class<?> getTestClass()
    {
        return className;
    }

    @Override
    public String getTestMethodName(int position)
    {
        return methodTest[position];
    }

    @Override
    public int getTestMethodSize()
    {
        return methodTest.length;
    }

    @Override
    public Class<?>[] getTestMethodParams(int position)
    {
        return methodParam[position];
    }

    @Override
    public Object[] getTestMethodArgs(int position)
    {
        return methodArgs[position];
    }
}
