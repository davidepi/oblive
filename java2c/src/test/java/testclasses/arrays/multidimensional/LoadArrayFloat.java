package testclasses.arrays.multidimensional;

import it.se.obfuscator.Obfuscate;

public class LoadArrayFloat
{
    private float[][] array;

    public LoadArrayFloat()
    {
        this.array = new float[2][3];
        this.array[0] = new float[]{.1f,.2f,.3f};
        this.array[1] = new float[]{.4f,.5f,.6f};
    }

    @Obfuscate
    public float getVal()
    {
        return this.array[1][0];
    }

}
