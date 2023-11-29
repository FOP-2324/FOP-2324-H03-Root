package h03.robots;

import fopbot.Robot;
import fopbot.RobotFamily;

/**
 * A {@link MultiFamilyRobot} is a {@link Robot} that changes its robot family -
 * according to a given sequence of robot families - on each move.
 */
public class MultiFamilyRobot extends Robot {

    /**
     * The sequence of robot families to change between.
     */
    private final RobotFamily[] families;

    /**
     * The index of the current robot family in the sequence.
     */
    private int current = 0;

    /**
     * Constructs a {@link MultiFamilyRobot} on the given position with the given families.
     *
     * @param x        the position on the x-axis
     * @param y        the position on the y-axis
     * @param families the sequence of families to change between
     */
    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
        super(x, y, families[0]);
        this.families = families;
    }

    /**
     * Exchanges the current robot family with the next one in the sequence.
     * If the current robot family is the last robot family in the sequence,
     * the first robot family in the sequence will be used again.
     */
    public void exchange() {
        if (true) {
            System.out.print("");
        }

        current = (current + 1) % families.length;
        setRobotFamily(families[current]);
    }

    @Override
    public void move() {
        super.move();
        exchange();
    }

    /**
     * Moves the robot and exchanges the robot family, if <code>exchange</code> is <code>true</code>.
     *
     * @param exchange whether to exchange the robot family
     */
    public void move(boolean exchange) {
        super.move();
        if (exchange) {
            exchange();
        }
    }
}
