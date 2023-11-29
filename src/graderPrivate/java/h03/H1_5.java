package h03;

import fopbot.RobotFamily;
import fopbot.World;
import h03.robots.Robots_Student.MultiFamilyRobot_Student;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtSuperAccess;

import java.util.stream.Stream;

import static fopbot.RobotFamily.SQUARE_BLACK;
import static fopbot.RobotFamily.SQUARE_WHITE;
import static h03.Global.VOID_LINK;
import static h03.Utils.verifyX;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.emptyContext;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.fail;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectReturnType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.NON_STATIC;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;
import static org.tudalgo.algoutils.tutor.general.stringify.HTML.tt;

/**
 * H1_5 Tests.
 */
@TestForSubmission
public class H1_5 {

    @BeforeEach
    public void beforeEach() {
        World.reset();
        World.setDelay(0);
    }

    @Test
    public void testMethodReturnType() {
        assertCorrectReturnType(MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get(), sameType(VOID_LINK));
    }

    @Test
    public void testMethodModifiers() {
        assertCorrectModifiers(MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get(), PUBLIC, NON_STATIC);
    }

    @Test
    public void testSuperCall() {
        var numberOfCalls = MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get().getCtElement().getDirectChildren().stream()
            .flatMap(e -> (e instanceof CtBlock<?> b) ? b.getDirectChildren().stream() : Stream.of())
            .filter(e -> e instanceof CtInvocation<?>)
            .filter(e -> ((CtInvocation<?>) e).getTarget() instanceof CtSuperAccess<?>)
            .filter(e -> ((CtInvocation<?>) e).getExecutable().getSimpleName().equals("move"))
            .count();
        if (numberOfCalls != 1) {
            fail(
                contextBuilder().subject(MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get()).build(),
                r -> "%s method was not called one time".formatted(tt("super"))
            );
        }
    }

    @ParameterizedTest
    @CsvSource({"false", "true"})
    public void testExchangeCall(
        boolean shouldExchange
    ) {
        var parameters = new MultiFamilyRobot_Parameters(
            2,
            2,
            new RobotFamily[]{SQUARE_WHITE, SQUARE_BLACK}
        );
        var robot = new MultiFamilyRobot_Student(parameters);
        var context = contextBuilder()
            .add(context(parameters))
            .add("shouldExchange", shouldExchange)
            .build();
        verifyX(
            () -> {
                verify(robot.object, times(shouldExchange ? 1 : 0));
                robot.exchange(emptyContext());
            },
            () -> robot.move(shouldExchange, context),
            context,
            r -> "%s method was not called %s".formatted(tt("exchange"), shouldExchange ? "one time" : "zero times")
        );
    }

}
