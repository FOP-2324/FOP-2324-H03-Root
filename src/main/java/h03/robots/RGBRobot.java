package h03.robots;

import fopbot.RobotFamily;

import static fopbot.RobotFamily.*;

public class RGBRobot extends MultiFamilyRobot {

    private static final RobotFamily[] RGB = new RobotFamily[]{SQUARE_RED, SQUARE_GREEN, SQUARE_BLUE};
    private static final RobotFamily[] BRG = new RobotFamily[]{SQUARE_BLUE, SQUARE_GREEN, SQUARE_RED};

    public RGBRobot(int x, int y, boolean inverted) {
        super(x, y, !inverted ? RGB : BRG);
    }

    public RGBRobot(int x, int y) {
        this(x, y, false);
    }

    public void testRGB() {
        for (int i = 0; i < 3; i++) {
            exchange();
        }
    }
}
