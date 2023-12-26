package Java_lab_2023.lab_8.demo.src.main.java.vegetables;

public class Vegetable {
    private String name;
    private int calories;
    private int ripeness;

    public Vegetable(String name, int calories, int ripeness) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (calories <= 0 || ripeness < 0) {
            throw new IllegalArgumentException("Calories and ripeness must be greater than 0");
        }
        
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