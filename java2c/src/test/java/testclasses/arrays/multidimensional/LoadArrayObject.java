package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayObject
{
    private String[][] array;

    public LoadArrayObject()
    {
        this.array = new String[3][2];
        this.array[0] = new String[]{"hello","world"};
        this.array[1] = new String[]{"ciao","mondo"};
        this.array[2] = new String[]{"こんにちは","世界"};
    }

    @Obfuscate
    public String getVal()
    {
        return this.array[2][0];
    }

}
