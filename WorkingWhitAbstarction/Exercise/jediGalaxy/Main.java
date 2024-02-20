package OOP.workingWhitAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        fillGalaxy(rows, cols, galaxy);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediStartPosition = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilStartPosition = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilCurrentRow = evilStartPosition[0];
            int evilCurrentCol = evilStartPosition[1];

            moveEvilForce(galaxy, evilCurrentRow, evilCurrentCol);

            int jediCurrentPosition = jediStartPosition[0];
            int jediCurrentCol = jediStartPosition[1];

            sum = moveJedi(galaxy, sum, jediCurrentPosition, jediCurrentCol);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long moveJedi(int[][] galaxy, long sum, int jediCurrentPosition, int jediCurrentCol) {
        while (jediCurrentPosition >= 0 && jediCurrentCol < galaxy[1].length) {
            if (jediCurrentPosition < galaxy.length && jediCurrentCol >= 0 && jediCurrentCol < galaxy[0].length) {
                sum += galaxy[jediCurrentPosition][jediCurrentCol];
            }

            jediCurrentCol++;
            jediCurrentPosition--;
        }
        return sum;
    }

    private static void moveEvilForce(int[][] galaxy, int evilCurrentRow, int evilCurrentCol) {
        while (evilCurrentRow >= 0 && evilCurrentCol >= 0) {
            if (evilCurrentRow < galaxy.length && evilCurrentCol < galaxy[0].length) {
                galaxy[evilCurrentRow][evilCurrentCol] = 0;
            }
            evilCurrentRow--;
            evilCurrentCol--;
        }
    }

    private static void fillGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }
}