package data.sound;

import java.io.IOException;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import data.helpers.Maths;
import data.main.Boot;
import data.objects.player.Player;

public class SoundPlayer {
	
	private Audio soundFile;
	private Player player;
	
	public SoundPlayer(String file) {
		try {
			soundFile = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + file + ".wav"));  
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public SoundPlayer(Audio file) {
		soundFile = file;  
	}
	
	public SoundPlayer(String file, Player player) {
		try {
			soundFile = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + file + ".wav"));  
			this.player = player;
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public SoundPlayer(Audio file, Player player) {
		soundFile = file;  
		this.player = player;
	}
	
	public SoundPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * Loads the file into the Audio Source.
	 * @param file the WAV file to load.
	 */
	public void loadSound(String file) {
		try {
			soundFile = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + file + ".wav"));  
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void loadSound(Audio file) {
		soundFile = file;  
	}
	
	public static void playSoundRandomStatic(Audio[] sounds, float gain) {
		int r = Maths.randInt(0, sounds.length);
		sounds[r].playAsSoundEffect(1, gain, false);
	}
	//TODO: Make this a little better at the width.
	public static void playSoundRandomStatic(Audio[] sounds, Player player, Vector2f soundPlayPos, float div) {
		int r = Maths.randInt(0, sounds.length);
		float xDis = Math.abs(player.getPosition().x - soundPlayPos.x);
		float yDis = Math.abs(player.getPosition().y - soundPlayPos.y);
		float total = (xDis + yDis)/(Boot.WIDTH + Boot.HEIGHT);
		float fin = Math.abs((total - 1))/div;
		sounds[r].playAsSoundEffect(1, fin, false);
	}
	
	public void playSoundRandom(Audio[] sounds) {
		int r = Maths.randInt(0, sounds.length);
		sounds[r].playAsSoundEffect(1, 1, false);
	}
	public void playSoundRandom(Audio[] sounds, Vector2f soundPlayPos) {
		int r = Maths.randInt(0, sounds.length);
		float xDis = Math.abs(player.getPosition().x - soundPlayPos.x);
		float yDis = Math.abs(player.getPosition().y - soundPlayPos.y);
		float total = (xDis + yDis)/(Boot.WIDTH + Boot.HEIGHT);
		float fin = Math.abs((total - 1));
		sounds[r].playAsSoundEffect(1, fin, false);
	}
	
	public void playSound(float pitch, float gain, boolean loop) {
		soundFile.playAsSoundEffect(pitch, gain, loop);
	}
	public void playSound(float pitch, float gain) {
		soundFile.playAsSoundEffect(pitch, gain, false);
	}
	public void playSound(float pitch, float gain, float x, float y) {
		soundFile.playAsSoundEffect(pitch, gain, false, x, y, 0);
	}
	public void playSound(float pitch, float gain, boolean loop, float x, float y) {
		soundFile.playAsSoundEffect(pitch, gain, loop, x, y, 0);
	}
	public void playSoundAsMusic(float pitch, float gain, boolean loop) {
		soundFile.playAsMusic(pitch, gain, loop);
	}
	public void playSoundAsMusic(float pitch, float gain) {
		soundFile.playAsMusic(pitch, gain, false);
	}
	public Audio getSoundFile() {
		return soundFile;
	}
	public void setSoundFile(Audio soundFile) {
		this.soundFile = soundFile;
	}
}
