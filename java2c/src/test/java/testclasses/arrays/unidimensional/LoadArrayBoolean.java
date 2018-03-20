package testclasses.arrays.unidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayBoolean
{
    private boolean[] array;

    public LoadArrayBoolean()
    {
        this.array = new boolean[]{false,false,false,false,true,false,false,false,false,false};
    }

    @Obfuscate
    public boolean getVal()
    {
        return this.array[9];
    }

}
