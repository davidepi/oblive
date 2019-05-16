package testclasses.exceptions.invoke.invokeinterface;

public class ImplementedInterface implements DivisionInterface {
    public int div(int a) {
        return a / 0;
    }

    public short div(short a) {
        return (short) (a / 0);
    }

    public float div(float a) {
        return (int) a / 0;
    }

    public double div(double a) {
        return (int) a / 0;
    }

    public byte div(byte a) {
        return (byte) (a / 0);
    }

    public char div(char a) {
        return (char) (a / 0);
    }

    public long div(long a) {
        return a / 0;
    }

    public boolean div(boolean a) {
        return (1 / 0) > 0;
    }

    public String div(String a) {
        return ((Integer) (1 / 0)).toString();
    }
}
