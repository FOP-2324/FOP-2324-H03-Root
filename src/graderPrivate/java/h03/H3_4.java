package h03;

import fopbot.World;
import h03.Global.RobotState;
import h03.RobotSynchronizer_Student.RobotSynchronizerState;
import h03.robots.TutorRobot.RobotCounters;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;

import java.util.Arrays;

import static h03.Global.createRobots;
import static h03.Global.createState;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

/**
 * H3_4 Tests.
 */
@TestForSubmission
public class H3_4 {

    public static final int W = 10;
    public static final int H = 10;

    @BeforeAll
    public static void beforeAll() {
        World.reset();
        World.setDelay(0);
        World.setSize(10, 10);
    }

    @Test
    public void testMethodModifiers() {
        assertCorrectModifiers(
            RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_SYNC_LINK.get(),
            PUBLIC
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H3_4_1.json")
    public void testTarget(
        @Property("robots") final RobotState[] robotParameters,
        @Property("parameters") final RobotSynchronizerState parameters,
        @Property("expected") final RobotState[] expected
    ) {
        final var robots = createRobots(robotParameters);
        final var context = contextBuilder()
            .add("worldWidth", W)
            .add("worldHeight", H)
            .add(context(parameters))
            .add("robots", Arrays.toString(robots))
            .build();
        final var synchronizer = new RobotSynchronizer_Student(Arrays.copyOf(robots, robots.length), context);
        if (parameters.x() != -1) {
            synchronizer.setX(parameters.x(), context);
        }
        if (parameters.y() != -1) {
            synchronizer.setY(parameters.y(), context);
        }
        if (parameters.direction() != null) {
            synchronizer.setDirection(parameters.direction(), context);
        }
        synchronizer.sync(context);
        for (int i = 0; i < robots.length; i++) {
            final int j = i;
            Assertions2.assertEquals(
                expected[i],
                createState(robots[i]),
                context,
                r -> "robot %s is not synced correctly".formatted(robots[j].getId())
            );
        }
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H3_4_2.json")
    public void testRobotCounters(
        @Property("robots") final RobotState[] initialRobotStates,
        @Property("parameters") final RobotSynchronizerState parameters,
        @Property("expected") final RobotCounters[] expectedRobotCounters
    ) {
        final var robots = createRobots(initialRobotStates);
        final var context = contextBuilder()
            .add("worldWidth", W)
            .add("worldHeight", H)
            .add(context(parameters))
            .add("robots", Arrays.toString(robots))
            .build();
        final var synchronizer = new RobotSynchronizer_Student(Arrays.copyOf(robots, robots.length), context);
        synchronizer.setX(parameters.x(), context);
        synchronizer.setY(parameters.y(), context);
        synchronizer.setDirection(parameters.direction(), context);
        synchronizer.sync(context);
        for (int i = 0; i < robots.length; i++) {
            final int j = i;
            Assertions2.assertEquals(
                expectedRobotCounters[i],
                robots[i].getRobotCounters(),
                context,
                r -> "robot %s does not move/turn as often as expected".formatted(robots[j].getId())
            );
        }
    }
}
