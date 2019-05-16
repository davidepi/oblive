//package eu.fbk.hardening.correctness.invoke.invokedynamic;
//
//import eu.fbk.hardening.helpers.AbstractTestCorrectnessTemplate;
//import testclasses.invoke.invokeinterface.AdderInterface;
//import testclasses.invoke.invokeinterface.ImplementedInterface;
//
//public class TestInvokeDynamicInt extends AbstractTestCorrectnessTemplate
//{
//
//    private Class<?> className = testclasses.invoke.invokedynamic.InvokeDynamicInt.class;
//    private String[] methodTest = {"add"};
//    private Class[][] methodParam = {new Class[]{int.class,int.class}};
//    private Object[][] methodArgs = {new Object[]{1000000,-2000000}};
//
//
//    @Override
//    public Class<?> getTestClass()
//    {
//        return className;
//    }
//
//    @Override
//    public String getTestMethodName(int position)
//    {
//        return methodTest[position];
//    }
//
//    @Override
//    public int getTestMethodSize()
//    {
//        return methodTest.length;
//    }
//
//    @Override
//    public Class<?>[] getTestMethodParams(int position)
//    {
//        return methodParam[position];
//    }
//
//    @Override
//    public Object[] getTestMethodArgs(int position)
//    {
//        return methodArgs[position];
//    }
//}
