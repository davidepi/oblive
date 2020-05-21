package it.oblive.correctness.exceptions.nullpointer.arraystore;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import testclasses.exceptions.nullpointer.SupportClassObject;

public class TestCatchNullPointerExceptionXSTOREObject extends AbstractTestCorrectnessTemplate {
    private Class<?> className =
            testclasses.exceptions.nullpointer.arraystore.CatchNullPointerExceptionXSTOREObject.class;
    private String[] methodTest = {"exec"};
    private Class[][] methodParam = {new Class[]{SupportClassObject.class}};
    private Object[][] methodArgs = {new Object[]{new SupportClassObject()}};

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
