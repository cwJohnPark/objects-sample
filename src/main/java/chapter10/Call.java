package chapter10;

import java.time.Duration;
import java.time.LocalDateTime;

// 중복 코드 살펴보기

/**
 * 전화 요금을 계산하는 애플리케이션
 * 통화 시간을 단위 시간당 요금으로 나눈다.
 */
public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
