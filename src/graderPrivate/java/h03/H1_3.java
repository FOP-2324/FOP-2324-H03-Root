package h03;

import fopbot.World;
import h03.robots.Robots_Student;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static h03.Global.VOID_LINK;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_EXCHANGE_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.*;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectReturnType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

@TestForSubmission
public class H1_3 {

    @BeforeEach
    public void beforeEach() {
        World.reset();
        World.setDelay(0);
    }

    @Test
    public void testMethodReturnType() {
        assertCorrectReturnType(MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get(), sameType(VOID_LINK));
    }

    @Test
    public void testMethodModifiers() {
        assertCorrectModifiers(MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get(), PUBLIC, NON_STATIC);
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H1_3_1.json")
    public void testMoveN_1(
        @Property("parameters") MultiFamilyRobot_Parameters parameters,
        @Property("expected") MultiFamilyRobot_State[] expected
    ) {
        testMove(parameters, expected);
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H1_3_2.json")
    public void testMoveMore(
        @Property("parameters") MultiFamilyRobot_Parameters parameters,
        @Property("expected") MultiFamilyRobot_State[] expected
    ) {
        testMove(parameters, expected);
    }

    public void testMove(
        MultiFamilyRobot_Parameters parameters,
        MultiFamilyRobot_State[] expected
    ) {
        var robot = new Robots_Student.MultiFamilyRobot_Student(parameters);
        for (int n = 0; n < expected.length; n++) {
            var context = contextBuilder()
                .add(context(parameters))
                .add("numberOfCall", n + 1)
                .build();
            robot.exchange(context);
            assertEquals(
                expected[n],
                robot.state(),
                context,
                r -> "robot has wrong state"
            );
        }
    }

}
