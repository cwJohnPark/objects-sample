package chapter2;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 기간 할인 조건
 * 영화 상영 요일(월,화,수..)이 요일 (dayOfWeek)과 같고
 * 영화 상영 시작 시간이 시작 시간 (startTime)에서 종료 시간 (endTime) 사이에 위치할 경우,
 * 할인할 수 있는 것으로 판단한다.
 */
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        // 시작 시간 기준
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
            startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
            endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;

    }


}
