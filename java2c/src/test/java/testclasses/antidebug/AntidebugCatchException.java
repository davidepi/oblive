package testclasses.antidebug;

import it.oblive.annotations.AntidebugSelf;
import it.oblive.annotations.NativeObfuscation;

public class AntidebugCatchException {
    public AntidebugCatchException() {

    }

    @NativeObfuscation
    @AntidebugSelf
    public static int convert(String number) {
        try
        {
            return Integer.decode(number);
        } catch (NumberFormatException e)
        {
            //ignore
        }
        return 0;
    }
}
