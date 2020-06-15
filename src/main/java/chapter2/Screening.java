package chapter2;

import java.time.LocalDateTime;

/**
 * 영화를 예매하는 사건을 형상화
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Movie getMovie() {
        return movie;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }
}
