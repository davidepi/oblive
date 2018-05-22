package testclasses.adhoc;

import eu.fbk.hardening.annotation.Obfuscation;
import eu.fbk.hardening.annotation.Protections;

//detected while testing joda-time
public class CharAt
{
    public CharAt()
    {

    }

    @Obfuscation(protections = Protections.TO_NATIVE_CODE)
    public boolean add(String text)
    {
        char c =  text.charAt(0);
        return c == '5';
    }
}
