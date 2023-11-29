package h03.robots;

import java.util.function.Supplier;

/**
 * A lazy object that is initialized on first access.
 *
 * @param <T> the type of the object
 */
public class Late<T> {

    /**
     * The supplier.
     */
    private final Supplier<T> supplier;

    /**
     * The object.
     */
    private T object;

    /**
     * The exception that occurred during initialization.
     */
    private RuntimeException exception;

    /**
     * Creates a new lazy object.
     *
     * @param supplier the supplier that initializes the object
     */
    public Late(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    /**
     * Gets the object.
     *
     * @return the object
     */
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

    /**
     * Creates a new lazy object with the given supplier.
     *
     * @param supplier the supplier
     * @param <T>      the type of the object
     * @return the lazy object
     */
    public static <T> Late<T> of(Supplier<T> supplier) {
        return new Late<>(supplier);
    }
}
