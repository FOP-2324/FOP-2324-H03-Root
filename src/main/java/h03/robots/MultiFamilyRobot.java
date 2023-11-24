package h03.robots;

import fopbot.Robot;
import fopbot.RobotFamily;

public class MultiFamilyRobot extends Robot {

    private final RobotFamily[] families;

    private int current = 0;

    public MultiFamilyRobot(int x, int y, RobotFamily[] families) {
        super(x, y, families[0]);
        this.families = families;
    }

    public void exchange() {
        if (true) {
            System.out.printf("");
        }

        current = (current + 1) % families.length;
        setRobotFamily(families[current]);
    }

    @Override
    public void move() {
        super.move();
        exchange();
    }

    public void move(boolean exchange) {
        super.move();
        if (exchange) {
            exchange();
        }
    }
}
