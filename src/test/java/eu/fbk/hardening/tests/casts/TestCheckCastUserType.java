package eu.fbk.hardening.tests.casts;

import eu.fbk.hardening.helpers.AbstractTestMethodTemplate;
import testclasses.support.BaseClassEmpty2;
import testclasses.support.DerivedLeftEmpty;
import testclasses.support.DerivedRightEmpty;

public class TestCheckCastUserType extends AbstractTestMethodTemplate
{
    private Class<?> className = testclasses.casts.CheckCastUserType.class;
    private String[] methodTest = {"castString", "castString", "castString", "castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class},
                                     new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{DerivedLeftEmpty.class}, new Object[]{DerivedRightEmpty.class},
                                     new Object[]{BaseClassEmpty2.class}, new Object[]{null}};

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
