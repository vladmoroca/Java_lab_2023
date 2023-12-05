package Java_lab_2023.lab_4;


public class Lab4 {
    /* 
    variant 1121
    C11 = 10
    Визначити клас студент, який складається як мінімум з 5-и полів.
    */

    public static void main(String[] args) throws Exception {
        Student[] students = {
            new Student("John", 20, 4.5, "IM-11", 1),
            new Student("Alice", 22, 3.2, "IM-11", 2),
            new Student("Bob", 21, 4.8, "IM-12", 3),
            new Student("Bob2", 21, 3.6, "IM-12", 4),
            new Student("Bob3", 24, 4.2, "IM-13", 5),
        };
        System.out.println("age sorting");
        Student.sortByAge(students);
        for (Student stud : students) {
            System.out.println(stud);
        }
        System.out.println("score sorting");
        Student.sortByScore(students);
        for (Student stud : students) {
            System.out.println(stud);
        }
    }

}
