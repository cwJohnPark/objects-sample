package chapter10.music;


// 플레이리스트에서 노래를 삭제할 수 있는 기능이 추가
public class PersonalPlaylist extends Playlist {
    public void remove(Song song) {
        getTracks().remove(song);
        // Playlist가 수정되었으므로 자식 클래스도 수정해야 함
        getSingers().remove(song.getSinger());
    }
}
