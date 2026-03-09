public class User {

    private String username;
    private String password;
    private GenericLinkedList<Playlist> playlists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        playlists = new GenericLinkedList<>();
    }

    public void addPlaylist(Playlist playlist) {
        playlists.addLast(playlist);
    }

    public int getPlaylistCount() {
        return playlists.size();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public GenericLinkedList<Playlist> getPlaylists() {
        return playlists;
    }
}