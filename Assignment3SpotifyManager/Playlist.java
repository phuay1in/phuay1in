import java.util.ListIterator;

public class Playlist {

    private String name;
    private GenericLinkedList<Song> songs;
    private ListIterator<Song> iterator;
    private Song currentSong;

    public Playlist(String name) {
        this.name = name;
        songs = new GenericLinkedList<>();
        iterator = songs.iterator();
    }

    public boolean addSong(Song song) {
    	if (isEmpty())
    		currentSong = song;
        songs.addLast(song);
        iterator = songs.iterator();
        return true;
    }

    public String getName() {
    	return name;
    }
    
    public Song getCurrentSong() {
        return currentSong;
    }

    public int getSize() {
        return songs.size();
    }

    public GenericLinkedList<Song> getSongs() {
        return songs;
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public Song nextSong() {
        if (iterator.hasNext()) {
            currentSong = iterator.next();
            return currentSong;
        }
        return null;
    }

    public Song previousSong() {
        if (iterator.hasPrevious()) {
            currentSong = iterator.previous();
            return currentSong;
        }
        return null;
    }

    public boolean removeSong(Song song) {
        ListIterator<Song> it = songs.iterator();

        while (it.hasNext()) {
            Song s = it.next();
            if (s.equals(song)) {
                it.remove();
                return true;
            }
        }

        return false;
    }
}