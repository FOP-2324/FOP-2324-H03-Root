package h03.robots;

import fopbot.Direction;
import fopbot.Robot;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;

/**
 * A robot that counts the number of moves and turns.
 */
public class TutorRobot extends Robot {

    /**
     * The number of moves.
     */
    int numberOfMoves = 0;
    /**
     * The number of turns.
     */
    int numberOfTurns = 0;

    /**
     * The TutorRobot class link.
     */
    public static BasicTypeLink TUTOR_ROBOT_LINK = BasicTypeLink.of(TutorRobot.class);

    /**
     * Creates a new TutorRobot.
     *
     * @param x         The x coordinate.
     * @param y         The y coordinate.
     * @param direction The direction.
     */
    public TutorRobot(final int x, final int y, final Direction direction) {
        super(x, y, direction, 0);
    }

    @Override
    public void move() {
        super.move();
        numberOfMoves++;
    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        numberOfTurns++;
    }

    @Override
    public String toString() {
        return "Robot{id=%s, x=%d, y=%d, direction=%s}".formatted(
            this.getId(),
            this.getX(),
            this.getY(),
            this.getDirection()
        );
    }

    /**
     * Gets the number of moves and turns.
     *
     * @return The number of moves and turns.
     */
    public RobotCounters getRobotCounters() {
        return new RobotCounters(numberOfMoves, numberOfTurns);
    }

    /**
     * The number of moves and turns.
     *
     * @param numberOfMoves The number of moves.
     * @param numberOfTurns The number of turns.
     */
    public record RobotCounters(
        int numberOfMoves,
        int numberOfTurns
    ) {
    }
}
