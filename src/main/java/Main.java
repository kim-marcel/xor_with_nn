import java.util.Arrays;
import java.util.Random;

/**
 * Created by KimFeichtinger on 04.03.18.
 */
public class Main {

    // Example program to test the basic neural network by letting it solve XOR
    public static void main(String args[]){

        Random r = new Random();

        // Training Data Inputs
        double[][] trainingDataInputs = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
        };

        // Training Data Targets
        double[][] trainingDataTargets = {
                {0},
                {1},
                {1},
                {0},
        };

        // Testing Data
        double[][] testingData = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1},
        };

        NeuralNetwork nn = new NeuralNetwork(2, 4, 1);

        // Training
        for (int i = 0; i < 50000; i++) {
            // training in random order
            int random = r.nextInt(4);
            nn.train(trainingDataInputs[random], trainingDataTargets[random]);
        }

        // Testing the nn
        for (int i = 0; i < testingData.length; i++) {
            System.out.println("Guess for " + testingData[i][0] + ", " + testingData[i][1] + ": ");
            double[][] guess = nn.guess(testingData[i]);
            for (int j = 0; j < guess.length; j++) {
                System.out.println(Arrays.toString(guess[j]));
            }
        }

        nn.writeToFile();
    }


}


