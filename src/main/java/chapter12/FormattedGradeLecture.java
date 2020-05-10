package chapter12;

import java.util.List;

/**
 * super 참조를 이용해 메시지를 전송
 * 단순히 부모클래스가 아닌, 더 상위에 위치한 조상 클래스의 메소드일 수 있음
 */
public class FormattedGradeLecture extends GradeLecture {
    public FormattedGradeLecture(String name, int pass, List<Grade> grades, List<Integer> scores) {
        super(name, pass, grades, scores);
    }

    public String formatAverage() {
        return String.format("Avg: %1.f", super.average());
    }
}
