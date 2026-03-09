import java.io.*;
import java.util.Scanner;
import java.util.ListIterator;
public class SpotifyManager {

    private GenericLinkedList<User> users;

    public SpotifyManager() {
        users = new GenericLinkedList<>();
    }
    
    public GenericLinkedList<User> getUsers() {
        return users;
    }
    
    public void loadUsersFromFile(String filename)
            throws IOException, InvalidUserFormatException {

        Scanner file = new Scanner(new File(filename));

        User currentUser = null;
        Playlist currentPlaylist = null;

        while (file.hasNextLine()) {

            String line = file.nextLine().trim();

            if (line.startsWith("username:")) {
                String username = line.substring(9).trim();

                String passwordLine = file.nextLine().trim();
                if (!passwordLine.startsWith("password:"))
                    throw new InvalidUserFormatException();

                String password = passwordLine.substring(9).trim();

                currentUser = new User(username, password);
                users.addLast(currentUser);
            }

            else if (line.startsWith("playlist:")) {
                String name = line.substring(9).trim();
                currentPlaylist = new Playlist(name);
                currentUser.addPlaylist(currentPlaylist);
            }

            else if (line.startsWith("song:")) {
                String songData = line.substring(5).trim();
                String[] parts = songData.split("-");

                String title = parts[0].trim();
                String artist = parts[1].trim();

                Song song = new Song(title, artist);
                currentPlaylist.addSong(song);
            }
        }

        file.close();
    }

    public User findUser(String username, String password)
            throws UserNotFoundException, InvalidPasswordException {

        ListIterator<User> it = users.iterator();

        while (it.hasNext()) {
            User u = it.next();

            if (u.getUsername().equals(username)) {
                if (!u.getPassword().equals(password))
                    throw new InvalidPasswordException();

                return u;
            }
        }
        
        throw new UserNotFoundException();
    }
}