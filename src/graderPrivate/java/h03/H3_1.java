package h03;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;

import static h03.Global.OBJECT_LINK;
import static h03.RobotSynchronizer_Student.ROBOT_SYNCHRONIZER_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectSuperType;
import static org.tudalgo.algoutils.tutor.general.match.TypeMatchers.sameSuperType;
import static org.tudalgo.algoutils.tutor.general.reflections.Modifier.PUBLIC;

/**
 * H3_1 Tests.
 */
@TestForSubmission
public class H3_1 {

    @Test
    public void testClassParentClass() {
        assertCorrectSuperType(
            ROBOT_SYNCHRONIZER_LINK.get(),
            sameSuperType(OBJECT_LINK)
        );
    }

    @Test
    public void testClassModifiers() {
        assertCorrectModifiers(
            ROBOT_SYNCHRONIZER_LINK.get(),
            PUBLIC
        );
    }
}
