package FirstAndReserveTeam;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstTeam;
    private List<Person> reserveTeam;

    public Team(String name) {
       setName(name);
        this.firstTeam = new ArrayList<>();
        this.reserveTeam = new ArrayList<>();

    }
    public void addPlayer (Person person){
        if (person.getAge() < 40){
           firstTeam.add(person);

        }else {
          reserveTeam.add(person);
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public List<Person> getFirstTeam() {
        return Collections.unmodifiableList(firstTeam);
    }

    private void setFirstTeam(List<Person> firstTeam) {
        this.firstTeam = firstTeam;
    }

    public List<Person> getReserveTeam() {
        return Collections.unmodifiableList(reserveTeam);
    }

    private void setReserveTeam(List<Person> reserveTeam) {
        this.reserveTeam = reserveTeam;
    }
}
