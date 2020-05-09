package chapter12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  과목명과 학생들의 성적을 보관할 리스트(scores)를 인스턴스 변수로 가짐
 */
public class Lecture {
    private int pass; // 최소 이수 점수
    private String title;
    private List<Integer> scores = new ArrayList<>();

    public Lecture(String titleint, int pass, List<Integer> scores) {
        this.pass = pass;
        this.title = title;
        this.scores = scores;
    }

    public double average() {
        return scores.stream()
                    .mapToInt(Integer::intValue)
                    .average().orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long failCount() {
        return scores.size() - passCount();
    }

    private long passCount() {
        return scores.stream().filter(score -> score >= pass).count();
    }

}
