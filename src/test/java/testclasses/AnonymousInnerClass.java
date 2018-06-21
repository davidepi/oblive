package testclasses;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;
import testclasses.arithmetic.IAdd;

public class AnonymousInnerClass
{
    public AnonymousInnerClass()
    {

    }

    public static int add(int a, int b)
    {
        IAdd cls = new IAdd()
        {
            @Obfuscation(protections = Protections.TO_NATIVE_CODE)
            public int exec(int a, int b)
            {
                return a + a + b + b;
            }
        };
        return cls.exec(a,b);
    }
}
