package chapter12;

/**
 * 등급의 이름, 각 등급 범위를 정의하는 최소 성적과 최대 성적을 인스턴스 변수로 가짐
 */
public class Grade {
    private String name;
    private int upper, lower;

    public Grade(String name, int upper, int lower) {
        this.name = name;
        this.upper = upper;
        this.lower = lower;
    }

    public String getName() {
        return name;
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    /**
     * 수강생의 성적이 등급에 포함되는지를 검사함
     */
    public boolean include(int score) {
        return score >= lower && score <= upper;
    }
}
