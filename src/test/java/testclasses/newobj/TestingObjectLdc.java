package testclasses.newobj;


////////////////////////////////
//  Used in the NewObjectLdc  //
////////////////////////////////

import java.io.PrintStream;

public class TestingObjectLdc {
    int a;
    long b;
    double c;
    String d;
    PrintStream e;
    float f;
    short g;
    boolean h;
    char j;
    byte k;

    public TestingObjectLdc(int a, long b, PrintStream e, double c, float f, String d, short g, boolean h, char j,
                            byte k) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.g = g;
        this.h = h;
        this.j = j;
        this.k = k;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || (!TestingObjectLdc.class.isAssignableFrom(object.getClass())))
            return false;
        else {
            final TestingObjectLdc other = (TestingObjectLdc) object;
            return this.a == other.a && this.b == other.b && this.c == other.c && this.d.equals(other.d) && this.f == other.f
                    && this.g == other.g && this.h == other.h && this.j == other.j && this.k == other.k;
        }
    }
}
