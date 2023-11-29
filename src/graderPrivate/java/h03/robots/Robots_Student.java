package h03.robots;

import fopbot.Robot;
import fopbot.RobotFamily;
import h03.CombinedPackageLink;
import h03.Global;
import h03.Utils;
import org.tudalgo.algoutils.tutor.general.assertions.Assertions2;
import org.tudalgo.algoutils.tutor.general.assertions.Context;
import org.tudalgo.algoutils.tutor.general.reflections.BasicConstructorLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicFieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicMethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicPackageLink;
import org.tudalgo.algoutils.tutor.general.reflections.BasicTypeLink;
import org.tudalgo.algoutils.tutor.general.reflections.FieldLink;
import org.tudalgo.algoutils.tutor.general.reflections.MethodLink;
import org.tudalgo.algoutils.tutor.general.reflections.PackageLink;

import static h03.Global.BOOLEAN_LINK;
import static h03.Global.INT_LINK;
import static h03.Global.ROBOT_FAMILY_ARRAY_LINK;
import static h03.Global.ROBOT_FAMILY_LINK;
import static h03.Global.ROBOT_MOVE;
import static h03.Global.matcher;
import static h03.Utils.mockX;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_EXCHANGE_LINK;
import static h03.robots.Robots_Student.MultiFamilyRobot_Student.MULTI_FAMILY_ROBOT_FAMILIES_LINK;
import static org.tudalgo.algoutils.tutor.general.Messages.UNEXPECTED_EXCEPTION;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.context;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions2.contextBuilder;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertConstructorExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertFieldExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertMethodExists;
import static org.tudalgo.algoutils.tutor.general.assertions.Assertions3.assertTypeExists;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameType;
import static org.tudalgo.algoutils.tutor.general.match.BasicReflectionMatchers.sameTypes;

/**
 * A unit test for testing the Student Robot classes.
 */
public class Robots_Student {

    /**
     * A PackageLink to the h03.robots package.
     */
    public static final Late<PackageLink> ROBOTS_LINK = Late.of(
        () -> new CombinedPackageLink(
            BasicPackageLink.of("h03"),
            BasicPackageLink.of("h03.robots")
        )
    );

    /**
     * Don't instantiate this class.
     */
    private Robots_Student() {
    }

    /**
     * A unit test for testing the MultiFamilyRobot student class.
     */
    public static class MultiFamilyRobot_Student {

        /**
         * The MultiFamilyRobot class.
         */
        public final Robot object;

        /**
         * The MultiFamilyRobot class link.
         */
        public static final Late<BasicTypeLink> MULTI_FAMILY_ROBOT_LINK = Late.of(
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("MultiFamilyRobot"))
        );

        /**
         * The MultiFamilyRobot#constructor link.
         */
        public static final Late<BasicConstructorLink> MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL = Late.of(
            () -> (BasicConstructorLink) assertConstructorExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, ROBOT_FAMILY_ARRAY_LINK)
            )
        );

        /**
         * The MultiFamilyRobot#families field link.
         */
        public static final Late<BasicFieldLink> MULTI_FAMILY_ROBOT_FAMILIES_LINK = Late.of(
            () -> (BasicFieldLink) assertFieldExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<FieldLink>matcher("families").and(sameType(ROBOT_FAMILY_ARRAY_LINK))
            )
        );

        /**
         * The MultiFamilyRobot#exchange method link.
         */
        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_EXCHANGE_LINK = Late.of(
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("exchange").and(sameTypes())
            )
        );

        /**
         * The MultiFamilyRobot#move method link without parameter matching.
         */
        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_MOVE_WITHOUT_PARAMETER_L = Late.of(
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("move").and(sameTypes())
            )
        );

        /**
         * The MultiFamilyRobot#move method link with parameter matching.
         */
        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L = Late.of(
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("move").and(sameTypes(BOOLEAN_LINK))
            )
        );

        /**
         * Creates a new MultiFamilyRobot_Student.
         *
         * @param values the parameters to initialize the MultiFamilyRobot with
         */
        public MultiFamilyRobot_Student(MultiFamilyRobot_Parameters values) {
            MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL.get();
            var object = Assertions2.callObject(
                () -> mockX(MULTI_FAMILY_ROBOT_LINK.get(), values.x, values.y, values.families),
                contextBuilder()
                    .subject(MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL.get())
                    .add(context(values))
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
            this.object = Utils.assertIsInstance(object, Robot.class);
        }

        /**
         * Returns the state of the MultiFamilyRobot.
         *
         * @return the state of the MultiFamilyRobot
         */
        public MultiFamilyRobot_State state() {
            return new MultiFamilyRobot_State(
                object.getX(),
                object.getY(),
                object.getRobotFamily()
            );
        }

        /**
         * Calls the move method of the Robot.
         *
         * @param context the test context
         */
        public void super_move(Context context) {
            Assertions2.call(
                () -> ROBOT_MOVE.invoke(object),
                contextBuilder()
                    .subject(ROBOT_MOVE)
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Calls the move method of the MultiFamilyRobot.
         *
         * @param context the test context
         */
        public void move(Context context) {
            Assertions2.call(
                () -> MULTI_FAMILY_ROBOT_MOVE_WITHOUT_PARAMETER_L.get().invoke(object),
                contextBuilder()
                    .subject(MULTI_FAMILY_ROBOT_MOVE_WITHOUT_PARAMETER_L.get())
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Calls the move method of the MultiFamilyRobot.
         *
         * @param shouldExchange whether the robot should exchange
         * @param context        the test context
         */
        public void move(boolean shouldExchange, Context context) {
            Assertions2.call(
                () -> MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get().invoke(object, shouldExchange),
                contextBuilder()
                    .subject(MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L.get())
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Calls the exchange method of the MultiFamilyRobot.
         *
         * @param context the test context
         */
        public void exchange(Context context) {
            Assertions2.call(
                () -> MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get().invoke(object),
                contextBuilder()
                    .subject(MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get())
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Returns the families of the MultiFamilyRobot.
         *
         * @return the families of the MultiFamilyRobot
         */
        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        /**
         * The parameters to initialize a MultiFamilyRobot.
         *
         * @param x        the x coordinate
         * @param y        the y coordinate
         * @param families the families
         */
        public record MultiFamilyRobot_Parameters(
            int x,
            int y,
            RobotFamily[] families
        ) {
        }

        /**
         * The state of a MultiFamilyRobot.
         *
         * @param x      the x coordinate
         * @param y      the y coordinate
         * @param family the family
         */
        public record MultiFamilyRobot_State(
            int x,
            int y,
            RobotFamily family
        ) {
        }
    }

    /**
     * A unit test for testing the RGBRobot student class.
     */
    public static class RGBRobot_Student {

        /**
         * The RGBRobot class.
         */
        public final Robot object;

        /**
         * The RGBRobot class link.
         */
        public static final Late<BasicTypeLink> RGB_ROBOT_LINK = Late.of(
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("RGBRobot"))
        );

        /**
         * The RGBRobot#constructor link.
         */
        public static final Late<BasicConstructorLink> RGB_ROBOT_CONSTRUCTOR_LINK = Late.of(
            () -> (BasicConstructorLink) assertConstructorExists(
                RGB_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, BOOLEAN_LINK)
            )
        );

        /**
         * The RGBRobot#testRGB method link.
         */
        public static final Late<BasicMethodLink> RGB_ROBOT_TEST_RGB_LINK = Late.of(
            () -> (BasicMethodLink) assertMethodExists(
                RGB_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("testRGB").and(sameTypes())
            )
        );

        /**
         * Creates a new RGBRobot_Student.
         *
         * @param values the parameters to initialize the RGBRobot with
         */
        public RGBRobot_Student(RGBRobot_Parameters values) {
            RGB_ROBOT_CONSTRUCTOR_LINK.get();
            var object = Assertions2.callObject(
                () -> mockX(RGB_ROBOT_LINK.get(), values.x, values.y, values.inverted),
                contextBuilder()
                    .subject(RGB_ROBOT_CONSTRUCTOR_LINK.get())
                    .add(context(values))
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
            this.object = Utils.assertIsInstance(object, Robot.class);
        }

        /**
         * Tests that the RGBRobot#testRGB was declared correctly.
         */
        public void testRGB(Context context) {
            Assertions2.call(
                () -> RGB_ROBOT_TEST_RGB_LINK.get().invoke(object),
                contextBuilder()
                    .subject(RGB_ROBOT_TEST_RGB_LINK.get())
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Calls the exchange method of the RGBRobot.
         *
         * @param context the test context
         */
        public void exchange(Context context) {
            Assertions2.call(
                () -> MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get().invoke(object),
                contextBuilder()
                    .subject(MULTI_FAMILY_ROBOT_EXCHANGE_LINK.get())
                    .add(context)
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
        }

        /**
         * Returns the families of the RGBRobot.
         *
         * @return the families of the RGBRobot
         */
        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        /**
         * The parameters to initialize a RGBRobot.
         *
         * @param x        the x coordinate
         * @param y        the y coordinate
         * @param inverted whether the robot is inverted
         */
        public record RGBRobot_Parameters(
            int x,
            int y,
            boolean inverted
        ) {
        }

    }

    /**
     * A unit test for testing the ChessBoardRobot student class.
     */
    public static class ChessBoardRobot_Student {

        /**
         * The ChessBoardRobot class.
         */
        public final Robot object;

        /**
         * The ChessBoardRobot class link.
         */
        public static final Late<BasicTypeLink> CHESS_BOARD_ROBOT_LINK = Late.of(
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("ChessBoardRobot"))
        );

        /**
         * The ChessBoardRobot#constructor link.
         */
        public static final Late<BasicConstructorLink> CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK = Late.of(
            () -> (BasicConstructorLink) assertConstructorExists(
                CHESS_BOARD_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, ROBOT_FAMILY_LINK, ROBOT_FAMILY_LINK)
            )
        );

        /**
         * The other ChessBoardRobot#constructor link.
         */
        public static final Late<BasicConstructorLink> CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK = Late.of(
            () -> (BasicConstructorLink) assertConstructorExists(
                CHESS_BOARD_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK)
            )
        );

        /**
         * Creates a new ChessBoardRobot_Student.
         *
         * @param parameters the parameters to initialize the ChessBoardRobot with
         */
        public ChessBoardRobot_Student(ChessBoardRobot_Parameters_1 parameters) {
            CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK.get();
            var object = Assertions2.callObject(
                () -> mockX(CHESS_BOARD_ROBOT_LINK.get(), parameters.x, parameters.y, parameters.even, parameters.odd),
                contextBuilder()
                    .subject(CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK.get())
                    .add(context(parameters))
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
            this.object = Utils.assertIsInstance(object, Robot.class);
        }

        /**
         * Creates a new ChessBoardRobot_Student.
         *
         * @param parameters the parameters to initialize the ChessBoardRobot with
         */
        public ChessBoardRobot_Student(ChessBoardRobot_Parameters_2 parameters) {
            CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK.get();
            var object = Assertions2.callObject(
                () -> mockX(CHESS_BOARD_ROBOT_LINK.get(), parameters.x, parameters.y),
                contextBuilder()
                    .subject(CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK.get())
                    .add(context(parameters))
                    .build(),
                r -> UNEXPECTED_EXCEPTION
            );
            this.object = Utils.assertIsInstance(object, Robot.class);
        }

        /**
         * Returns the families of the ChessBoardRobot.
         *
         * @return the families of the ChessBoardRobot
         */
        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        /**
         * The parameters to initialize a ChessBoardRobot.
         *
         * @param x    the x coordinate
         * @param y    the y coordinate
         * @param even the even family
         * @param odd  the odd family
         */
        public record ChessBoardRobot_Parameters_1(
            int x,
            int y,
            RobotFamily even,
            RobotFamily odd
        ) {
        }

        /**
         * The parameters to initialize a ChessBoardRobot.
         *
         * @param x the x coordinate
         * @param y the y coordinate
         */
        public record ChessBoardRobot_Parameters_2(
            int x,
            int y
        ) {
        }
    }
}
