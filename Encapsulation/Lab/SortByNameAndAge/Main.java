package OOP.encapsulation.SortByNameAndAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();

        fillList(scanner, input, personsList);
        Sort.sort(personsList);
        printList(personsList);


    }

    private static void printList(List<Person> personsList) {
        personsList.forEach(person -> System.out.println(person.toString()));
    }


    private static void fillList(Scanner scanner, int input, List<Person> personsList) {
        for (int i = 0; i < input; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            personsList.add(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }

    }
}
