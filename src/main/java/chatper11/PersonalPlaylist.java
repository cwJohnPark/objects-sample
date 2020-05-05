package chatper11;

import chapter10.music.Playlist;
import chapter10.music.Song;

/**
 * 부모 클래스와 자식 클래스의 동시 수정 문제
 */
public class PersonalPlaylist {
    private Playlist playlist = new Playlist();

    public void append(Song song) {
        playlist.append(song);
    }
    public void remove(Song song) {
        playlist.getTracks().remove(song);
        playlist.getSingers().remove(song.getSinger());
    }
}
