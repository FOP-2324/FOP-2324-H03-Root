package h03;

import fopbot.Direction;
import fopbot.Robot;
import h03.robots.Late;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.*;

import java.util.List;

import static h03.Utils.mockX;
import static h03.Global.*;
import static org.tudalgo.algoutils.tutor.general.Messages.UNEXPECTED_EXCEPTION;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.*;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameTypes;

public class RobotSynchronizer_Student {

    public final Object object;

    public static final Late<BasicTypeLink> ROBOT_SYNCHRONIZER_LINK = Late.of(
        "class RobotSynchronizer",
        () -> (BasicTypeLink) assertTypeExists(H03_LINK, matcher("RobotSynchronizer"))
    );

    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_ROBOTS_LINK = Late.of(
        "field robots",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("robots").and(sameType(ROBOT_ARRAY_LINK))
        )
    );

    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_X_LINK = Late.of(
        "field x",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("x").and(sameType(INT_LINK))
        )
    );
    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_Y_LINK = Late.of(
        "field y",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("y").and(sameType(INT_LINK))
        )
    );

    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_DIRECTION_LINK = Late.of(
        "field direction",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("direction").and(sameType(DIRECTION_LINK))
        )
    );

    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_X_LINK = Late.of(
        "method setX(int)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setX").and(sameTypes(INT_LINK))
        )
    );

    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_Y_LINK = Late.of(
        "method setY(int)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setY").and(sameTypes(INT_LINK))
        )
    );

    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK = Late.of(
        "method setDirection(Direction)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setDirection").and(sameTypes(DIRECTION_LINK))
        )
    );

    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SYNC_LINK = Late.of(
        "method sync()",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("sync").and(sameTypes())
        )
    );

    public static final Late<BasicConstructorLink> ROBOT_SYNCHRONIZER_CONSTRUCTOR_LINK = Late.of(
        "constructor RobotSynchronizer(Robot[])",
        () -> (BasicConstructorLink) assertConstructorExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            sameTypes(ROBOT_ARRAY_LINK)
        )
    );

    public static final List<Late<BasicFieldLink>> ROBOT_SYNCHRONIZER_ATTRIBUTE_LINKS = List.of(
        ROBOT_SYNCHRONIZER_X_LINK,
        ROBOT_SYNCHRONIZER_Y_LINK,
        ROBOT_SYNCHRONIZER_DIRECTION_LINK
    );

    public static final List<Late<BasicMethodLink>> ROBOT_SYNCHRONIZER_METHOD_LINKS = List.of(
        ROBOT_SYNCHRONIZER_SET_X_LINK,
        ROBOT_SYNCHRONIZER_SET_Y_LINK,
        ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK
    );

    public RobotSynchronizer_Student(Robot[] robots, Context context) {
        ROBOT_SYNCHRONIZER_CONSTRUCTOR_LINK.get();

        this.object = Assertions2.callObject(
            () -> mockX(ROBOT_SYNCHRONIZER_LINK.get(), (Object) robots),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_CONSTRUCTOR_LINK.get())
                .add(context("robots", context))
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public int x() {
        return ROBOT_SYNCHRONIZER_X_LINK.get().get(object);
    }

    public int y() {
        return ROBOT_SYNCHRONIZER_Y_LINK.get().get(object);
    }

    public Direction direction() {
        return ROBOT_SYNCHRONIZER_DIRECTION_LINK.get().get(object);
    }

    public void setX(int x, Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_X_LINK.get().invoke(object, x),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_X_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public void setY(int y, Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_Y_LINK.get().invoke(object, y),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_Y_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public void setDirection(Direction direction, Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK.get().invoke(object, direction),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public void sync(Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SYNC_LINK.get().invoke(object),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SYNC_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    public Robot[] robots() {
        return ROBOT_SYNCHRONIZER_ROBOTS_LINK.get().get(object);
    }

    public RobotSynchronizerState state() {
        return new RobotSynchronizerState(x(), y(), direction());
    }

    public record RobotSynchronizerState(
        int x,
        int y,
        Direction direction
    ) {
    }

}
