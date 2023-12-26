package Java_lab_2023.lab_8.demo.src.main.java.salat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import Java_lab_2023.lab_8.demo.src.main.java.MySet.MySet;
import Java_lab_2023.lab_8.demo.src.main.java.exceptions_hadler.MyExceptionHandler;
import Java_lab_2023.lab_8.demo.src.main.java.vegetables.*;

public class Salat {
    private Set<Vegetable> vegetables = new MySet();

    public void addVegetble(Vegetable vegetable){
        try {
            vegetables.add(vegetable);
        } catch (Exception e) {
            throw new MyExceptionHandler("Error adding to Salat", e);
        }
    }

    public Set<Vegetable> getVegetables(){
        return vegetables;
    }

    public int calculateCalority(){
        int calories = 0;
        for(Vegetable vegetable : vegetables){
            calories = calories + vegetable.getCalories();
        }
        return calories;
    }

    public MySet caloritySearch(int from, int to) {
        MySet found = new MySet();
        try {
            for (Vegetable vegetable : vegetables) {
                int calority = vegetable.getCalories();
                if (calority >= from && calority <= to) {
                    found.add(vegetable);
                }
            }
        } catch (Exception e) {
            throw new MyExceptionHandler("Error in calority Search", e);
        }
        return found;
    }
    public void caloritySorting(){
        List<Vegetable> vegetableList = new ArrayList<Vegetable>(vegetables);
        vegetableList.sort(Comparator.comparingInt(Vegetable::getCalories));
        vegetables.clear();
        vegetables.addAll(vegetableList);
    }    
}
