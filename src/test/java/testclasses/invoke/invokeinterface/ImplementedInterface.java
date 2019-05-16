package testclasses.invoke.invokeinterface;

public class ImplementedInterface implements AdderInterface {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public short add(short a, short b) {
        return (short) (a + b);
    }

    @Override
    public float add(float a, float b) {
        return a + b;
    }

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public byte add(byte a, byte b) {
        return (byte) (a + b);
    }

    @Override
    public char add(char a, char b) {
        return (char) (a + b);
    }

    @Override
    public long add(long a, long b) {
        return a + b;
    }

    @Override
    public boolean and(boolean a, boolean b) {
        return a && b;
    }

    @Override
    public String concatenate(String a, char b) {
        return a + b;
    }

    @Override
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    @Override
    public int[] array() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    }
}
