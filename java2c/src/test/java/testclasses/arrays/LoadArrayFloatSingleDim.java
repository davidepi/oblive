package testclasses.arrays;

import it.se.obfuscator.Obfuscate;

public class LoadArrayFloatSingleDim
{
    private float[] array;

    public LoadArrayFloatSingleDim()
    {
        this.array = new float[]{.1f,.2f,.3f,.4f,.5f,.6f,.7f,.8f,.9f,1.f};
    }

    @Obfuscate
    public float getVal()
    {
        return this.array[5];
    }

}
