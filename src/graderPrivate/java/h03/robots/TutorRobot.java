package h03.robots;

import fopbot.Direction;
import fopbot.Robot;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;

public class TutorRobot extends Robot {

    int numberOfMoves = 0;
    int numberOfTurns = 0;

    public static BasicTypeLink TUTOR_ROBOT_LINK = BasicTypeLink.of(TutorRobot.class);

    public TutorRobot(int x, int y, Direction direction) {
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

    public RobotCounters getRobotCounters() {
        return new RobotCounters(numberOfMoves, numberOfTurns);
    }

    public record RobotCounters(
        int numberOfMoves,
        int numberOfTurns
    ) {
    }
}
