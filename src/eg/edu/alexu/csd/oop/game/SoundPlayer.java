package eg.edu.alexu.csd.oop.game;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundPlayer {

    public static void play(String filename) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
    }
}
