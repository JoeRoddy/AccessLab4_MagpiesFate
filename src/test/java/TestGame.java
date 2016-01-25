import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TestGame {
    @Test
    public void gameTest(){
     //Testing shuffle()
        Card card1=new Card(10);
        Card card2=new Card(22);
        Card card3=new Card(15);
        Card card4=new Card(0);
        ArrayList<Card> testDeck = new ArrayList<Card>();
        testDeck.add(card1); testDeck.add(card2); testDeck.add(card3); testDeck.add(card4);
        Game.shuffle(testDeck);
        assertTrue("shuffle() failed, deck not shuffled",(testDeck.get(0).getValue()!=10||testDeck.get(1).getValue()!=22
                ||testDeck.get(2).getValue()!=15||testDeck.get(3).getValue()!=0));
        System.out.println("shuffle() test passed");

    //Testing draw()
        Card atTop = testDeck.get(testDeck.size()-1);
        Card drawn = Game.draw(testDeck);

        assertTrue("draw() failed.",atTop.equals(drawn));
        System.out.println("draw() test passed.");

     /*//Testing playGame()
        Game testGame = new Game();
        assertNotNull("playGame() failed",testGame.getLeader());
        System.out.println("playGame() test passed");
*/
    }
}
