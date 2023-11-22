package h03;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import h03.robots.TutorRobot;
import org.tudalgo.algoutils.tutor.general.match.BasicStringMatchers;
import org.tudalgo.algoutils.tutor.general.match.Matcher;
import org.tudalgo.algoutils.tutor.general.match.Stringifiable;
import org.tudalgo.algoutils.tutor.general.reflections.*;

import java.util.Arrays;

import static h03.Utils.mockX;
import static h03.robots.TutorRobot.TUTOR_ROBOT_LINK;
import static org.mockito.Mockito.doReturn;

public class Global {

    public static final PackageLink H03_LINK = BasicPackageLink.of("h03");

    public static final TypeLink OBJECT_LINK = BasicTypeLink.of(Object.class);

    public static final TypeLink DIRECTION_LINK = BasicTypeLink.of(Direction.class);

    public static final TypeLink VOID_LINK = BasicTypeLink.of(void.class);


    public static final TypeLink INT_LINK = BasicTypeLink.of(int.class);

    public static final TypeLink BOOLEAN_LINK = BasicTypeLink.of(boolean.class);

    public static final MethodLink ROBOT_MOVE = BasicMethodLink.of(
        () -> Robot.class.getMethod("move")
    );

    public static final TypeLink ROBOT_LINK = BasicTypeLink.of(Robot.class);

    public static final TypeLink ROBOT_ARRAY_LINK = BasicTypeLink.of(Robot[].class);

    public static final TypeLink ROBOT_FAMILY_LINK = BasicTypeLink.of(RobotFamily.class);

    public static final TypeLink ROBOT_FAMILY_ARRAY_LINK = BasicTypeLink.of(RobotFamily[].class);


    public static <T extends Stringifiable> Matcher<T> matcher(String name) {
        return BasicStringMatchers.identical(name);
    }

    public static TutorRobot[] createRobots(RobotState... parameters) {
        return Arrays.stream(parameters).map(Global::createRobot).toArray(TutorRobot[]::new);
    }

    public static TutorRobot createRobot(RobotState parameters) {
        return mockX(TUTOR_ROBOT_LINK, parameters.x, parameters.y, parameters.direction);
    }

    public static RobotState createState(Robot robot) {
        return new RobotState(robot.getX(), robot.getY(), robot.getDirection());
    }

    public record RobotState(
        int x,
        int y,
        Direction direction
    ) {
    }
}
