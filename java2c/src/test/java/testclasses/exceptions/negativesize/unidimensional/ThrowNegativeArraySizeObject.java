package testclasses.exceptions.negativesize.unidimensional;

import it.oblive.annotations.NativeObfuscation;

public class ThrowNegativeArraySizeObject {
    private Object[] array;

    public ThrowNegativeArraySizeObject() {

    }

    @NativeObfuscation
    public int exec() {
        this.array = new String[-1];
        return 0;
    }
}
