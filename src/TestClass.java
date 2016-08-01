import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;
import java.io.OutputStream;

/**
 * Created by Brevik on 11.07.2016.
 */
public class TestClass {

    public static Mixer mixer;
    public static Clip clip;
    public static OutputStream aStream;


    public static void main(String [] args){


        System.out.println("Testing starting");
        FileHandler fileHandler = new FileHandler();
        DiscreteFourierTransform dft = new DiscreteFourierTransform();
        byte[] byteArray = fileHandler.fileConverter("Recording.wav");
        System.out.println(byteArray.length);
        System.out.println("Fast fourier transforming an array of bits...");
        Complex[][] transFormed = dft.fastFourierTransform(byteArray);
        for(int i = 0; i < 20; i++){
            System.out.print(transFormed[i]+" ");
        }

        /*
        try{
            AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100,16,2,4,44100,false);
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if(!AudioSystem.isLineSupported(info)){
                System.out.println("Unsupported info");
            }

            final TargetDataLine targetLine = (TargetDataLine)AudioSystem.getLine(info);
            targetLine.open();
            System.out.println("Recording starting");
            targetLine.start();

            Thread thread = new Thread(){
              @Override public void run(){
                  AudioInputStream audioStream = new AudioInputStream(targetLine);
                  File audiofile = new File("Recording.wav");
                  try{
                        AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE,audiofile);

                  }
                  catch (IOException e){
                      e.printStackTrace();
                  }
              }
            };
            thread.start();
            Thread.sleep(5000);
            targetLine.stop();
            targetLine.close();
            System.out.println("Recording ended");

        }

        catch (LineUnavailableException lue){
            lue.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }







        Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();

        for(Mixer.Info info : mixInfos){
            System.out.println(info.getDescription());
        }
        mixer = AudioSystem.getMixer(mixInfos[0]);

        DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
        try {
            clip = (Clip) mixer.getLine(dataInfo);
        }
        catch (LineUnavailableException e){
            e.printStackTrace();
        }

        try{
            File soundFile = new File("Recording.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip.open(audioInputStream);
        }
        catch (LineUnavailableException lineUnAv){
            lineUnAv.printStackTrace();
        }
        catch (UnsupportedAudioFileException unSupFile){
            unSupFile.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }

        clip.start();
        do {
            try{
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        } while (clip.isActive());

        clip.close();
        for(int i = 0; i < 50; i++){
            System.out.print(" "+fileHandler.fileConverter("Recording.wav")[i]+" ");
        }
1       */
    }

}
