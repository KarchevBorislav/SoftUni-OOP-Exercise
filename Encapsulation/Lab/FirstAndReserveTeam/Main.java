package FirstAndReserveTeam;




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Team team = new Team("Red Hawks");

        int peopleCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            team.addPlayer(new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3])));




        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");


    }


}
