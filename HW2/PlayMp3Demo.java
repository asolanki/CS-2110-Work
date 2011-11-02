package edu.virginia.cs2110;
import edu.virginia.cs2110.Mp3FilePlayer;


public class PlayMp3Demo {

	public static void main(String[] args) {
		Mp3FilePlayer mp3 = new Mp3FilePlayer("good-ole-song.mp3");
        mp3.playAndBlock(20.0);
        mp3 = new Mp3FilePlayer("The_Kielbasas-The_Chicken_Dance.mp3");
        mp3.playAndBlock();
        System.out.println("Done!");
	}

}
