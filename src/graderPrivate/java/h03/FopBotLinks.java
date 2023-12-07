package h03;

import fopbot.Robot;
import fopbot.RobotFamily;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;
import org.tudalgo.algoutils.tutor.general.reflections.TypeLink;

/**
 * Fopbot Type Links.
 */
public class FopBotLinks {

    /**
     * The {@link Robot} type link.
     */
    public static final TypeLink ROBOT_TL = BasicTypeLink.of(Robot.class);

    /**
     * The {@link RobotFamily} type link.
     */
    public static final TypeLink ROBOT_FAMILY_ARRAY_TL = BasicTypeLink.of(RobotFamily[].class);
}
