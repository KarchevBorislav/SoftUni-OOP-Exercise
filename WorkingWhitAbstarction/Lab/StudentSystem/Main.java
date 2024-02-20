package OOP.workingWhitAbstraction.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String commands = scanner.nextLine();

        while (!commands.equals("Exit")) {
            String[] command  = commands.split(" ");
            studentSystem.ParseCommand(command);

            commands = scanner.nextLine();
        }
    }
}
