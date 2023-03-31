package QuizQuestions;
import java.util.ArrayList;
import java.util.Random;

public interface QuestionInterface {
    String question = null;
    Chance chanceToBeChosen = null;
    ConcreteAnswer answer = null;

    int countPoints(int i);
    static void printQuestion(ArrayList<Question> finalQuestion, int i){

    }
}


