package OOP.workingWhitAbstraction.TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lights[] signals = Arrays.stream(scanner.nextLine().split(" ")).map(String::toUpperCase)
                .map(Lights::valueOf).toArray(Lights[]::new);

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (Lights color : signals) {
            TrafficLight trafficLight = new TrafficLight(color);
            trafficLights.add(trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) { // one rotation
            for (TrafficLight trafficLight : trafficLights) { //each traffic light
                trafficLight.changeLight();
                System.out.print(trafficLight + " ");
            }
            System.out.println();

        }


    }
}