package Java_lab_2023.lab_7.salat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import Java_lab_2023.lab_7.MySet.MySet;
import Java_lab_2023.lab_7.vegetables.*;

public class Salat {
    private Set<Vegetable> vegetables = new MySet();

    public void addVegetble(Vegetable vegetable){
        vegetables.add(vegetable);
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

    public MySet caloritySearch(int from, int to){
        MySet found = new MySet();
        for(Vegetable vegetable : vegetables){
            int calority = vegetable.getCalories();
            if(calority >= from && calority <= to){
                found.add(vegetable);
            }
        }
        return found;
    }

    public void caloritySorting(){
        vegetables.sort(Comparator.comparingInt(Vegetable::getCalories));
    }    
}
