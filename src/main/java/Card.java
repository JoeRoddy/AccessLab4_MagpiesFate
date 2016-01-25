
public class Card {
    private int value;
    private boolean ace;
    Card(int value) {
        this.value = value;
        ace=false;
    }

    Card(int value, boolean isAce){
        this.value=value;
        this.ace=isAce;

    }

    public boolean isAce() {
        return ace;
    }

    public int getValue() {
        return value;
    }
}
