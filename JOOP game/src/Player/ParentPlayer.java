package Player;

import java.util.Scanner;

public class ParentPlayer {
        public ParentPlayer() {

    }
    /**
     *
     * @return Vratim si hračovu odpoved ktoru zadal do Terminalu
     */
    public String answerQuestion() {
        Scanner playerAnswer = new Scanner(System.in);
        String answer = playerAnswer.next();
        return answer;
    }
}
