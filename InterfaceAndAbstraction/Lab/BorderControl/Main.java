package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();
        List<Identifiable> identifiableList = new ArrayList<>();


        while (!commands.equals("End")) {
            String[] tokens = commands.split(" ");

            if (tokens.length == 2) {

                Robot robot = new Robot(tokens[0], tokens[1]);
                identifiableList.add(robot);

            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                identifiableList.add(citizen);
            }


            commands = scanner.nextLine();
        }
        String identifier = scanner.nextLine();
       identifiableList.stream().filter(i -> i.getId().endsWith(identifier)).forEach(i -> System.out.println(i.getId()));


    }
}
