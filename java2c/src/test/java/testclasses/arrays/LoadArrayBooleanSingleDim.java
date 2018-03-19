package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayBooleanSingleDim
{
    private boolean[] array;

    public LoadArrayBooleanSingleDim()
    {
        this.array = new boolean[]{false,false,false,false,true,false,false,false,false,false};
    }

    @Obfuscate
    public boolean getVal()
    {
        return this.array[9];
    }

}
