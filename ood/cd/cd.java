package cd;

public class User {
	 private String name;
	 public String getName() { return name; }
	 public void setName(String name) { this.name }
	 public long getlD() { return ID; }
	 public void setID(long ID) { ID = iD; }
	 private long ID;
	 public User(String name, long iD) { … }
	 public User getUser() { return this; }
	 public static User addUser(String name, long iD) { ... }
	 }
	 
	 public class CD {
	 /* data for id, artist, songs, etc */ }

	public class Song {
	 /* data for id, CD (could be null), title, length, etc */
	 }
	 
	 
	 public class Playlist {
	 private Song song;
	 private Queue<Song> queue;
	 public Playlist(Song song, Queue<Song> queue) {
	 …
	 }
	 public Song getNextSToPlayQ {
	 return queue. peek();
	 }
	 public void queueUpSong(Song s) {
	 queue. add(s); }
	 }
	 
	 
	 class CDPlayer {
	 private Playlist p;
	 private CD c;

	/* Constructors. */
	 public CDPlayer(CD c, Playlist p) { ... }
	 public CDPlayer(Playlist p) { this.p = p; }
	 public CDPlayer(CD c) { this.c = c; }

	 /* Play song */
	 public void playSong(Song s) { ... }

	 /* Getters and setters */
	 public Playlist getPlaylist() { return p; }
	 public void setPlaylist(Playlist p) { this.p = p; }

	 public CD getCD() { return c; }
	 public void setCD(CD c) { this.c = c; }
	 }