package BirthdayCelebrations;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();

        List<Birthable> birthableList = new ArrayList<>();

        while (!commands.equals("End")) {
            String[] tokens = commands.split(" ");
            String name = tokens[0];
            switch (name) {
                case "Citizen":
                    birthableList.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthableList.add(new Pet(tokens[1], tokens[2]));
                case "Robot:":
                    Robot robot = new Robot(tokens[1], tokens[2]);
            }


            commands = scanner.nextLine();
        }
        String date = scanner.nextLine();
        birthableList.stream().filter(e->e.getBirthDate().contains(date)).forEach(e->System.out.println(e.getBirthDate()));

    }
}
