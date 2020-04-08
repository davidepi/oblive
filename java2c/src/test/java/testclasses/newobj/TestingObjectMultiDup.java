package testclasses.newobj;


////////////////////////////////
//  Used in the NewObjectLdc  //
////////////////////////////////

public class TestingObjectMultiDup {
    int a;
    int b;
    int c;
    int d;

    public TestingObjectMultiDup(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || (!TestingObjectMultiDup.class.isAssignableFrom(object.getClass())))
            return false;
        else {
            final TestingObjectMultiDup other = (TestingObjectMultiDup) object;
            return this.a == other.a && this.b == other.b && this.c == other.c && this.d == other.d;
        }
    }
}
