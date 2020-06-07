package chapter2;

/**
 * 순번 할인 조건
 * 상영 순번과 일치할 경우 할인이 가능한 것으로 판단한다.
 */
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
