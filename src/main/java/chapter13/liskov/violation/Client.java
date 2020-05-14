package chapter13.liskov.violation;

/**
 * 리스코프 치환 원칙을 위반하는 아래의 코드는 실패한다.
 * 직사각형(Rectangle)은 높이와 너비가 다를 수 있는 행동을 갖지만,
 * 정사각형(Square)는 높이와 너비가 같도록 하는 행동을 갖는다.
 */
public class Client {

    public static void resize(Rectangle rectangle, int width, int height) {
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        assert rectangle.getWidth() == width && rectangle.getHeight() == height;
    }

    public static void main(String[] args) {
        Square square = new Square(10, 10, 10);
        resize(square, 50, 100);
    }
}
