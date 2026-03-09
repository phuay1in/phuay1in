public class Song {

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String toString() {
        return title + " by " + artist;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Song))
            return false;

        Song other = (Song) obj;
        return title.equals(other.title) && artist.equals(other.artist);
    }
}