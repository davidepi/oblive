package testclasses.invoke.invokeinterface;

public class ImplementedInterface implements AdderInterface
{
    @Override
    public int add(int a, int b)
    {
        return a+b;
    }

    @Override
    public float add(float a, float b)
    {
        return a+b;
    }
}
