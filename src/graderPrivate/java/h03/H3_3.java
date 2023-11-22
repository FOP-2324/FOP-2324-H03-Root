package h03;

import fopbot.World;
import h03.Global.RobotState;
import h03.RobotSynchronizer_Student.RobotSynchronizerState;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junitpioneer.jupiter.json.JsonClasspathSource;
import org.junitpioneer.jupiter.json.Property;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;

import static h03.Global.createRobots;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PRIVATE;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

@SuppressWarnings("ResultOfMethodCallIgnored")
@TestForSubmission
public class H3_3 {

    public static final int W = 10;
    public static final int H = 10;

    @BeforeAll
    public static void beforeAll() {
        World.reset();
        World.setSize(10, 10);
        World.setDelay(0);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    public void testMethodModifiers(int i) {
        assertCorrectModifiers(
            RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_METHOD_LINKS.get(i).get(),
            PUBLIC
        );
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "2"})
    public void testAttributeModifiers(int i) {
        assertCorrectModifiers(
            RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_ATTRIBUTE_LINKS.get(i).get(),
            PRIVATE
        );
    }

    @ParameterizedTest
    @JsonClasspathSource("h03/H3_3_1.json")
    public void testImplementation(
        @Property("robots") RobotState[] robotParameters,
        @Property("parameters") RobotSynchronizerState parameters,
        @Property("expected") RobotSynchronizerState expected
    ) {
        var context = contextBuilder()
            .add("worldWidth", W)
            .add("worldHeight", H)
            .add(context(parameters))
            .build();
        var synchronizer = new RobotSynchronizer_Student(createRobots(robotParameters), context);
        synchronizer.setX(parameters.x(), context);
        synchronizer.setY(parameters.y(), context);
        synchronizer.setDirection(parameters.direction(), context);
        Assertions2.assertEquals(
            expected,
            synchronizer.state(),
            context,
            r -> "values are not correctly are assigned"
        );
    }
}
