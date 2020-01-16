package testclasses.fields;

import eu.fbk.hardening.annotation.NativeObfuscation;

public class GetStaticLong {
    private static long fieldJ;

    public GetStaticLong() {
        GetStaticLong.fieldJ = 10000000000L;
    }

    @NativeObfuscation
    public long getStatic() {
        return GetStaticLong.fieldJ;
    }
}
