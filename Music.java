/**
 * A music object                  NOTE: only works with .wav music
 * 
 * @author Alan Huang
 * @version 6/10/14
 */

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;

public class Music implements Runnable
{
    private Clip mus;
    String file;
    public Music(String path)
    {
        file = path;
    }

    public void run()
    {
        try
        {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResourceAsStream(file));
            mus = clip;
            clip.open(inputStream);
            clip.start(); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void stop()
    {
        mus.stop();
    }
    
    public static void pause(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}