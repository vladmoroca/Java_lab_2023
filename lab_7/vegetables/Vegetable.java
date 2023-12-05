package Java_lab_2023.lab_7.vegetables;


public class Vegetable {
    private String name;
    private int calories;
    private int ripeness;

    public Vegetable(String name, int calories, int ripeness) {
        this.name = name;
        this.calories = calories;
        this.ripeness = ripeness;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getRipeness() {
        return ripeness;
    }

    public String toString(){
        return "{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", ripeness=" +ripeness +
                '}';
    }

}