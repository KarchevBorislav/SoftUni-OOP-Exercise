package OOP.workingWhitAbstraction.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Seasons seasons = Seasons.parse(tokens[2]);
        DiscountType discountType = DiscountType.parse(tokens[3]);
         PriceCalculator calculator  =  new PriceCalculator(pricePerDay,days,seasons,discountType);
        System.out.printf("%.2f%n", calculator.calculatePrice());


    }
}
