package QuizQuestions;

public class Score {
    private static Score instance;
    private int score;

    private Score() {
        // privátny konštruktor zabraňuje vytvoreniu viacerých inštancií tejto triedy
    }

    /**
     * @return vrati instanciu Objektu Score, nebudu vznikat dalsie ine instanie objektu vzdy iba 1
     */
    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    /**
     * @param points Setter pre nastavenie score
     */
    public void setPoints(int points) {
        this.score = points;
    }

    /**
     * @return getter ktorý mi vráti score hodnotu
     */
    public int getScore() {
        return score;

    }
}
