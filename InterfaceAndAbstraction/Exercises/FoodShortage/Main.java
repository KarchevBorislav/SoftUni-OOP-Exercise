package FoodShortage;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int peopleCount = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyerMap = new HashMap<>();

        fillMap(scanner, peopleCount, buyerMap);
        String names = scanner.nextLine();

        while (!names.equals("End")) {
            Buyer buyer = buyerMap.get(names);
            if (buyer != null) {
                if (buyerMap.containsKey(names)) {
                    buyer.buyFood();
                }

            }

            names = scanner.nextLine();
        }
        int totalFood = buyerMap.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.print(totalFood);


    }

    private static void fillMap(Scanner scanner, int peopleCount, Map<String, Buyer> buyerMap) {
        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            if (tokens.length == 4) {
                buyerMap.put(tokens[0], new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
            } else if (tokens.length == 3){
                buyerMap.put(tokens[0], new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }
        }
    }
}
