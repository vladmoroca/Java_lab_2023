package Java_lab_2023.lab_7.vegetables;

public class Onion extends Vegetable {
    private int pungency;

    public Onion(String name, int calories, int ripeness, int pungency) {
        super(name, calories, ripeness);
        this.pungency = pungency;
    }

    public int getPungency(){
        return pungency;
    }
}
