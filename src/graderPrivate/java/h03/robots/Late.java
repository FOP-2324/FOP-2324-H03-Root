package h03.robots;

import java.util.function.Supplier;

public class Late<T> {

    private final String name;

    private final Supplier<T> supplier;

    private T object;

    private RuntimeException exception;

    public Late(String name, Supplier<T> supplier) {
        this.name = name;
        this.supplier = supplier;
    }

    public String name() {
        return name;
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

    public static <T> Late<T> of(String name, Supplier<T> supplier) {
        return new Late<>(name, supplier);
    }
}
