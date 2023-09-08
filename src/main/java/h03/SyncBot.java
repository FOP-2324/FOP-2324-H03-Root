package h03;

import fopbot.Direction;
import fopbot.Robot;

public class SyncBot {

    private final Robot[] robots;
    private int x = -1, y = -1;
    private Direction direction;

    public SyncBot(Robot[] robots) {
        this.robots = robots;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void sync() {
        for (Robot robot : robots) {
            Direction direction = this.direction != null ? this.direction : robot.getDirection();
            while (robot.getX() != x || robot.getY() != y || robot.getDirection() != direction) {
                while (
                    y != -1 && robot.getDirection() == Direction.UP && y > robot.getY() ||
                        x != -1 && robot.getDirection() == Direction.RIGHT && x > robot.getX() ||
                        y != -1 && robot.getDirection() == Direction.DOWN && y < robot.getY() ||
                        x != -1 && robot.getDirection() == Direction.LEFT && x < robot.getX()
                ) {
                    robot.move();
                }
                robot.turnLeft();
            }
        }
    }

}
