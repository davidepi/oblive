package testclasses.arrays.multidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LoadArrayDouble {
    private double[][] array;

    public LoadArrayDouble() {
        this.array = new double[2][3];
        this.array[0] = new double[]{.1, .2, .3};
        this.array[1] = new double[]{.4, .5, .6};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public double getVal() {
        return this.array[1][0];
    }

}
