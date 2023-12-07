package h03;

import fopbot.RobotFamily;
import fopbot.World;
import h03.robots.MultiFamilyRobot;
import h03.robots.Robots_Student;
import h03.robots.Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters;
import org.junit.jupiter.api.Test;

import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.emptyContext;

/**
 * Main entry point in executing the program.
 */
public class Main {

    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(final String[] args) throws Throwable {

        final var robot = new MultiFamilyRobot(0, 0, new RobotFamily[]{RobotFamily.SQUARE_AQUA, RobotFamily.SQUARE_BLACK});
        System.out.println(robot);

    }

    @Test
    public void test() {
        World.reset();
        final var robot = new Robots_Student.MultiFamilyRobot_Student(
            new MultiFamilyRobot_Parameters(0, 0, new RobotFamily[]{RobotFamily.SQUARE_AQUA, RobotFamily.SQUARE_BLACK})
        );
        System.out.println(robot.object.getRobotFamily());
        robot.super_move(emptyContext());
        System.out.println(robot.object.getRobotFamily());

    }
}
