package h03;

import fopbot.Direction;
import static fopbot.Direction.*;
import fopbot.Robot;
import fopbot.World;

public class RobotSynchronizer {

    private final Robot[] robots;
    private int x = -1, y = -1;
    private Direction direction = null;

    public RobotSynchronizer(Robot[] robots) {
        this.robots = robots;
    }

    public void setX(int x) {
        if (x >= 0 && x < World.getWidth()) {
            this.x = x;
        }
    }

    public void setY(int y) {
        if (y >= 0 && y < World.getHeight()) {
            this.y = y;
        }
    }

    public void setDirection(Direction direction) {
        if (direction != null) {
            this.direction = direction;
        }
    }

    public void sync() {
        for (Robot r : robots) {
            int goalX = this.x != -1 ? this.x : r.getX();
            int goalY = this.y != -1 ? this.y : r.getY();
            Direction goalDir = this.direction != null ? this.direction : r.getDirection();
            while (true) {
                while (
                    r.getDirection() == UP && r.getY() < goalY ||
                        r.getDirection() == RIGHT && r.getX() < goalX ||
                        r.getDirection() == DOWN && r.getY() > goalY ||
                        r.getDirection() == LEFT && r.getX() > goalX
                ) {
                    r.move();
                }
                if (goalDir == r.getDirection() && r.getX() == goalX && r.getY() == goalY) break;
                r.turnLeft();
            }
        }
    }

}
