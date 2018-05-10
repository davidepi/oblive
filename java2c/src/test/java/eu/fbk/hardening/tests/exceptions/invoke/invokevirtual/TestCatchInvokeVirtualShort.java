package eu.fbk.hardening.tests.exceptions.invoke.invokevirtual;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;

public class TestCatchInvokeVirtualShort extends AbstractTestMethodTemplate
{

    private Class<?> className = testclasses.exceptions.invoke.invokevirtual.CatchInvokeVirtualShort.class;
    private String[] methodTest = {"div"};
    private Class[][] methodParam = {new Class[]{int.class}};
    private Object[][] methodArgs = {new Object[]{10}};


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
