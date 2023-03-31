import QuizQuestions.Question;
import Player.Player;
import QuizQuestions.SimpleQuestion;
import QuizQuestions.HardQuestion;
import QuizQuestions.ConcreteAnswer;
import java.util.Objects;
import java.util.ArrayList;
import QuizQuestions.Score;
import Player.ParentPlayer;
import java.util.Scanner;

public class Main { // tu by sa mi mohly vyvotirť všetky instancie triedy Question
    static public ArrayList<Question> allQuestionsList = new ArrayList<Question>();
    static public ArrayList<Question> finalQuestionsList = new ArrayList<Question>(); // list otazok po vybere na zaklade šancii
    public static int score = 0;
    static boolean usedHelp = false;

   final static String[][] otazky = new String[][] {
            {"V akom roku vznikla JAVA ? " + "\n" + "1 : 1996 ; 2 : 1995 3 : 1994; 4 : 1991 ","1"},
            {"Je prazdne meno .java suboru validne pomenovanie java suboru? "+ "\n" + "Ano  Nie","Ano"},
            {"UML asociacia je ? " + "\n" + "1: implementovana ako Java attribute member  " + " 2 : implementovan Java metoda  "  + " 3 : implementovana Java trieda  " + " 4 : nic ","1"},
            {"Určte vhodny data typ pre isSwimmer " + "\n" + "1 : int ; 2 : String 3 : boolean ; 4 : double ","3"},
            {"Java beži na : "+ "\n" + "1 : Windows; 2 : Linux 3 : Mac; 4 : Vsetky uvedene ","4" },
            {" Vieme v Jave na priamo porovnavat Integer a String ? " + "\n" + "Ano  Nie" ,"Nie"},
            {"Referencia null može byt pouzivata pre pristup k statickej premennej alebo metode ?" + "\n" +"Ano  Nie","Ano"},
            {"Velkost charu v Jave je ? " + "\n" + "1 : 4 bit ; 2 : 7 bit ; 3 : 8 bit; 4 : 16 bit ","4"},
            {"Primitívne data typy su alokovane na Stacku" + "\n" + "Ano  Nie","Ano"}
    };

    public static void main(String[] args) {

        ParentPlayer actualPlayer = null;
        String playersAnswer;

        for (int i = 0; i < 9 ; i++) {
            String[] parts = otazky[i][0].split("\n");
            ConcreteAnswer  SingleAnswer = new ConcreteAnswer(otazky[i][1]);
            if(parts[1].contains("1")){
                allQuestionsList.add(new SimpleQuestion(otazky[i][0],SingleAnswer));
            }
            else if (parts[1].contains("Ano")) {
                allQuestionsList.add(new HardQuestion(otazky[i][0],SingleAnswer));
            }

        }

        boolean everyThingIsOk = true;
        for (int i = 0; i < (allQuestionsList.size()-1); i++) {
            if(allQuestionsList.get(i).equals(allQuestionsList.get(i+1))) everyThingIsOk = false;
        }


        int counterOfQuestionThatGetToQuiz = 0;

        for (int i = 0; i < allQuestionsList.size(); i++) { // tuto filtrujem otazky
            if(everyThingIsOk == true){
                if (allQuestionsList.get(i).chanceToBeChosen.chanceToBeChosen<= 5) {
                    counterOfQuestionThatGetToQuiz++;
                    finalQuestionsList.add(allQuestionsList.get(i));
                    if(i >= 7 && counterOfQuestionThatGetToQuiz <= 3){ // pripad ked by bolo malo otazok tak aby doplnilo aspon na 5
                        for (int j = i; j < allQuestionsList.size(); j++) {
                            finalQuestionsList.add(allQuestionsList.get(j));
                        }
                        break;
                    }
                }
            }

        }

        for (int i = 0; i < counterOfQuestionThatGetToQuiz ; i++) { // print na odpovede otazok

            System.out.printf( "\n" + " ---------------- NEW QUESTION ---------------- " + "\n");
            Question.printQuestion(finalQuestionsList,i);
            if(usedHelp == false) {
                System.out.printf("\n Nevieš otazku ? Na jednu otazku ti dam spravnu chceš ju zobraziť ? Ak ANO napis : Ano ak NIE napis : Nie ");
                System.out.printf("\n" + " ---------------- Chces pomoc ? ---------------- " + "\n");

                Scanner playerAnswer = new Scanner(System.in);
                String helpAnswer = playerAnswer.next();
                if (helpAnswer.equals("Ano") && usedHelp == false) {
                    usedHelp = true;
                    actualPlayer = new Player();
                    Player downCastedParentPlayer = null;
                    if (actualPlayer instanceof Player) {
                        downCastedParentPlayer = (Player) actualPlayer; // Downcasting Pretypovanie Parenta na Playera , trz možem využivať Playerove vlastnosti
                    }
                    downCastedParentPlayer.setRightAnswer(finalQuestionsList.get(i).answer.answer);
                    System.out.printf("\n Spravna odpoved ktoru teraz zadáš je : " + downCastedParentPlayer.getRightAnswer() + "\n");
                } else if (helpAnswer.equals("Nie")) {
                    ParentPlayer a = new Player(); // Upcasting to znamena že z playera už bude len parent a nebude vediet davat pomoc
                    actualPlayer = a;
                } else {
                    System.out.printf("\n Zadal si niečo ako si nemal ideš bez pomoci \n");
                    ParentPlayer a = new Player(); // Upcasting to znamena že z playera už bude len parent a nebude vediet davat pomoc
                    actualPlayer = a;
                }
            }

            System.out.printf( "\n" + " ---------------- Teraz zadaj svoju odpoved ---------------- " + "\n");
            playersAnswer = actualPlayer.answerQuestion();
            System.out.printf( "\n" + " ---------------- Spravna odpoved bola  ---------------- " + "\n");
            finalQuestionsList.get(i).answer.printAnswer();

            if(Objects.equals(playersAnswer,finalQuestionsList.get(i).answer.answer)){
                System.out.printf(finalQuestionsList.get(i).answer.toString());
                Score.getInstance().setPoints(new Question().countPoints(score));
            }
            else {
                if(finalQuestionsList.get(i).question.contains("Ano")){
                    Score.getInstance().setPoints(new SimpleQuestion().countPoints(score));
                }
                else{
                    Score.getInstance().setPoints(new HardQuestion().countPoints(score));
                }
            }
            score = Score.getInstance().getScore();
        }

        System.out.printf( " Tvoje skóre spravných odpovedí je  = " + Score.getInstance().getScore() + " \\ " + counterOfQuestionThatGetToQuiz + " z celkoveho počtu otazok.");

    }
}