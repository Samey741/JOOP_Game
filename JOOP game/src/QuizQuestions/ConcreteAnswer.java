package QuizQuestions;

public class ConcreteAnswer extends AbstractAnswer{
    public String answer;

    /**
     * @param answer String pre odpoved na otazku , ktorá sa posiela z Mainu a inicalizuje sa to
     */
    public ConcreteAnswer (String answer) {
        this.answer = answer;
    }
    public final void printAnswer() { // final metoda + Pretazovanie
        System.out.printf("Right answer = " + answer);
    }

    @Override
    public int hashCode() {
        return  Integer.parseInt(answer) + super.hashCode();
    }

    @Override
    public String toString() {
        return " \n ConcreteAnswer{" +
                "answer='" + answer + '\'' +
                '}';
    }

}
