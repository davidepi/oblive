package testclasses.newobj;


//////////////////////////////////////////
//  Used in the NewObjectNoLdc class    //
//////////////////////////////////////////

import java.io.PrintStream;

public class ObjNoLdc
{
    int a;
    long b;
    double c;
    String d;
    PrintStream e;

    public ObjNoLdc(int a, long b, PrintStream e, double c, String d)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object==null || (!ObjNoLdc.class.isAssignableFrom(object.getClass())))
            return false;
        else
        {
            final ObjNoLdc other = (ObjNoLdc)object;
            return this.a==other.a && this.b==other.b && this.c==other.c && this.d.equals(other.d);
        }
    }
}
