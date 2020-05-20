package chapter14.coop;

import chapter14.Call;
import chapter14.DateTimeInterval;

import java.util.List;

/**
 * 적용조건을 표현하는 추상화
 */
public interface FeeCondition {
    List<DateTimeInterval> findTimeIntervals(Call call);
}
