package OOP.workingWhitAbstraction.cardsWhitPower;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower(){
        return cardRank.getPower() + cardSuit.getSuitPower();
    }
}