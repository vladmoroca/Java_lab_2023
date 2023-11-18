package Java_lab_2023.lab_4;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private String name;
    private int age;
    private double average_score;
    private String group;
    private int studentId;

    // Конструктор
    public Student(String name, int age, double average_score, String group, int studentId) {
        this.name = name;
        this.age = age;
        this.average_score = average_score;
        this.group = group;
        this.studentId = studentId;
    }

    // Гетери і сетери для полів класу

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return average_score;
    }

    public void setAverageScore(double average_score) {
        this.average_score = average_score;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static void sortByAge(Student[] students) {
        try {
            Arrays.sort(students, Comparator.comparingDouble(Student::getAge)); 
        } catch (Exception e) {
            System.err.println("Sort by age error");
            e.printStackTrace();
        }
    }

    public static void sortByScore(Student[] students) {
        try {
            Arrays.sort(students, Comparator.comparingDouble(Student::getAverageScore).reversed());
        } catch (Exception e) {
            System.err.println("Sort by score error");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", average_score=" + average_score +
                '}';
    }
}

