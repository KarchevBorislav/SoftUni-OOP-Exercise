
package OOP.workingWhitAbstraction.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safeContent = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bagWhitItems = new LinkedHashMap<>();

        for (int i = 0; i < safeContent.length; i += 2) {
            String tokens = safeContent[i];

            long count = Long.parseLong(safeContent[i + 1]);
            String item = "";

            item = getItemsValue(tokens, item);


            if (validateItems(bagCapacity, bagWhitItems, tokens, count, item)) continue;


            fillMap(bagWhitItems, tokens, count, item);
            switch (item) {
                case "Gold":
                    break;
                case "Gem":
                    break;

                case "Cash":
                    break;
            }
        }


        printOutput(bagWhitItems);
    }

    private static boolean validateItems(long bagCapacity, Map<String, LinkedHashMap<String, Long>> bagWhitItems, String tokens, long count, String item) {
        if (validateWeight(bagCapacity, bagWhitItems, count, item)) return true;

        if (validateItems(bagWhitItems, count, item)) return true;

        if (!bagWhitItems.containsKey(item)) {
            bagWhitItems.put(item, new LinkedHashMap<>());
        }

        if (!bagWhitItems.get(item).containsKey(tokens)) {
            bagWhitItems.get(item).put(tokens, 0L);
        }
        return false;
    }

    private static void fillMap(Map<String, LinkedHashMap<String, Long>> bagWhitItems, String tokens, long count, String item) {
        bagWhitItems.get(item).put(tokens, bagWhitItems.get(item).get(tokens) + count);
    }

    private static boolean validateItems(Map<String, LinkedHashMap<String, Long>> bagWhitItems, long count, String item) {
        switch (item) {
            case "Gem":
                if (!bagWhitItems.containsKey(item)) {
                    if (bagWhitItems.containsKey("Gold")) {
                        if (count > getGoldValue(bagWhitItems)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (cashvalue(bagWhitItems, count, item) > getGoldValue(bagWhitItems)) {
                    return true;
                }
                break;
            case "Cash":
                if (!bagWhitItems.containsKey(item)) {
                    if (bagWhitItems.containsKey("Gem")) {
                        if (count > getGoldValue(bagWhitItems)) {
                            return true;
                        }
                    } else {
                        return true;
                    }
                } else if (cashvalue(bagWhitItems, count, item) > getGemValue(bagWhitItems)) {
                    return true;
                }
                break;
        }
        return false;
    }

    private static boolean validateWeight(long bagCapacity, Map<String, LinkedHashMap<String, Long>> bagWhitItems, long count, String item) {
        if (item.equals("")) {
            return true;
        } else if (bagCapacity < getValuesOfTheBag(bagWhitItems, count)) {
            return true;
        }
        return false;
    }

    private static String getItemsValue(String tokens, String item) {
        if (tokens.length() == 3) {
            item = "Cash";
        } else if (tokens.toLowerCase().endsWith("gem")) {
            item = "Gem";
        } else if (tokens.equalsIgnoreCase("gold")) {
            item = "Gold";
        }
        return item;
    }

    private static long cashvalue(Map<String, LinkedHashMap<String, Long>> bagWhitItems, long count, String item) {
        return bagWhitItems.get(item).values().stream().mapToLong(e -> e).sum() + count;
    }

    private static long getGemValue(Map<String, LinkedHashMap<String, Long>> bagWhitItems) {
        return bagWhitItems.get("Gem").values().stream().mapToLong(e -> e).sum();
    }

    private static void printOutput(Map<String, LinkedHashMap<String, Long>> bagWhitItems) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : bagWhitItems.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static long getGoldValue(Map<String, LinkedHashMap<String, Long>> bagWhitItems) {
        return bagWhitItems.get("Gold").values().stream().mapToLong(e -> e).sum();
    }

    private static long getValuesOfTheBag(Map<String, LinkedHashMap<String, Long>> bagWhitItems, long count) {
        return bagWhitItems.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + count;
    }
}