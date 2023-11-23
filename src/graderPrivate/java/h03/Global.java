package h03;

import fopbot.Direction;
import fopbot.Robot;
import fopbot.RobotFamily;
import h03.robots.TutorRobot;
import org.tudalgo.algoutils.reflect.TestUtils;
import org.tudalgo.algoutils.tutor.general.match.Match;
import org.tudalgo.algoutils.tutor.general.match.Matcher;
import org.tudalgo.algoutils.tutor.general.match.Stringifiable;
import org.tudalgo.algoutils.tutor.general.reflections.*;
import org.tudalgo.algoutils.tutor.general.stringify.HTML;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static h03.Utils.mockX;
import static h03.robots.TutorRobot.TUTOR_ROBOT_LINK;
import static java.lang.Math.max;
import static org.tudalgo.algoutils.tutor.general.stringify.HTML.it;

public class Global {

    private static final double MINIMUM_SIMILARITY = .8;

    public static final PackageLink H03_LINK = BasicPackageLink.of("h03");

    public static final TypeLink OBJECT_LINK = BasicTypeLink.of(Object.class);

    public static final TypeLink DIRECTION_LINK = BasicTypeLink.of(Direction.class);

    public static final TypeLink VOID_LINK = BasicTypeLink.of(void.class);


    public static final TypeLink INT_LINK = BasicTypeLink.of(int.class);

    public static final TypeLink BOOLEAN_LINK = BasicTypeLink.of(boolean.class);

    public static final MethodLink ROBOT_MOVE = BasicMethodLink.of(
        () -> Robot.class.getMethod("move")
    );

    public static final TypeLink ROBOT_LINK = BasicTypeLink.of(Robot.class);

    public static final TypeLink ROBOT_ARRAY_LINK = BasicTypeLink.of(Robot[].class);

    public static final TypeLink ROBOT_FAMILY_LINK = BasicTypeLink.of(RobotFamily.class);

    public static final TypeLink ROBOT_FAMILY_ARRAY_LINK = BasicTypeLink.of(RobotFamily[].class);

    public static int MISSPELLING_COUNTER = 0;

    public static final List<String> MISSPELLINGS = new ArrayList<>();

    public static String misspellings() {
        if (MISSPELLING_COUNTER == 0) {
            return "";
        }
        return it("The following names are misspelled in your solution:\n") +
            MISSPELLINGS.stream().sorted().map(HTML::tt).collect(Collectors.joining("\n"));
    }

    public static <T extends Stringifiable> Matcher<T> matcher(String string) {
        return new Matcher<T>() {

            double maxSimilarity = 0;

            @Override
            public Object object() {
                return string;
            }

            @Override
            public <ST extends T> Match<ST> match(ST object) {

                return new Match<>() {

                    final double similarity = TestUtils.similarity(object.string(), string);

                    {
                        if (matched()) {
                            if (maxSimilarity == 0 && similarity != 1) {
                                MISSPELLING_COUNTER++;
                                MISSPELLINGS.add(string);
                            } else if (maxSimilarity != 0 && maxSimilarity != 1 && similarity == 1) {
                                MISSPELLING_COUNTER--;
                                MISSPELLINGS.remove(string);
                            }
                            maxSimilarity = max(maxSimilarity, similarity);
                        }
                    }

                    @Override
                    public boolean matched() {
                        return similarity >= MINIMUM_SIMILARITY;
                    }

                    @Override
                    public ST object() {
                        return object;
                    }

                    @Override
                    public int compareTo(Match<ST> other) {
                        if (!other.matched()) {
                            return matched() ? 1 : 0;
                        } else if (!matched()) {
                            return -1;
                        }
                        double otherSimilarity = TestUtils.similarity(other.object().string(), string);
                        return Double.compare(similarity, otherSimilarity);
                    }
                };
            }
        };
    }

    public static TutorRobot[] createRobots(RobotState... parameters) {
        return Arrays.stream(parameters).map(Global::createRobot).toArray(TutorRobot[]::new);
    }

    public static TutorRobot createRobot(RobotState parameters) {
        return mockX(TUTOR_ROBOT_LINK, parameters.x, parameters.y, parameters.direction);
    }

    public static RobotState createState(Robot robot) {
        return new RobotState(robot.getX(), robot.getY(), robot.getDirection());
    }

    public record RobotState(
        int x,
        int y,
        Direction direction
    ) {
    }
}
