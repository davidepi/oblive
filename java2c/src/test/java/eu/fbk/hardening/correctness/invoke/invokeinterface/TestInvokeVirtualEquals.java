package eu.fbk.hardening.correctness.invoke.invokeinterface;

import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
import org.junit.jupiter.api.Disabled;
import testclasses.invoke.invokeinterface.InvokeInterfaceEquals;

@Disabled("This must be fixed, but the fix is not ready yet")
public class TestInvokeVirtualEquals extends AbstractTestCorrectnessTemplate {

    private Class<?> className = testclasses.invoke.invokeinterface.InvokeInterfaceEquals.class;
    private String[] methodTest = {"equals"};
    private Class[][] methodParam = {new Class[]{Object.class}};
    private Object[][] methodArgs = {new Object[]{new InvokeInterfaceEquals()}};


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
