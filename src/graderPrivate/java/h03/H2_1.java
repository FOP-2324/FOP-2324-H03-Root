package h03;

import fopbot.RobotFamily;
import fopbot.World;
import h03.robots.Robots_Student.RGBRobot_Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;

import java.util.List;

import static fopbot.RobotFamily.SQUARE_BLUE;
import static fopbot.RobotFamily.SQUARE_GREEN;
import static fopbot.RobotFamily.SQUARE_RED;
import static h03.Global.VOID_LINK;
import static h03.Utils.verifyX;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_LINK;
import static h03.robots.Robots_Student.RGBRobot_Student.RGBRobot_Parameters;
import static h03.robots.Robots_Student.RGBRobot_Student.RGB_ROBOT_CONSTRUCTOR_LINK;
import static h03.robots.Robots_Student.RGBRobot_Student.RGB_ROBOT_LINK;
import static h03.robots.Robots_Student.RGBRobot_Student.RGB_ROBOT_TEST_RGB_LINK;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.emptyContext;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectReturnType;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectSuperType;
import static org.tudalgo.algoutils.tutor.general.match.BasicMatchers.equalObject;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;
import static org.tudalgo.algoutils.tutor.general.stringify.HTML.tt;

@TestForSubmission
public class H2_1 {

    @BeforeEach
    public void beforeEach() {
        World.reset();
        World.setDelay(0);
    }

    @Test
    public void testParentClass() {
        assertCorrectSuperType(
            RGB_ROBOT_LINK.get(),
            equalObject(MULTI_FAMILY_ROBOT_LINK.get())
        );
    }

    @Test
    public void testModifiers() {
        assertCorrectModifiers(
            RGB_ROBOT_LINK.get(),
            PUBLIC
        );
    }

    @Test
    public void testConstructorModifiers() {
        assertCorrectModifiers(
            RGB_ROBOT_CONSTRUCTOR_LINK.get(),
            PUBLIC
        );
    }

    @ParameterizedTest
    @CsvSource({"false", "true"})
    public void testConstructor(final boolean inverted) {
        final var parameters = new RGBRobot_Parameters(
            1,
            1,
            inverted
        );
        final var robot = new RGBRobot_Student(parameters);
        final var families = !inverted
                       ? new RobotFamily[]{SQUARE_RED, SQUARE_GREEN, SQUARE_BLUE}
                       : new RobotFamily[]{SQUARE_BLUE, SQUARE_GREEN, SQUARE_RED};
        assertEquals(
            List.of(families),
            List.of(robot.families()),
            Assertions2.contextBuilder()
                .subject(RGB_ROBOT_CONSTRUCTOR_LINK)
                .add(context(parameters))
                .build(),
            r -> "wrong array of robot families"
        );
    }

    @Test
    public void testTestRGBReturnType() {
        assertCorrectReturnType(RGB_ROBOT_TEST_RGB_LINK.get(), sameType(VOID_LINK));
    }

    @Test
    public void testTestRGBModifiers() {
        assertCorrectModifiers(RGB_ROBOT_TEST_RGB_LINK.get(), PUBLIC, NON_STATIC);
    }

    @Test
    public void testTestRGBImplementation() {
        final var parameters = new RGBRobot_Parameters(
            1,
            1,
            false
        );
        final var robot = new RGBRobot_Student(parameters);
        verifyX(
            () -> {
                verify(robot.object, times(3));
                robot.exchange(emptyContext());
            },
            () -> robot.testRGB(context(parameters)),
            context(parameters),
            r -> "method %s was not called three times".formatted(tt("exchange"))
        );
    }
}

