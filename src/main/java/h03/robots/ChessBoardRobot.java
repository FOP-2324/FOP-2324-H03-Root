package h03.robots;

import fopbot.RobotFamily;

public class ChessBoardRobot extends MultiRobot {

    public ChessBoardRobot(int x, int y, RobotFamily even, RobotFamily odd) {
        super(x, y, (x + y) % 2 == 0 ? new RobotFamily[]{even, odd} : new RobotFamily[]{odd, even});
    }

    public ChessBoardRobot(int x, int y) {
        this(x, y, RobotFamily.SQUARE_BLACK, RobotFamily.SQUARE_WHITE);
    }
}
