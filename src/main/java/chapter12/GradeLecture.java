package chapter12;

import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 *  Lecture의 출력 결과에 대한 등급별 통계
 */
public class GradeLecture extends Lecture {
    private List<Grade> grades;

    public GradeLecture(String name, int pass, List<Grade> grades, List<Integer> scores) {
        super(name, pass, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradeStatistics();
    }

    private String gradeStatistics() {
        return grades.stream()
                    .map(grade -> format(grade))
                    .collect(joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                        .filter(grade::include)
                        .count();
    }

    public double average(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                    .filter(grade::include)
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(0);
    }

    // self의 참조, 동적 메서드 탐색
    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }

}
