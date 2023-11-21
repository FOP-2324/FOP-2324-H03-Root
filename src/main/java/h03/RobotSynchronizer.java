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

            Direction xDir = r.getX() == goalX ? r.getDirection() : (r.getX() < goalX ? RIGHT : LEFT);
            Direction yDir = r.getY() == goalY ? r.getDirection() : (r.getY() < goalY ? UP : DOWN);

            final int nDirs = Direction.values().length;
            int turnsToX = Math.floorMod(r.getDirection().ordinal() - xDir.ordinal(), nDirs);
            int turnsToY = Math.floorMod(r.getDirection().ordinal() - yDir.ordinal(), nDirs);

            boolean xBeforeY = turnsToX < turnsToY;
            if (xBeforeY) {
                while (r.getDirection() != xDir) r.turnLeft();
                while (r.getX() != goalX) r.move();
            }
            while (r.getDirection() != yDir) r.turnLeft();
            while (r.getY() != goalY) r.move();
            if (!xBeforeY) {
                while (r.getDirection() != xDir) r.turnLeft();
                while (r.getX() != goalX) r.move();
            }

            while (r.getDirection() != goalDir) r.turnLeft();
        }
    }

}
