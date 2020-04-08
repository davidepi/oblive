package testclasses.exceptions;

public class ClassExceptionInInit {
    public ClassExceptionInInit() {
        super();
        int a = 1 / 0;
    }
}
