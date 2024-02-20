package OOP.workingWhitAbstraction.cardRank;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        Arrays.stream(CardRank.values()).forEach(cardRank -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.getValue(), cardRank));
    }
}
