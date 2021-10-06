import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineEvent;

public class Sound {

	public void playSound(String sound) {
		  URL resource = ClassLoader.getSystemClassLoader().getResource(sound);
		  try {
		    final Clip clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
		    clip.addLineListener(event -> {
		      if (event.getType() == LineEvent.Type.STOP) {
		        clip.close();
		      }
		    });
		    clip.open(AudioSystem.getAudioInputStream(resource));
		    FloatControl gainControl = 
		    	    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		    	gainControl.setValue(0.0f); //adjust this value to decrease the sound volume.
		    clip.start();
		  } catch (Exception e) {
		    System.out.println("Failed to play the sound");
		  }
		}
}