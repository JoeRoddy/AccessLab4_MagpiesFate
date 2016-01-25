
public class Player {
    private int score;
    private int number;

    Player(int number, int score) {
        this.number = number;
        this.score=score;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
