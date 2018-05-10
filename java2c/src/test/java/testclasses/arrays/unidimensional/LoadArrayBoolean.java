package testclasses.arrays.unidimensional;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LoadArrayBoolean
{
    private boolean[] array;

    public LoadArrayBoolean()
    {
        this.array = new boolean[]{false, false, false, false, true, false, false, false, false, false};
    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean getVal()
    {
        return this.array[9];
    }

}
