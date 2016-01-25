import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private ArrayList<Card> deck;
    private int numPlayers=0;
    private ArrayList<Player> players;
    private int drawCount, currentCount;
    private boolean drawing;
    private Player leader;

    Game() {
        Card blackJack = new Card(10), redJack = new Card(15),redQueen = new Card(18),blackQueen = new Card(14);
        Card blackKing = new Card(20),redKing = new Card(22),ace = new Card(0,true),evenNonFace = new Card(0);
        Card three = new Card(3), five=new Card(5),seven = new Card(7),nine=new Card(9);
        deck=new ArrayList<Card>();
        for(int i = 0;i<2;i++){
            deck.add(blackJack);deck.add(redJack);deck.add(redQueen);deck.add(blackQueen);deck.add(blackKing);
            deck.add(redKing);deck.add(ace);deck.add(ace);
        }
        for(int i=0;i<20;i++){deck.add(evenNonFace);}
        for(int i=0;i<4;i++){deck.add(three);deck.add(five);deck.add(seven);deck.add(nine);}
        shuffle(deck);

        Player player1 = new Player(1,0),player2=new Player(2,0),player3=new Player(3,0),player4=new Player(4,0);
        players = new ArrayList<Player>();
        players.add(player1);players.add(player2);players.add(player3);players.add(player4);

        playGame();
    }

    Player playGame() {
        Scanner input=new Scanner(System.in);
        while (numPlayers>4||numPlayers<1) {
            System.out.println("Please enter the desired number of players (1-4)");
            numPlayers = input.nextInt();
        }
        for(int i=0;i<numPlayers;i++){
            Player current = players.get(i);
            drawCount=0;
            currentCount=0;
            drawing=true;
            while (drawing){
                Card drawn = draw(deck);
                currentCount+=drawn.getValue();
                drawCount++;
                if(drawn.isAce()){drawing=false;}
            }
            int playerNum=i+1;
            System.out.println("Player "+playerNum+" finished after "+drawCount+" draws.  "+currentCount+" points awarded!");
            current.setScore(currentCount);
        }
        currentCount=0;
        for(int i=players.size()-1;i>=0;i--){
            Player current = players.get(i);
            if (current.getScore()>currentCount){currentCount=current.getScore();leader=current;}
        }
        System.out.println();
        System.out.println("Player "+leader.getNumber()+" wins with "+leader.getScore()+ " points!!");
        return leader;
    }

    static void shuffle(ArrayList<Card> deckToShuffle) {
        Random rnd = new Random();
        for (int i = deckToShuffle.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            Card temp = deckToShuffle.get(index);
            deckToShuffle.set(index, deckToShuffle.get(i));
            deckToShuffle.set(i, temp);
        }
    }

    static Card draw(ArrayList<Card> deckToDrawFrom) {
        Card toDraw = deckToDrawFrom.get(deckToDrawFrom.size()-1);
        deckToDrawFrom.remove(deckToDrawFrom.size()-1);
        return toDraw;
    }

    public Player getLeader() {
        return leader;
    }

}
