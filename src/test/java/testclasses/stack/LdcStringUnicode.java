package testclasses.stack;


import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

public class LdcStringUnicode {
    public LdcStringUnicode() {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public String exec() {
        return "( ͡° ͜ʖ ͡°)━☆ﾟ.*･｡ﾟ";
    }
}
