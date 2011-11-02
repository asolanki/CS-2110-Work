package edu.virginia.cs2110;

/* Adarsh Solanki + Kevin Yoon
 * as5nr + kdy4es
 * Homework 1
 * CS 2110-101
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlayList {

	private String name;
	private ArrayList<Song> songList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Song> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}

	public PlayList() {
		name = "Untitled";
		songList = new ArrayList<Song>();
	}

	public PlayList(String name) {
		this.name = name;
		songList = new ArrayList<Song>();
	}

	public boolean loadSongs(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		try {
			scan = new Scanner(file);

			while (scan.hasNext()) {
				String title = null;
				String artist = null;
				int minutes = -1;
				int seconds = -1;
				
				
					
				String s = scan.nextLine();
				
				if (!(s.equalsIgnoreCase(""))) {
					
					
					

					if (title == null) {
						
						trimmer(s);
						title = s;
					}
					if (artist == null) {
						try {
							s = scan.nextLine();
							trimmer(s);
							artist = s;
						} catch (Exception e) {
							break;
						}
						
					}
					if (minutes == -1) {
						s = scan.nextLine();
						trimmer(s);
						String[] s1 = s.split(":");
						int min = Integer.parseInt(s1[0]);
						int sec = Integer.parseInt(s1[1]);
						
						while (sec>= 60) {
							sec = sec - 60;
							min++;
						}
						
						
						
						

						minutes = min;
						seconds = sec;
					}
					

					if (!(seconds == -1)) {
						Song s1 = new Song(title, artist, minutes, seconds);
						addSong(s1);
					}
					
					
					
				}
				
				
				
				
			}

			return true;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			return false;
		}

		
	}

	private void trimmer(String s) {
		if (s == "") {
			return;
		} else {
			s = s.trim();
			if (s.contains("//")){
				s = s.substring(s.indexOf("//"));
			}
		}

	}

	public boolean clear() {
		songList.clear();
		return true;
	}

	public boolean addSong(Song s) {
		songList.add(s);
		return true;
	}

	public Song removeSong(int index) {
		songList.trimToSize();
		if (index > songList.size()) {
			return null;
		}
		Song s = songList.get(index);
		songList.remove(index);
		return s;
	}

	public Song removeSong(Song s) {
		songList.trimToSize();
		if (songList.contains(s)) {
			songList.remove(s);
			return s;
		}
		return null;

	}
	
	public Song getSong(int index){
		songList.trimToSize();
		if(songList.size() >= index){
			return songList.get(index);
		}else
			return null;
	}
	
	public void sortByArtist(){
		Collections.sort(songList);
	}
	
	public void play(){
		for (Song s : songList) {
			s.play();
		}
	}
	
	public int size(){
		songList.trimToSize();
		return songList.size();
	}
	
	public String totalPlayTime() {
		int tempHours = 0;
		int tempMinutes = 0;
		int tempSeconds = 0;
		
		for (Song s : songList) {
			tempMinutes += s.getMinutes();
			tempSeconds += s.getSeconds();
		}
		
		while (tempSeconds>= 60) {
			tempSeconds = tempSeconds - 60;
			tempMinutes++;
		}
		while (tempMinutes >= 60) {
			tempMinutes = tempMinutes-60;
			tempHours++;
		}
		return tempHours+":"+tempMinutes+":"+tempSeconds;
	}
	
	
	
	
	public static void main(String[] args) {
		PlayList p = new PlayList();
		p.loadSongs("sample.txt");
		System.out.println(p.getSongList());
		p.sortByArtist();
		System.out.println(p.totalPlayTime());
		p.clear();
		System.out.println(p.getSongList());
	}
	
	
}

/*
 * 

 * 
 * public void sortByArtist() // sorts the class's song list by artist, and then
 * by title if the artists are equal, // and then by shortest to longest length
 * if both artist and title are equal
 * 

 * 
 * public String totalPlayTime() { // returns the total time the play list will
 * take in the format HH:MM:SS if there are hours, or MM:SS if there are no
 * hours
 */


	
