package chatper11;

import java.util.Collection;
import java.util.Set;

/**
 * 메소드 오버라이딩의 오작용 문제를 합성관계로 해결
 * 불필요한 오퍼레이션들이 퍼블릭 인터페이스에 존재하지 않음
 * 하지만, HashSet의 퍼블릭 인터페이스를 똑같이 제공해야 함
 */
public class InstrumentedHashSet<E> {
    private int addCount = 0;
    private Set<E> set;

    public InstrumentedHashSet(Set<E> set) {
        this.set = set;
    }
    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return set.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }
}
