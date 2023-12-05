package Java_lab_2023.lab_6.vegetables;


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
