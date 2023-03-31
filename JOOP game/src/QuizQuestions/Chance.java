package QuizQuestions;
import java.util.Random;

public class Chance {
    public int chanceToBeChosen;

    public Chance() {
        Random rand = new Random();
        this.chanceToBeChosen = rand.nextInt(10);
    }

}
