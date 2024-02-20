package OOP.workingWhitAbstraction.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public Map<String, Student> getStudentMap() {
        return this.studentMap;
    }

    public void ParseCommand(String[] commands) {


        if (commands[0].equals("Create")) {
            String name = commands[1];
            int age = Integer.parseInt(commands[2]);
            double grade = Double.parseDouble(commands[3]);
            if (!studentMap.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentMap.put(name, student);
            }
        } else if (commands[0].equals("Show")) {
            var name = commands[1];
            if (studentMap.containsKey(name)) {
                Student student = studentMap.get(name);
                String currentStudent = String.format("%s is %s years old.", student.getName(), student.getAge());

                if (student.getGrade() >= 5.00) {
                    currentStudent += " Excellent student.";
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    currentStudent += " Average student.";
                } else {
                    currentStudent += " Very nice person.";
                }

                System.out.println(currentStudent);
            }
        }
    }
}
