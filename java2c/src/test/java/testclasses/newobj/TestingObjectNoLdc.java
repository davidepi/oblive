package testclasses.newobj;


//////////////////////////////////
//  Used in the NewObjectNoLdc  //
//////////////////////////////////

import java.io.PrintStream;

public class TestingObjectNoLdc {
    int a;
    long b;
    double c;
    String d;
    PrintStream e;

    public TestingObjectNoLdc(int a, long b, PrintStream e, double c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || (!TestingObjectNoLdc.class.isAssignableFrom(object.getClass())))
            return false;
        else {
            final TestingObjectNoLdc other = (TestingObjectNoLdc) object;
            return this.a == other.a && this.b == other.b && this.c == other.c && this.d.equals(other.d);
        }
    }
}
