package chapter1.highlycoupled;

/**
 * 관람객이라는 개념을 구현
 */
public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
