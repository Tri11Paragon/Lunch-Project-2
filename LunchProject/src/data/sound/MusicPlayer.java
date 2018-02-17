package data.sound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.openal.Audio;

import data.helpers.Maths;

public class MusicPlayer {
	
	public static List<Audio> musics = new ArrayList<Audio>();
	
	public static Audio log_music_1;
	
	public static void init() {
		log_music_1 = Sounds.loadSound("music/EXP");
		musics.add(log_music_1);
	}
	static int d = 0;
	public static void update() {
		d++;
		d %= 150;
		if (d == 149) {
			int ran = Maths.randInt(0, 1000);
			if (ran == 1) {
				randomizeMusic(0);
			}
		}
	}
	
	public static void randomizeMusic(long seed) {
		Random random = new Random();
		if (seed != 0) {random.setSeed(seed);}
		int ran = random.nextInt((musics.size() - 0) ) + 0;
		musics.get(ran).playAsMusic(1, 1, false);
	}
	
	
	
}
