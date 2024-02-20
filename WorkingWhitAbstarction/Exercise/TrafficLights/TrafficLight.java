package OOP.workingWhitAbstraction.TrafficLights;

public class TrafficLight {
    private Lights color;

    public TrafficLight(Lights color) {
        this.color = color;
    }
    public void changeLight(){
        switch (this.color){
            case RED:
                this.color = Lights.GREEN;
                break;
            case GREEN:
                this.color = Lights.YELLOW;
                break;
            case YELLOW:
                this.color = Lights.RED;
        }
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}