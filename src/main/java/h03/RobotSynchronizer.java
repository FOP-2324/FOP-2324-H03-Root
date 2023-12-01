package h03;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.World;

import static fopbot.Direction.DOWN;
import static fopbot.Direction.LEFT;
import static fopbot.Direction.RIGHT;
import static fopbot.Direction.UP;


/**
 * A {@link RobotSynchronizer} is used to synchronize the position and direction of each robot of a set of robots
 * with a given position and direction.
 */

public class RobotSynchronizer {

    /**
     * The set of robots to synchronize.
     */
    private final Robot[] robots;
    /**
     * The position on the x-axis to sync the robots with.
     */
    private int x = -1;
    /**
     * The position on the y-axis to sync the robots with.
     */
    private int y = -1;
    /**
     * The {@link Direction} to sync the robots with.
     */
    private Direction direction = null;

    /**
     * Constructs a {@link RobotSynchronizer} for the given set of robots.
     *
     * @param robots the set of robots
     */
    public RobotSynchronizer(final Robot[] robots) {
        this.robots = robots;
    }

    /**
     * Sets the position on the x-axis to sync the robots with.
     * If an invalid position is passed, the position will leave unchanged.
     *
     * @param x the position on the x-axis
     */
    public void setX(final int x) {
        if (x >= 0 && x < World.getWidth()) {
            this.x = x;
        }
    }

    /**
     * Sets the position on the y-axis to sync the robots with.
     * If an invalid position is passed, the position will leave unchanged.
     *
     * @param y the position on the y-axis
     */
    public void setY(final int y) {
        if (y >= 0 && y < World.getHeight()) {
            this.y = y;
        }
    }

    /**
     * Sets the direction to sync the robots with.
     * If <code>null</code> is passed, the direction will leave unchanged.
     *
     * @param direction the direction
     */
    public void setDirection(final Direction direction) {
        if (direction != null) {
            this.direction = direction;
        }
    }

    /**
     * Syncs each robot of the set of robots with the given position and direction.
     * If the position on the x- or y-axis or the direction is not set,
     * the current position/direction of the corresponding robot will be used instead.
     */
    public void sync() {
        for (final Robot r : robots) {
            final int goalX = this.x != -1 ? this.x : r.getX();
            final int goalY = this.y != -1 ? this.y : r.getY();
            final Direction goalDir = this.direction != null ? this.direction : r.getDirection();
            while (true) {
                while (
                    r.getDirection() == UP && r.getY() < goalY
                        || r.getDirection() == RIGHT && r.getX() < goalX
                        || r.getDirection() == DOWN && r.getY() > goalY
                        || r.getDirection() == LEFT && r.getX() > goalX
                ) {
                    r.move();
                }
                if (goalDir == r.getDirection() && r.getX() == goalX && r.getY() == goalY) {
                    break;
                }
                r.turnLeft();
            }
        }
    }

}
