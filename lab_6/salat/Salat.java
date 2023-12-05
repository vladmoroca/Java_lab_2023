package Java_lab_2023.lab_6.salat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Java_lab_2023.lab_6.vegetables.*;

public class Salat {
    private ArrayList<Vegetable> vegetables = new ArrayList<>();

    public void addVegetble(Vegetable vegetable){
        vegetables.add(vegetable);
    }

    public ArrayList<Vegetable> getVegetables(){
        return vegetables;
    }

    public int calculateCalority(){
        int calories = 0;
        for(Vegetable vegetable : vegetables){
            calories = calories + vegetable.getCalories();
        }
        return calories;
    }

    public ArrayList<Vegetable> caloritySearch(int from, int to){
        ArrayList<Vegetable> found = new ArrayList<>();
        for(Vegetable vegetable : vegetables){
            int calority = vegetable.getCalories();
            if(calority >= from && calority <= to){
                found.add(vegetable);
            }
        }
        return found;
    }

    public void caloritySorting(){
        Collections.sort(vegetables, Comparator.comparingInt(Vegetable::getCalories));
    }    
}
