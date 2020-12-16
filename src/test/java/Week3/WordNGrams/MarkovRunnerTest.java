package Week3.WordNGrams;

import edu.duke.FileResource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarkovRunnerTest {

    private MarkovWordOne markovOne = new MarkovWordOne();
    private MarkovRunner mRunner = new MarkovRunner();
    private String test = "this is just a test yes this is a simple test";

    @Test
    void test(){
        mRunner.runMarkov();
    }

}