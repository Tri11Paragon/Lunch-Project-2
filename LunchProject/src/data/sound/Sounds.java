package data.sound;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Sounds {
	
	public static Audio[] digging_pick = new Audio[8];
	public static Audio[] digging_dirt = new Audio[7];
	
	public static void init() {
		for(int i =0; i < 8; i++) {digging_pick[i] = loadSound("mining/digging-axe-" + (i+1));}
		for(int i =0; i < 7; i++) {digging_dirt[i] = loadSound("mining/digging-dirt-" + (i+1));}
	}
	
	public static Audio loadSound(String file) {
		try {
			return AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + file + ".wav"));  
		} catch (IOException e) {e.printStackTrace();}
		return null;
	}
	
}
