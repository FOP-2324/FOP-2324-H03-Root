package h03;

import fopbot.Direction;
import fopbot.Robot;
import h03.Global.RobotState;
import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions3;

import java.util.List;

import static h03.Global.createRobot;
import static h03.RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_ROBOTS_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.emptyContext;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

/**
 * H3_2 Tests.
 */
@TestForSubmission
public class H3_2 {

    @Test
    public void testConstructorModifiers() {
        Assertions3.assertCorrectModifiers(
            RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_CONSTRUCTOR_LINK.get(),
            PUBLIC
        );
    }

    @Test
    public void testConstructorImplementation() {
        ROBOT_SYNCHRONIZER_ROBOTS_LINK.get();
        final var robots = new Robot[]{
            createRobot(new RobotState(1, 1, Direction.UP)),
            createRobot(new RobotState(2, 2, Direction.RIGHT)),
            createRobot(new RobotState(3, 3, Direction.DOWN)),
            createRobot(new RobotState(4, 4, Direction.LEFT)),
        };
        final var listOfRobots = List.of(robots);
        final var synchronizer = new RobotSynchronizer_Student(robots, emptyContext());
        Assertions2.assertEquals(
            listOfRobots,
            List.of(synchronizer.robots()),
            contextBuilder()
                .subject(ROBOT_SYNCHRONIZER_ROBOTS_LINK.get())
                .add("robots", robots)
                .build(),
            r -> "robot array is not correctly assigned"
        );
    }
}
