package h03;

import org.junit.jupiter.api.Test;
import org.sourcegrade.jagr.api.rubric.TestForSubmission;
import org.tudalgo.algoutils.tutor.general.reflections.Modifier;

import static h03.FOPBot.ROBOT_TL;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_LINK;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectModifiers;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertCorrectSuperType;
import static org.tudalgo.algoutils.tutor.general.match.TypeMatchers.sameSuperType;

@TestForSubmission
public class H1_1 {

    @Test
    public void testParentClass() {
        assertCorrectSuperType(MULTI_FAMILY_ROBOT_LINK.get(), sameSuperType(ROBOT_TL));
    }

    @Test
    public void testModifiers() {
        assertCorrectModifiers(MULTI_FAMILY_ROBOT_LINK.get(), Modifier.PUBLIC);
    }
}
