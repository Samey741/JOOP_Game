package Player;
import java.util.Scanner;

public class Player extends ParentPlayer{
    public Player() {
        super();
    }

    /**
     *
     * @return Getter pre získanie Private spravnej odpovede
     */
    public String getRightAnswer() {
        return rightAnswer;
    }

    /**
     *
     * @param rightAnswer Spravna odpoved ktorá sa posiela na nastavenie ked Hrač zažiada o pomoc
     */
    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    private String rightAnswer;

    public String wantHelp() {
        Scanner playerAnswer = new Scanner(System.in);
        String answer = playerAnswer.next();
        return answer;
    }

    /**
     *
     * @return Vratim si hračovu odpoved ktoru zadal do Terminalu
     */
    @Override
    public String answerQuestion() {
        Scanner playerAnswer = new Scanner(System.in);
        String answer = playerAnswer.next();
        return answer;
    }
}
