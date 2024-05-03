package design.blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackJackGame {

    public static void main(String[] args) {
        UserController g = UserController.initiateGame(new Dealer(), List.of(new Player(), new Player()));
        g.getController().deal();
    }
}

class ShoeOfCards {
    private List<Deck> decks;

    public ShoeOfCards(int n) {
        for(int i=0; i<n; i++) {
            decks.add(new Deck());
        }
    }

    public Deck getDeck() {
        return decks.remove(0);
    }
}

class Deck {
    private Card[] list;

    public Deck() {
        int i=0;
        for(Suit t : Suit.values()) {
            for(faceValue a : faceValue.values()) {
                list[i++] = new Card(a, t);
            }
        }
    }
}

class Card {
    faceValue faceValue;
    Suit suit;

    public Card(faceValue faceValue, Suit suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }
}

abstract class User {

    UserController controller;
    String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    abstract void deal();
    abstract void draw();
    abstract void pat();
}

class Dealer extends User {

    @Override
    void deal() {

    }

    @Override
    void draw() {

    }

    @Override
    void pat() {

    }
}

class Player extends User {

    @Override
    void deal() {

    }

    @Override
    void draw() {

    }

    @Override
    void pat() {

    }
}

class UserController {
    private ShoeOfCards shoeOfCards;
    private Dealer dealer;
    private Map<String, Player> players;

    private User controller;

    public UserController(Dealer dealer, List<Player> players, int shoeOfCards) {
        this.dealer = dealer;
        this.players = new HashMap<>();
        for(Player player : players) {
            this.players.put(player.getUniqueId(), player);
        }
        this.shoeOfCards = new ShoeOfCards(shoeOfCards);
        this.controller = dealer;
    }

    private static UserController userController = null;
    public static UserController initiateGame(Dealer dealer, List<Player> players) {
        if(userController == null) {
            userController = new UserController(dealer, players, 5);
        }
        return userController;
    }

    public User getController() {
        return controller;
    }

    public void setController(User controller) {
        this.controller = controller;
    }
}

enum Suit {
    HEART, DIAMOND, SPADE, CLUB
}

enum faceValue {
    ACE(1, 11), TWO(2, 2), THREE(3, 3), FOUR(4, 4), FIVE(5, 5), SIX(6, 6), SEVEN(7, 7), EIGHT(8, 8), NINE(9, 9), TEN(10, 10), KING(10, 10), QUEEN(10, 10), JACK(10, 10);

    int value1, value2;

    faceValue(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }
}

enum State{
    LEFT,
    LOOSE,
    WIN,
    WAIT
}


