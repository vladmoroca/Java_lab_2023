package Java_lab_2023.lab_8.demo.src.main.java.vegetables;


public class Cucumber extends Vegetable {
    private int crunchiness;

    public Cucumber(String name, int calories, int ripeness, int crunchiness) {
        super(name, calories, ripeness);
        this.crunchiness = crunchiness;
    }

    public int getCrunchiness(){
        return crunchiness;
    }
}
