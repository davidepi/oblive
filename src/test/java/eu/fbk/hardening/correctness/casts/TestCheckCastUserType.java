package eu.fbk.hardening.correctness.casts;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import testclasses.support.BaseClassEmpty2;
import testclasses.support.DerivedLeftEmpty;
import testclasses.support.DerivedRightEmpty;

public class TestCheckCastUserType extends AbstractTestCorrectnessTemplate {
    private Class<?> className = testclasses.casts.CheckCastUserType.class;
    private String[] methodTest = {"castString", "castString", "castString", "castString"};
    private Class[][] methodParam = {new Class[]{Object.class}, new Class[]{Object.class},
            new Class[]{Object.class}, new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{DerivedLeftEmpty.class}, new Object[]{DerivedRightEmpty.class},
            new Object[]{BaseClassEmpty2.class}, new Object[]{null}};

    @Override
    public Class<?> getTestClass() {
        return className;
    }

    @Override
    public String[] getTestMethodName() {
        return methodTest;
    }

    @Override
    public Class<?>[][] getTestMethodParams() {
        return methodParam;
    }

    @Override
    public Object[][] getTestMethodArgs() {
        return methodArgs;
    }
}
