package QuizQuestions;
import java.util.ArrayList;

public class Question implements QuestionInterface {
    public Question() {
    }
    public String question;

    public Chance chanceToBeChosen; // kompozícia , Prepoužívam triedu Chance ktorá vznika aj zanika spolu s Question

    public ConcreteAnswer answer; // agregacia
    /**
     * @param question String otazky ktorý sa tu nastaví
     * @param singleAnswer Objekt s Odpovedou ktorý Question prepoužije a vznikne agregacia
     */
    public Question( String question, ConcreteAnswer  singleAnswer) {
        this.question = question;
        this.chanceToBeChosen = new Chance();
        answer = singleAnswer;

    }
    /**
     * @param i Cislo pre počet podov
     * @return vracia zvačšený počet podov o 1
     */
    public int countPoints(int i){
        return ++i;
    }

    /**
     * @param finalQuestion Objekt otazky z array listu otazok pre vypísanie šance ( čím mensie čislo tým vačšia šanca)
     * @param i čislo indexu
     */
    public static void printQuestion(ArrayList<Question> finalQuestion, int i){ // staticka metoda aby som to mohol volat z mainu len tak
        System.out.printf("\n" + "Sanca na vyber bola : " + finalQuestion.get(i).chanceToBeChosen.chanceToBeChosen + " \n" + finalQuestion.get(i).question + "\n");
    }

    @Override
    public int hashCode() {
        return chanceToBeChosen.chanceToBeChosen + super.hashCode() + Integer.parseInt(answer.answer);
    }

    @Override
    public boolean equals(Object obj) {
         if(this.hashCode() == (obj.hashCode())) return true;
         else return false;
    }
}
