package h03.robots;

import fopbot.RobotFamily;

/**
 * A {@link ChessBoardRobot} is a {@link MultiFamilyRobot} with a sequence of <emph>exactly</emph> two robot families.
 * The robot family to use initially is determined by the position of the robot on the chess board
 * so that filling a field with chess board robots of the same tuple of robot families will result in a chess board pattern.
 */
public class ChessBoardRobot extends MultiFamilyRobot {

    /**
     * Constructs a {@link ChessBoardRobot} on the given position with the given robot families for even and odd fields.
     * A field is even (and otherwise odd), if the sum of its x- and y-coordinate is even.
     *
     * @param x    the position on the x-axis
     * @param y    the position on the y-axis
     * @param even the robot family to use for even fields
     * @param odd  the robot family to use for odd fields
     */
    public ChessBoardRobot(int x, int y, RobotFamily even, RobotFamily odd) {
        super(x, y, (x + y) % 2 == 0 ? new RobotFamily[] {even, odd} : new RobotFamily[] {odd, even});
    }

    /**
     * Constructs a {@link ChessBoardRobot} on the given position.
     * For even fields, the robot family {@link RobotFamily#SQUARE_BLACK} will be used.
     * for odd fields, the robot family {@link RobotFamily#SQUARE_WHITE} will be used.
     *
     * @param x the position on the x-axis
     * @param y the position on the y-axis
     */
    public ChessBoardRobot(int x, int y) {
        this(x, y, RobotFamily.SQUARE_BLACK, RobotFamily.SQUARE_WHITE);
    }
}
