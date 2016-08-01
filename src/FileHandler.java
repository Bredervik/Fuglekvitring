import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Brevik on 12.07.2016.
 */
public class FileHandler {

    public byte[] fileConverter(String fileName){
        byte[] tempArray;
        Path path = Paths.get(fileName);
        try{
            tempArray = Files.readAllBytes(path);
            return tempArray;
        }
        catch (IOException ioe){
            System.out.println("Something went wrong when reading the file");
            ioe.printStackTrace();
            return null;
        }
    }
    public void createFileFromArray(String fileName){

    }
    public void createFileFromArray(byte[] bytes){
        AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
        AudioInputStream stream = new AudioInputStream(
                new ByteArrayInputStream(bytes),
                new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false),
                1000000
        );
        File audiofile = new File("test.wav");
        try{
            AudioSystem.write(stream, AudioFileFormat.Type.WAVE,audiofile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
