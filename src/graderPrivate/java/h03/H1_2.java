package h03;

import fopbot.World;
import h03.robots.Robots_Student.MultiFamilyRobot_Student;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static h03.Utils.WRONG_STATE_AFTER_INITIALIZATION;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_FAMILIES_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.assertEquals;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.FINAL;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PRIVATE;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

/**
 * H1_2 Tests.
 */
@TestForSubmission
public class H1_2 {

    @BeforeEach
    public void beforeEach() {
        World.reset();
        World.setDelay(0);
    }

    @Test
    public void testConstructorExistence() {
        MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL.get();
    }

    @Test
    public void testConstructorModifiers() {
        assertCorrectModifiers(MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL.get(), PUBLIC);
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H1_2_1.json")
    public void testInitialization1(
        @Property("parameters") MultiFamilyRobot_Parameters parameters,
        @Property("expected") MultiFamilyRobot_State expected
    ) {
        var robot = new MultiFamilyRobot_Student(parameters);
        assertEquals(
            expected,
            robot.state(),
            context(parameters),
            r -> WRONG_STATE_AFTER_INITIALIZATION
        );
    }

    @Test
    public void testConstantExistence() {
        MULTI_FAMILY_ROBOT_FAMILIES_LINK.get();
    }

    @Test
    public void testConstantModifiers() {
        assertCorrectModifiers(MULTI_FAMILY_ROBOT_FAMILIES_LINK.get(), PRIVATE, FINAL, NON_STATIC);
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H1_2_1.json")
    public void testInitialization2(
        @Property("parameters") MultiFamilyRobot_Parameters parameters
    ) {
        var robot = new MultiFamilyRobot_Student(parameters);
        assertEquals(
            parameters.families(),
            robot.families(),
            context(parameters),
            r -> WRONG_STATE_AFTER_INITIALIZATION
        );
    }
}
