package OOP.encapsulation.SortByNameAndAge;

import java.util.Comparator;
import java.util.List;

public class Sort {
    private List<Person> personList;


    public static void sort(List<Person>personList){
        personList.sort(Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));
    }

}
