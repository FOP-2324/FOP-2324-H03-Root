package h03;

import fopbot.RobotFamily;
import fopbot.World;
import h03.robots.Robots_Student.ChessBoardRobot_Student;
import h03.robots.Robots_Student.ChessBoardRobot_Student.ChessBoardRobot_Parameters_1;
import h03.robots.Robots_Student.ChessBoardRobot_Student.ChessBoardRobot_Parameters_2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;

import java.util.List;

import static h03.robots.Robots_Student.ChessBoardRobot_Student.CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK;
import static h03.robots.Robots_Student.ChessBoardRobot_Student.CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK;
import static h03.robots.Robots_Student.ChessBoardRobot_Student.CHESS_BOARD_ROBOT_LINK;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectSuperType;
import static org.tudalgo.algoutils.tutor.general.match.TypeMatchers.sameSuperType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

/**
 * H2_2 Tests.
 */
@TestForSubmission
public class H2_2 {

    @BeforeEach
    public void beforeEach() {
        World.reset();
        World.setDelay(0);
    }

    @Test
    public void testClassParentClass() {
        assertCorrectSuperType(
            CHESS_BOARD_ROBOT_LINK.get(),
            sameSuperType(MULTI_FAMILY_ROBOT_LINK.get())
        );
    }

    @Test
    public void testClassModifiers() {
        assertCorrectModifiers(
            CHESS_BOARD_ROBOT_LINK.get(),
            PUBLIC
        );
    }

    @Test
    public void testConstructor1Modifiers() {
        assertCorrectModifiers(
            CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK.get(),
            PUBLIC
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H2_2_1.json")
    public void testConstructor1Implementation(
        @Property("parameters") final ChessBoardRobot_Parameters_1 parameters,
        @Property("expected") final RobotFamily[] expected
    ) {
        final var robot = new ChessBoardRobot_Student(parameters);
        Assertions2.assertEquals(
            List.of(expected),
            List.of(robot.families()),
            contextBuilder()
                .subject(CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK.get())
                .add(context(parameters))
                .build(),
            r -> "wrong array of robot families"
        );
    }

    @Test
    public void testConstructor2Modifiers() {
        assertCorrectModifiers(
            CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK.get(),
            PUBLIC
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H2_2_2.json")
    public void testConstructor2Implementation(
        @Property("parameters") final ChessBoardRobot_Parameters_2 parameters,
        @Property("expected") final RobotFamily[] expected
    ) {
        final var robot = new ChessBoardRobot_Student(parameters);
        Assertions2.assertEquals(
            List.of(expected),
            List.of(robot.families()),
            contextBuilder()
                .subject(CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK.get())
                .add(context(parameters))
                .build(),
            r -> "wrong array of robot families"
        );
    }
}
