package h03.robots;

import java.util.function.Supplier;

public class Late<T> {

    private final Supplier<T> supplier;

    private T object;

    private RuntimeException exception;

    public Late(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (object == null && exception == null) {
            try {
                object = supplier.get();
            } catch (RuntimeException e) {
                exception = e;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return object;
    }

    public static <T> Late<T> of(Supplier<T> supplier) {
        return new Late<>(supplier);
    }
}
