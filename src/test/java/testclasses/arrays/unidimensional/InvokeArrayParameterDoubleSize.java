package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class InvokeArrayParameterDoubleSize {
    public InvokeArrayParameterDoubleSize() {

    }

    @NativeObfuscation
    public long exec() {
        long[] array = new long[3];
        array[0] = 0L;
        array[1] = 1L;
        array[2] = 2L;
        return doSomething(array, array, 3, array, array);
    }

    public long doSomething(long[] values, long[] unusedValues0, long size, long[] unusedValues1,
                            long[] unusedValues2) {
        return values[(int) size / 2];
    }
}