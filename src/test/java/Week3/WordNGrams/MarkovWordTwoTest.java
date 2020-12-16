package Week3.WordNGrams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarkovWordTwoTest {
    private MarkovWordTwo markovTwo = new MarkovWordTwo();
    private MarkovRunner mRunner = new MarkovRunner();

    @Test
    void test() {
        mRunner.runMarkovTwo();
    }
}