package edu.virginia.cs2110;

/* Adarsh Solanki + Kevin Yoon
 * as5nr + kdy4es
 * Homework 1
 * CS 2110-101
 */
public class Song implements Comparable<Song>{

	private String artist;
	private String title;
	private int minutes;
	private int seconds;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public Song(String title, String artist, int minutes, int seconds) {
		this.title = title;
		this.artist = artist;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public Song(Song s){
		this.title = s.title;
		this.artist = s.artist;
		this.minutes = s.minutes;
		this.seconds = s.seconds;
		
	}
	
	public boolean equals(Object o) {
		if (o instanceof Song) {
			Song s = (Song) o;
			if ((this.title.equals(s.title)) && (this.artist.equals(s.artist)) && (this.minutes == s.minutes) &&(this.seconds == s.seconds)){
				return true;
			} 
		}  return false;
			
	}
	
	public String toString() {
		return ("{Song: title=" + title + " artist: " + artist + "}");
	}
	
	public void play() {
		System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	}

	@Override
	public int compareTo(Song s) {
		int artistCmp = artist.compareTo(s.artist);
		int titleCmp = title.compareTo(s.title);
		int minutesCmp = (this.minutes - s.minutes > 0 ? 1 : 0);
		int secondsCmp = (this.seconds - s.seconds > 0 ? 1 : 0);
		
		if (artistCmp == 0) {
			if (titleCmp == 0) {
				if (minutesCmp == 0) {
					if (secondsCmp == 0) {
						return 0;
					} else return secondsCmp;
				} else return minutesCmp;
			} else return titleCmp;
		
		} else return artistCmp;
	
	}
	
}
