package testclasses.invoke.invokedynamic;

import it.oblive.annotations.NativeObfuscation;

public class InvokeDynamicInt {
    public InvokeDynamicInt() {

    }

    @NativeObfuscation
    public int add(int a, int b) {

        AdderInterface<Integer> adder = (Integer c, Integer d) -> (c + d);
        return adder.add(a, b);
    }

    public int normalAdd(int a, int b) {
        return a + b;
    }
}