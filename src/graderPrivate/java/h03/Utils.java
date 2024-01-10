package h03;

import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.opentest4j.AssertionFailedError;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.assertions.PreCommentSupplier;
import org.tudalgo.algoutils.tutor.general.assertions.ResultOfFail;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

import java.lang.reflect.InvocationTargetException;

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.withSettings;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.*;
import static org.tudalgo.algoutils.tutor.general.match.BasicMatchers.equalObject;

/**
 * Test utilities.
 */
public class Utils {

    /**
     * The message for the assertion that the state is wrong after initialization.
     */
    public static String WRONG_STATE_AFTER_INITIALIZATION = "wrong state after initialization";

    /**
     * Asserts that the given object is an instance of the given type.
     *
     * @param object the object
     * @param type   the type
     * @param <T>    the type
     * @return the object
     */
    @SuppressWarnings("unchecked")
    public static <T> T assertIsInstance(final Object object, final Class<T> type) {
        assertCorrectSuperType(BasicTypeLink.of(object.getClass()), equalObject(BasicTypeLink.of(type)));
        return (T) object;
    }

    /**
     * Mocks an object of the given type.
     *
     * @param l    the type link
     * @param args the constructor arguments
     * @param <T>  the type
     * @return the mock
     */
    @SuppressWarnings("unchecked")
    public static <T> T mockX(final TypeLink l, final Object... args) {
        try {
            return (T) Mockito.mock(
                l.reflection(),
                withSettings()
                    .defaultAnswer(CALLS_REAL_METHODS)
                    .useConstructor(args)
            );
        } catch (final MockitoException e) {
            if (e.getCause() instanceof final org.mockito.creation.instance.InstantiationException e1) {
                if (e1.getCause() instanceof final InvocationTargetException e2) {
                    if (e2.getCause() instanceof final RuntimeException re) {
                        throw re;
                    }
                }
            }
            throw e;
        }
    }

    /**
     * Does some verification and fails if the verification fails.
     *
     * @param verificationRunnable the verification runnable
     * @param testRunnable         the test runnable
     * @param context              the context
     * @param preCommentSupplier   the pre comment supplier
     */
    public static void verifyX(
        final Runnable verificationRunnable,
        final Runnable testRunnable,
        final Context context,
        final PreCommentSupplier<? super ResultOfFail> preCommentSupplier
    ) {
        testRunnable.run();
        try {
            verificationRunnable.run();
        } catch (final AssertionFailedError e) {
            Assertions2.fail(
                context,
                preCommentSupplier
            );
        }
    }
}
