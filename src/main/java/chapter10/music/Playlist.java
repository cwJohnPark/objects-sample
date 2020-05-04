package chapter10.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 트랙에 노래를 추가할 수 있음
// 가수의 이름을 키로 노래의 제목을 추가하도록 요구사항 변경
public class Playlist {
    private List<Song> tracks = new ArrayList<>();
    private Map<String, String> singers = new HashMap<>();

    public void append(Song song) {
        tracks.add(song);
        singers.put(song.getSinger(), song.getTitle());
    }

    public List<Song> getTracks() {
        return tracks;
    }

    public Map<String, String> getSingers() {
        return singers;
    }
}
