package QuizQuestions;

public class HardQuestion extends Question{

    public HardQuestion(){

    }
    /**
     * @param questionToBeSettet String otazky ktorý sa posiela vyššie
     * @param singleAnswer Objekt s Odpovedou ktorý Question prepoužije a vznikne agregacia
     */
    public HardQuestion(String questionToBeSettet,ConcreteAnswer  singleAnswer ) {
        super(questionToBeSettet,singleAnswer);

    }
    /**
     * @param i Cislo pre počet podov
     * @return vracia počet bodov aký bol nakolko neni čo pripočítat pretože odpoved bola nesprávna
     */
   @Override
    public int countPoints(int i){ // prekonavanie
         return i;
    }

}
