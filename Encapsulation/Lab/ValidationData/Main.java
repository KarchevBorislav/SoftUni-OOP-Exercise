package ValidationData;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();

        fillList(scanner, input, personsList);

        double percent = Double.parseDouble(scanner.nextLine());

        printList(personsList, percent);

    }

    private static void printList(List<Person> personsList, double percent) {
        personsList.forEach(person -> {
            person.increaseSalary(percent);
                System.out.println(person);
        });
    }


    private static void fillList(Scanner scanner, int input, List<Person> personsList) {
        for (int i = 0; i < input; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            personsList.add(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3])));
        }
    }
}

