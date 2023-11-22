package h03;

import fopbot.RobotFamily;
import h03.Global.RobotState;
import h03.RobotSynchronizer_Student.RobotSynchronizerState;
import h03.robots.Robots_Student;
import h03.robots.Robots_Student.ChessBoardRobot_Student.ChessBoardRobot_Parameters_1;
import h03.robots.Robots_Student.ChessBoardRobot_Student.ChessBoardRobot_Parameters_2;
import h03.robots.TutorRobot.RobotCounters;
import org.sourcegrade.jagr.api.rubric.*;

import static org.tudalgo.algoutils.tutor.general.stringify.HTML.tt;

public class H03_RubricProvider implements RubricProvider {

    public static final Criterion H1_1_1 = Criterion.builder()
        .shortDescription("Die Klasse %s ist korrekt deklariert.".formatted(tt("MultiFamilyRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_1.class.getMethod("testParentClass")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_1.class.getMethod("testModifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H1_1 = Criterion.builder()
        .shortDescription("H1.1 | First Class")
        .addChildCriteria(
            H1_1_1
        )
        .build();

    public static final Criterion H1_2_1 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ist korrekt deklariert.".formatted(tt("MultiFamilyRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_2.class.getMethod("testConstructorExistence")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_2.class.getMethod("testConstructorModifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H1_2_2 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ruft den Konstruktor der Basisklasse korrekt auf.".formatted("MultiFamilyRobot", "Robot"))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_2.class.getMethod(
                "testInitialization1",
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters.class,
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_State.class)))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H1_2_3 = Criterion.builder()
        .shortDescription("Die Konstante %s ist korrekt deklariert.".formatted("families"))
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_2.class.getMethod("testConstantExistence")))
                .pointsPassedMax()
                .build()
        ).build();

    public static final Criterion H1_2_4 = Criterion.builder()
        .shortDescription("Die Konstante %s wird korrekt initialisiert.".formatted(tt("families")))
        .grader(
            Grader.testAwareBuilder()
                .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_2.class.getMethod(
                    "testInitialization2",
                    Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters.class
                )))
                .pointsPassedMax()
                .build()
        ).build();

    public static final Criterion H1_2 = Criterion.builder()
        .shortDescription("H1.2 | Robot under Construction")
        .addChildCriteria(
            H1_2_1,
            H1_2_2,
            H1_2_3,
            H1_2_4
        )
        .build();

    public static final Criterion H1_3_1 = Criterion.builder()
        .shortDescription("Die Methode %s ist korrekt deklariert.".formatted(tt("exchange")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_3.class.getMethod("testMethodReturnType")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_3.class.getMethod("testMethodModifiers")))
            .pointsPassedMax()
            .build())
        .build();

    public static final Criterion H1_3_2 = Criterion.builder()
        .shortDescription("Die Methode %s funktioniert korrekt, wenn der letzte Index nicht überschritten wird.".formatted(tt("exchange")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_3.class.getMethod(
                "testMoveN_1",
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters.class,
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_State[].class
            )))
            .pointsPassedMax()
            .build())
        .build();


    public static final Criterion H1_3_3 = Criterion.builder()
        .shortDescription("Die Methode %s funktioniert auch korrekt, wenn der letzte Index überschritten wird.".formatted(tt("exchange")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_3.class.getMethod(
                "testMoveMore",
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_Parameters.class,
                Robots_Student.MultiFamilyRobot_Student.MultiFamilyRobot_State[].class
            )))
            .pointsPassedMax()
            .build())
        .build();


    public static final Criterion H1_3 = Criterion.builder()
        .shortDescription("H1.3 | Familientausch")
        .addChildCriteria(H1_3_1)
        .addChildCriteria(H1_3_2)
        .addChildCriteria(H1_3_3)
        .build();

    public static final Criterion H1_4_1 = Criterion.builder()
        .shortDescription("Die Methode %s ist korrekt deklariert.".formatted(tt("move")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_4.class.getMethod("testMethodReturnType")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_4.class.getMethod("testMethodModifiers")))
            .pointsPassedMax()
            .build())
        .build();

    public static final Criterion H1_4_2 = Criterion.builder()
        .shortDescription("Die Methode %s der Basisklasse wird korrekt aufgerufen.".formatted(tt("move")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_4.class.getMethod("testSuperCall")))
            .pointsPassedMax()
            .build())
        .build();

    public static final Criterion H1_4_3 = Criterion.builder()
        .shortDescription("Die Methode %s wird korrekt aufgerufen.".formatted(tt("exchange")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_4.class.getMethod("testExchangeCall")))
            .pointsPassedMax()
            .build())
        .build();

    public static final Criterion H1_4 = Criterion.builder()
        .shortDescription("H1.4 | Nur noch ein Schritt bis zur neuen Familie.")
        .addChildCriteria(
            H1_4_1,
            H1_4_2,
            H1_4_3
        )
        .build();

    public static final Criterion H1_5_1 = Criterion.builder()
        .shortDescription("Die Methode ist korrekt deklariert.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_5.class.getMethod("testMethodReturnType")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_5.class.getMethod("testMethodModifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H1_5_2 = Criterion.builder()
        .shortDescription("Die Methode %s der Basisklasse wird korrekt aufgerufen.".formatted(tt("move")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_5.class.getMethod("testSuperCall")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H1_5_3 = Criterion.builder()
        .shortDescription("Die Methode %s wird korrekt aufgerufen.".formatted(tt("exchange")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H1_5.class.getMethod("testExchangeCall", boolean.class)))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H1_5 = Criterion.builder()
        .shortDescription("H1.5 | Ich möchte bei meiner Familie bleiben!")
        .addChildCriteria(H1_5_1)
        .addChildCriteria(H1_5_2)
        .addChildCriteria(H1_5_3)
        .build();

    public static final Criterion H1 = Criterion.builder()
        .shortDescription("H1 | Multi-Family Robots")
        .addChildCriteria(H1_1)
        .addChildCriteria(H1_2)
        .addChildCriteria(H1_3)
        .addChildCriteria(H1_4)
        .addChildCriteria(H1_5)
        .build();

    public static final Criterion H2_1_1 = Criterion.builder()
        .shortDescription("Die Klasse %s ist korrekt deklariert.".formatted(tt("RGBRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testParentClass")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testModifiers")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H2_1_2 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ist korrekt deklariert.".formatted(tt("RGBRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testConstructorModifiers")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H2_1_3 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ist korrekt implementiert.".formatted(tt("RGBRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testConstructor", boolean.class)))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H2_1_4 = Criterion.builder()
        .shortDescription("Die Methode %s ist korrekt deklariert.".formatted(tt("testRGB")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testTestRGBReturnType")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testTestRGBModifiers")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H2_1_5 = Criterion.builder()
        .shortDescription("Die Methode %s ist korrekt implementiert.".formatted(tt("testRGB")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_1.class.getMethod("testTestRGBImplementation")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H2_1 = Criterion.builder()
        .shortDescription("H2.1 | Rythms of RGB")
        .addChildCriteria(
            H2_1_1,
            H2_1_2,
            H2_1_3,
            H2_1_4,
            H2_1_5
        )
        .build();

    public static final Criterion H2_2_1 = Criterion.builder()
        .shortDescription("Die Klasse %s ist korrekt deklariert.".formatted(tt("ChessBoardRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testClassParentClass")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testClassModifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H2_2_2 = Criterion.builder()
        .shortDescription("Die erste Konstruktor der Klasse %s ist korrekt deklariert.".formatted(tt("ChessBoardRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testConstructor1Modifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H2_2_3 = Criterion.builder()
        .shortDescription("Die erste Konstruktor der Klasse %s ist korrekt implementiert.".formatted(tt("ChessBoardRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testConstructor1Implementation", ChessBoardRobot_Parameters_1.class, RobotFamily[].class)))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H2_2_4 = Criterion.builder()
        .shortDescription("Die zweite Konstruktor der Klasse %s ist korrekt deklariert.".formatted(tt("ChessBoardRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testConstructor2Modifiers")))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H2_2_5 = Criterion.builder()
        .shortDescription("Die zweite Konstruktor der Klasse %s ist korrekt implementiert.".formatted(tt("ChessBoardRobot")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H2_2.class.getMethod("testConstructor2Implementation", ChessBoardRobot_Parameters_2.class, RobotFamily[].class)))
            .pointsPassedMax()
            .build()
        ).build();

    public static final Criterion H2_2 = Criterion.builder()
        .shortDescription("H2.2 | Robo Chess")
        .addChildCriteria(
            H2_2_1,
            H2_2_2,
            H2_2_3,
            H2_2_4,
            H2_2_5
        )
        .build();

    public static final Criterion H2 = Criterion.builder()
        .shortDescription("H2 | Referenzimplementationen")
        .addChildCriteria(H2_1)
        .addChildCriteria(H2_2)
        .build();

    public static final Criterion H3_1_1 = Criterion.builder()
        .shortDescription("Die Klasse %s ist korrekt deklariert.".formatted(tt("RobotSynchronizer")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_1.class.getMethod("testClassParentClass")))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_1.class.getMethod("testClassModifiers")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_1 = Criterion.builder()
        .shortDescription("H3.1 | Bevor wir syncen ...")
        .addChildCriteria(H3_1_1)
        .build();

    public static final Criterion H3_2_1 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ist korrekt deklariert.".formatted(tt("RobotSynchronizer")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_2.class.getMethod("testConstructorModifiers")))
            .pointsPassedMax()
            .build())
        .build();

    public static final Criterion H3_2_2 = Criterion.builder()
        .shortDescription("Der Konstruktor der Klasse %s ist korrekt implementiert.".formatted(tt("RobotSynchronizer")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_2.class.getMethod("testConstructorImplementation")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_2 = Criterion.builder()
        .shortDescription("H3.2 | Wer synct mit?")
        .addChildCriteria(H3_2_1, H3_2_2)
        .build();

    public static final Criterion H3_3_1 = Criterion.builder()
        .shortDescription("Die Attribute %s und Methoden %s sind korrekt deklariert.".formatted(tt("x,y,direction"), tt("set{X,Y,Direction}")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_3.class.getMethod("testMethodModifiers", int.class)))
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_3.class.getMethod("testAttributeModifiers", int.class)))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_3_2 = Criterion.builder()
        .shortDescription("Die Methoden %s sind korrekt implementiert.".formatted("set{X,Y,Direction}"))
        .grader(Grader.testAwareBuilder()
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_3 = Criterion.builder()
        .shortDescription("H3.3 | Was syncen wir?")
        .addChildCriteria(H3_3_1, H3_3_2)
        .build();

    public static final Criterion H3_4_1 = Criterion.builder()
        .shortDescription("Die Methode %s ist korrekt deklariert.".formatted(tt("sync")))
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_4.class.getMethod("testMethodModifiers")))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_4_2 = Criterion.builder()
        .shortDescription("Die Roboter erreichen den festgelegten Zustand.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_4.class.getMethod("testTarget", RobotState[].class, RobotSynchronizerState.class, RobotState[].class)))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_4_3 = Criterion.builder()
        .shortDescription("Die Anzahl an Bewegungen und Drehungen ist minimal.")
        .grader(Grader.testAwareBuilder()
            .requirePass(JUnitTestRef.ofMethod(() -> h03.H3_4.class.getMethod("testRobotCounters", RobotState[].class, RobotSynchronizerState.class, RobotCounters[].class)))
            .pointsPassedMax()
            .build()
        )
        .build();

    public static final Criterion H3_4 = Criterion.builder()
        .shortDescription("H3.4 | I like to sync it, sync it!")
        .addChildCriteria(H3_4_1, H3_4_2, H3_4_3)
        .build();

    public static final Criterion H3 = Criterion.builder()
        .shortDescription("H3 | Sync Star")
        .addChildCriteria(H3_1)
        .addChildCriteria(H3_2)
        .addChildCriteria(H3_3)
        .addChildCriteria(H3_4)
        .build();

    public static final Rubric RUBRIC = Rubric.builder()
        .title("H03 | Multi Family & Synchronizers")
        .addChildCriteria(
            H1,
            H2,
            H3
        )
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
