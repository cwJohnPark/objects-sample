package chatper11;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * 벡터를 상속받지 않고 인스턴스 변수로 선언(합성)함
 * @param <E>
 */
public class Stack<E> {
    private Vector<E> elements = new Vector<>();

    public E push(E item) {
        elements.addElement(item);
        return item;
    }
    public E pop() {
        if(elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

}
