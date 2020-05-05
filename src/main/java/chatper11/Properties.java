package chatper11;

import java.util.Hashtable;

/**
 * 불필요한 인터페이스 상속 문제
 * 클라이언트는 오직 Properties에서 정한 오퍼레이션만 사용할 수 있다.
 */
public class Properties {
    private Hashtable<String, String> properties = new Hashtable<>();


    public String setProperty(String key, String value) {
        return properties.put(key, value);
    }
    public String getProperty(String key) {
        return properties.get(key);
    }
}
