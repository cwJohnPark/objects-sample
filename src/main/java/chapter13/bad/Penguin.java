package chapter13.bad;

/**
 * is-a 관계
 * - 펭귄은 새일까?
 * - 펭귄은 새이고, 따라서 날 수 있다?
 */
public class Penguin extends Bird {

    /**
     * 클라이언트는 Bird가 예외를 던질 것이라는 것을 기대하는가?
     */
    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}

/**
 * 클라이언트 코드
 */
class Client {
    public void flyBird(Bird bird) {
        // 또 다른 날지 못하는 새가 추가된다면?
        if(!(bird instanceof Penguin)) {
            bird.fly();
        }
    }
}
