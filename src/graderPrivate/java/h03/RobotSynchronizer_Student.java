package h03;

import fopbot.Direction;
import fopbot.Robot;
import h03.robots.Late;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.BasicConstructorLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicFieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicMethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;

import java.util.List;

import static h03.Global.DIRECTION_LINK;
import static h03.Global.H03_LINK;
import static h03.Global.INT_LINK;
import static h03.Global.ROBOT_ARRAY_LINK;
import static h03.Global.matcher;
import static h03.Utils.mockX;
import static org.tudalgo.algoutils.tutor.general.Messages.UNEXPECTED_EXCEPTION;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertConstructorExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertFieldExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertMethodExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameTypes;

/**
 * A unit test for testing the RobotSynchronizer student class.
 */
public class RobotSynchronizer_Student {

    /**
     * The RobotSynchronizer class.
     */
    public final Object object;

    /**
     * The RobotSynchronizer class link.
     */
    public static final Late<BasicTypeLink> ROBOT_SYNCHRONIZER_LINK = Late.of(
        "class RobotSynchronizer",
        () -> (BasicTypeLink) assertTypeExists(H03_LINK, matcher("RobotSynchronizer"))
    );

    /**
     * The RobotSynchronizer#robots field link.
     */
    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_ROBOTS_LINK = Late.of(
        "field robots",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("robots").and(sameType(ROBOT_ARRAY_LINK))
        )
    );

    /**
     * The RobotSynchronizer#x field link.
     */
    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_X_LINK = Late.of(
        "field x",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("x").and(sameType(INT_LINK))
        )
    );

    /**
     * The RobotSynchronizer#y field link.
     */
    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_Y_LINK = Late.of(
        "field y",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("y").and(sameType(INT_LINK))
        )
    );

    /**
     * The RobotSynchronizer#direction field link.
     */
    public static final Late<BasicFieldLink> ROBOT_SYNCHRONIZER_DIRECTION_LINK = Late.of(
        "field direction",
        () -> (BasicFieldLink) assertFieldExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<FieldLink>matcher("direction").and(sameType(DIRECTION_LINK))
        )
    );

    /**
     * The {@link RobotSynchronizer#setX(int)} method link.
     */
    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_X_LINK = Late.of(
        "method setX(int)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setX").and(sameTypes(INT_LINK))
        )
    );

    /**
     * The {@link RobotSynchronizer#setY(int)} method link.
     */
    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_Y_LINK = Late.of(
        "method setY(int)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setY").and(sameTypes(INT_LINK))
        )
    );

    /**
     * The {@link RobotSynchronizer#setDirection(Direction)} method link.
     */
    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK = Late.of(
        "method setDirection(Direction)",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("setDirection").and(sameTypes(DIRECTION_LINK))
        )
    );

    /**
     * The {@link RobotSynchronizer#sync()} method link.
     */
    public static final Late<BasicMethodLink> ROBOT_SYNCHRONIZER_SYNC_LINK = Late.of(
        "method sync()",
        () -> (BasicMethodLink) assertMethodExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            Global.<MethodLink>matcher("sync").and(sameTypes())
        )
    );

    /**
     * The {@link RobotSynchronizer#RobotSynchronizer(Robot[])} constructor link.
     */
    public static final Late<BasicConstructorLink> ROBOT_SYNCHRONIZER_CONSTRUCTOR_LINK = Late.of(
        "constructor RobotSynchronizer(Robot[])",
        () -> (BasicConstructorLink) assertConstructorExists(
            ROBOT_SYNCHRONIZER_LINK.get(),
            sameTypes(ROBOT_ARRAY_LINK)
        )
    );

    /**
     * The RobotSynchronizer attribute links.
     */
    public static final List<Late<BasicFieldLink>> ROBOT_SYNCHRONIZER_ATTRIBUTE_LINKS = List.of(
        ROBOT_SYNCHRONIZER_X_LINK,
        ROBOT_SYNCHRONIZER_Y_LINK,
        ROBOT_SYNCHRONIZER_DIRECTION_LINK
    );

    /**
     * The RobotSynchronizer method links.
     */
    public static final List<Late<BasicMethodLink>> ROBOT_SYNCHRONIZER_METHOD_LINKS = List.of(
        ROBOT_SYNCHRONIZER_SET_X_LINK,
        ROBOT_SYNCHRONIZER_SET_Y_LINK,
        ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK
    );

    /**
     * Creates a new RobotSynchronizer_Student instance.
     *
     * @param robots  the robots to synchronize
     * @param context the context
     */
    public RobotSynchronizer_Student(final Robot[] robots, final Context context) {
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

    /**
     * Returns the x coordinate of the robot.
     *
     * @return the x coordinate of the robot
     */
    public int x() {
        return ROBOT_SYNCHRONIZER_X_LINK.get().get(object);
    }

    /**
     * Returns the y coordinate of the robot.
     *
     * @return the y coordinate of the robot
     */
    public int y() {
        return ROBOT_SYNCHRONIZER_Y_LINK.get().get(object);
    }

    /**
     * Returns the direction of the robot.
     *
     * @return the direction of the robot
     */
    public Direction direction() {
        return ROBOT_SYNCHRONIZER_DIRECTION_LINK.get().get(object);
    }

    /**
     * Sets the x coordinate of the robot.
     *
     * @param x       the x coordinate of the robot
     * @param context the context
     */
    public void setX(final int x, final Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_X_LINK.get().invoke(object, x),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_X_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    /**
     * Sets the y coordinate of the robot.
     *
     * @param y       the y coordinate of the robot
     * @param context the context
     */
    public void setY(final int y, final Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_Y_LINK.get().invoke(object, y),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_Y_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    /**
     * Sets the direction of the robot.
     *
     * @param direction the direction of the robot
     * @param context   the context
     */
    public void setDirection(final Direction direction, final Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK.get().invoke(object, direction),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SET_DIRECTION_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    /**
     * Synchronizes the robots.
     *
     * @param context the context
     */
    public void sync(final Context context) {
        Assertions2.call(
            () -> ROBOT_SYNCHRONIZER_SYNC_LINK.get().invoke(object),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_SYNC_LINK.get())
                .add(context)
                .build(),
            r -> UNEXPECTED_EXCEPTION
        );
    }

    /**
     * Returns the robots.
     *
     * @return the robots
     */
    public Robot[] robots() {
        return ROBOT_SYNCHRONIZER_ROBOTS_LINK.get().get(object);
    }

    /**
     * Returns the state of the robot.
     *
     * @return the state of the robot
     */
    public RobotSynchronizerState state() {
        return new RobotSynchronizerState(x(), y(), direction());
    }

    /**
     * The state of the robot.
     *
     * @param x         the x coordinate
     * @param y         the y coordinate
     * @param direction the direction
     */
    public record RobotSynchronizerState(
        int x,
        int y,
        Direction direction
    ) {
    }

}
