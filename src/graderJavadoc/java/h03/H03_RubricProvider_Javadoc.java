package h03;

import org.sourcegrade.jagr.api.rubric.Criterion;
import org.sourcegrade.jagr.api.rubric.Grader;
import org.sourcegrade.jagr.api.rubric.JUnitTestRef;
import org.sourcegrade.jagr.api.rubric.Rubric;
import org.sourcegrade.jagr.api.rubric.RubricProvider;

public class H03_RubricProvider_Javadoc implements RubricProvider {

    public static final Rubric RUBRIC = Rubric.builder()
        .title("H03 | Multi Family & Synchronizers")
        .addChildCriteria(
            Criterion.builder()
                .shortDescription("Documentation")
                .grader(
                    Grader.testAwareBuilder()
                        .requirePass(JUnitTestRef.ofMethod(() -> Collector.class.getMethod("collect")))
                        .pointsFailedMin()
                        .pointsFailedMax()
                        .build()
                )
                .build()
        )
        .build();

    @Override
    public Rubric getRubric() {
        return RUBRIC;
    }
}
