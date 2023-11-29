package h03.robots;

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

public class Robots_Student {

    public static final Late<PackageLink> ROBOTS_LINK = Late.of(
        "package h03.robots",
        () -> new CombinedPackageLink(
            BasicPackageLink.of("h03"),
            BasicPackageLink.of("h03.robots")
        )
    );

    private Robots_Student() {
    }


    public static class MultiFamilyRobot_Student {

        public final Robot object;

        public static final Late<BasicTypeLink> MULTI_FAMILY_ROBOT_LINK = Late.of(
            "class MultiFamilyRobot",
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("MultiFamilyRobot"))
        );

        public static final Late<BasicConstructorLink> MULTI_FAMILY_ROBOT_CONSTRUCTOR_TL = Late.of(
            "constructor MultiFamilyRobot(int,int,RobotFamily[])",
            () -> (BasicConstructorLink) assertConstructorExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, ROBOT_FAMILY_ARRAY_LINK)
            )
        );

        public static final Late<BasicFieldLink> MULTI_FAMILY_ROBOT_FAMILIES_LINK = Late.of(
            "field families",
            () -> (BasicFieldLink) assertFieldExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<FieldLink>matcher("families").and(sameType(ROBOT_FAMILY_ARRAY_LINK))
            )
        );

        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_EXCHANGE_LINK = Late.of(
            "method exchange()",
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("exchange").and(sameTypes())
            )
        );

        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_MOVE_WITHOUT_PARAMETER_L = Late.of(
            "method move()",
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("move").and(sameTypes())
            )
        );

        public static final Late<BasicMethodLink> MULTI_FAMILY_ROBOT_MOVE_WITH_PARAMETER_L = Late.of(
            "method move(boolean)",
            () -> (BasicMethodLink) assertMethodExists(
                MULTI_FAMILY_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("move").and(sameTypes(BOOLEAN_LINK))
            )
        );

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

        public MultiFamilyRobot_State state() {
            return new MultiFamilyRobot_State(
                object.getX(),
                object.getY(),
                object.getRobotFamily()
            );
        }

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

        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        public record MultiFamilyRobot_Parameters(
            int x,
            int y,
            RobotFamily[] families
        ) {
        }

        public record MultiFamilyRobot_State(
            int x,
            int y,
            RobotFamily family
        ) {
        }
    }

    public static class RGBRobot_Student {

        public final Robot object;

        public static final Late<BasicTypeLink> RGB_ROBOT_LINK = Late.of(
            "class RGBRobot",
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("RGBRobot"))
        );

        public static final Late<BasicConstructorLink> RGB_ROBOT_CONSTRUCTOR_LINK = Late.of(
            "constructor RGBRobot(int,int,boolean)",
            () -> (BasicConstructorLink) assertConstructorExists(
                RGB_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, BOOLEAN_LINK)
            )
        );

        public static final Late<BasicMethodLink> RGB_ROBOT_TEST_RGB_LINK = Late.of(
            "method testRGB()",
            () -> (BasicMethodLink) assertMethodExists(
                RGB_ROBOT_LINK.get(),
                Global.<MethodLink>matcher("testRGB").and(sameTypes())
            )
        );

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

        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        public record RGBRobot_Parameters(
            int x,
            int y,
            boolean inverted
        ) {
        }

    }

    public static class ChessBoardRobot_Student {

        public final Robot object;

        public static final Late<BasicTypeLink> CHESS_BOARD_ROBOT_LINK = Late.of(
            "class ChessBoardRobot",
            () -> (BasicTypeLink) assertTypeExists(ROBOTS_LINK.get(), matcher("ChessBoardRobot"))
        );

        public static final Late<BasicConstructorLink> CHESS_BOARD_ROBOT_CONSTRUCTOR_1_LINK = Late.of(
            "constructor ChessBoardRobot(int,int,RobotFamily,RobotFamily)",
            () -> (BasicConstructorLink) assertConstructorExists(
                CHESS_BOARD_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK, ROBOT_FAMILY_LINK, ROBOT_FAMILY_LINK)
            )
        );

        public static final Late<BasicConstructorLink> CHESS_BOARD_ROBOT_CONSTRUCTOR_2_LINK = Late.of(
            "constructor ChessBoardRobot(int,int)",
            () -> (BasicConstructorLink) assertConstructorExists(
                CHESS_BOARD_ROBOT_LINK.get(),
                sameTypes(INT_LINK, INT_LINK)
            )
        );

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

        public RobotFamily[] families() {
            return MULTI_FAMILY_ROBOT_FAMILIES_LINK.get().get(object);
        }

        public record ChessBoardRobot_Parameters_1(
            int x,
            int y,
            RobotFamily even,
            RobotFamily odd
        ) {
        }

        public record ChessBoardRobot_Parameters_2(
            int x,
            int y
        ) {
        }
    }
}
