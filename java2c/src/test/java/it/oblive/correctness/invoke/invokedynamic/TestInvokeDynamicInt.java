package it.oblive.correctness.invoke.invokedynamic;

import it.oblive.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Disabled;

@Disabled("INVOKEDYNAMIC still not implemented")
public class TestInvokeDynamicInt extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokedynamic.InvokeDynamicInt.class;
    private String[] methodTest = {"add"};
    private Class[][] methodParam = {new Class[]{int.class, int.class}};
    private Object[][] methodArgs = {new Object[]{1000000, -2000000}};


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
