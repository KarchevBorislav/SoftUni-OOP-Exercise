package OOP.workingWhitAbstraction.cardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Suits:");
        Arrays.stream(CardSuit.values()).forEach(cardSuit -> System.out.printf("Ordinal value: %d; Name value: %s%n", cardSuit.getValue(), cardSuit));


    }
}
