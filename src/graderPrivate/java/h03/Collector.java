package h03;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.sourcegrade.jagr.api.testing.extension.TestCycleResolver.getTestCycle;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import h03.robots.Late;
import h03.robots.Robots_Student;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.Link;
import org.tudalgo.algoutils.tutor.general.reflections.PackageLink;
import org.tudalgo.algoutils.tutor.general.reflections.WithCtElement;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;

@SuppressWarnings({"UnstableApiUsage", "NewClassNamingConvention"})
@TestForSubmission
public class Collector {

    /**
     * name of the root package
     **/
    static final String ROOT_PACKAGE = "h03";

    /**
     * List of classes to detect {@link Late} objects in.
     **/
    static final List<Class<?>> CLASSES = typesAndNestedTypes(
        Stream.of(
            Robots_Student.class,
            RobotSynchronizer_Student.class
        )
    ).toList();

    private static final String ID_TU = getTestCycle() != null ? getTestCycle().getSubmission().getInfo().split("_")[1] : "";

    @Test
    public void collect() throws IOException {
        try {
            var node = JsonNodeFactory.instance.arrayNode().addAll(
                getLinks().entrySet().stream().map(Collector::toObjectNode).toList()
            );
            fail(node.toPrettyString());
        } catch (Exception ex) {
            fail(throwableToString(ex));
        }
    }

    String throwableToString(Throwable t) {
        return t.getMessage() + "\n" + Arrays.stream(t.getStackTrace())
            .map(e -> e.toString())
            .distinct()
            .collect(Collectors.joining("\n"))
            + ((t.getCause() != null) ? ("\n" + throwableToString(t.getCause())) : "");
    }

    private static <T extends Link & WithCtElement> Map<String, T> getLinks() throws IOException {
        return CLASSES.stream()
            // filter classes within root packages
            .filter(c -> c.getPackageName().startsWith(ROOT_PACKAGE))
            // flat map classes to fields
            .flatMap(c -> stream(c.getFields()))
            // filter fields of type Late
            .filter(f -> f.getType() == Late.class)
            // map fields to late objects if late doesn't throw an error
            .map(Collector::<T>toLateIfRetrievableElseNull)
            // filter nulls caused by unsuccessful retrievals
            .filter(Objects::nonNull)
            // filter late of elements to document
            .filter(Collector::trueIfToDocumentElseFalse)
            .collect(Collectors.toMap(
                    Late::name,
                    Late::get
                )
            );
    }

    @SuppressWarnings("unchecked")
    static <T extends Link & WithCtElement> Late<T> toLateIfRetrievableElseNull(Field l) {
        try {
            // retrieve late
            var late = (Late<T>) l.get(null);
            // try to retrieve object
            // if successful, element was found in student solution
            late.get();
            // return late because retrieval was successful
            return late;
        } catch (Throwable e) {
            // probably student has not implemented corresponding element
            return null;
        }
    }

    static <T extends Link & WithCtElement> boolean trueIfToDocumentElseFalse(Late<T> late) {
        var link = late.get();
        if (link instanceof FieldLink || link instanceof PackageLink) {
            // filter out field links and package links
            return false;
        }
        if (!(link.reflection() instanceof Method m)) {
            // filter elements excluding methods
            return true;
        }
        // filter non-overridden methods
        var declaringClass = m.getDeclaringClass();
        var methodName = m.getName();
        var parameterTypes = m.getParameterTypes();
        return Stream.concat(
                Stream.of(declaringClass.getSuperclass()),
                Stream.of(declaringClass.getInterfaces())
            )
            // check if there is super type with equal method
            .noneMatch(t -> hasMethod(t, methodName, parameterTypes));
    }

    static boolean hasMethod(Class<?> t, String n, Class<?>[] pt) {
        return stream(t.getMethods()).anyMatch(m -> m.getName().equals(n) && Arrays.equals(m.getParameterTypes(), pt));
    }

    static <T extends Link & WithCtElement> ObjectNode toObjectNode(Entry<String, T> entry) {
        var name = entry.getKey();
        var link = entry.getValue();
        var object = JsonNodeFactory.instance.objectNode();
        object.put("id_tu", ID_TU);
        object.put("expectedName", name);
        object.put("actualName", toName(link.getCtElement()));
        object.put("documentation", link.getCtElement().getDocComment().replaceAll("(\n)+", "\n"));
        return object;
    }

    static String toName(CtElement e) {
        if (e instanceof CtType<?> t) {
            return "class %s".formatted(t.getSimpleName());
        }
        if (e instanceof CtConstructor<?> c) {
            return "constructor %s(%s)".formatted(((CtType<?>) c.getParent()).getSimpleName(), toTypes(c.getParameters()));
        }
        if (e instanceof CtMethod<?> m) {
            return "method %s(%s)".formatted(m.getSimpleName(), toTypes(m.getParameters()));
        }
        return null;
    }

    static String toTypes(List<CtParameter<?>> parameters) {
        return parameters.stream().map(p -> p.getType().getSimpleName()).collect(Collectors.joining(","));
    }

    static Stream<Class<?>> typesAndNestedTypes(Stream<Class<?>> classes) {
        return classes.flatMap(
            c -> Stream.concat(
                Stream.of(c),
                typesAndNestedTypes(Arrays.stream(c.getDeclaredClasses()))
            )
        );
    }
}
