package Java_lab_2023.lab_6.vegetables;

public class Tomat extends Vegetable {
    private int size;

    public Tomat(String name, int calories, int ripeness, int size) {
        super(name, calories, ripeness);
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}
