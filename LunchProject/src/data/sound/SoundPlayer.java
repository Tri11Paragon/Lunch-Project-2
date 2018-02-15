package data.sound;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SoundPlayer {
	
	private Audio soundFile;
	
	public SoundPlayer(String file) {
		try {
			soundFile = AudioLoader.getAudio("WAV", ResourceLoader.getResourceAsStream("sound/" + file + ".wav"));  
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public SoundPlayer(Audio file) {
		soundFile = file;  
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
