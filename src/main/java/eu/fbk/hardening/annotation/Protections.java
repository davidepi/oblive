package eu.fbk.hardening.annotation;

public enum Protections {

    //this is used as an increasing number. so the protection with the highest number is the one that will be applied
    NONE(0),
    TO_NATIVE_CODE(1),
    ANTIDEBUG(2);

    private int numVal;

    Protections(int numVal) {
        this.numVal = numVal;
    }

    public int getVal() {
        return this.numVal;
    }
}
