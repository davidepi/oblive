package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayObjectSingleDim
{
    private String[] array;

    public LoadArrayObjectSingleDim()
    {
        this.array = new String[]{"hello","world"};
    }

    @Obfuscate
    public String getVal()
    {
        return this.array[1];
    }

}
