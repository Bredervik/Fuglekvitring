import com.sun.media.sound.FFT;

/**
 * Created by Brevik on 12.07.2016.
 */
public class DiscreteFourierTransform {
    private final int CHUNK_SIZE = 1;

    public Complex[][] fastFourierTransform(byte[] timeDomainSignal){
        final int N = timeDomainSignal.length;
        int amountPossible = N/this.CHUNK_SIZE;
        Complex[][] transformedBits = new Complex[amountPossible][];

        "HUMBUG"
        for(int i = 0; i < amountPossible; i++){
            Complex[] complex = new Complex[this.CHUNK_SIZE];
            for(int j = 0; j < this.CHUNK_SIZE;j++){
                complex[j] = new Complex(timeDomainSignal[i*this.CHUNK_SIZE+j],0);
            }
            transformedBits[i] =  FFT.fft(complex);
        }
        return transformedBits;
    }
}
