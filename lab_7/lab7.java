package Java_lab_2023.lab_7;

import Java_lab_2023.lab_7.salat.Salat;
import Java_lab_2023.lab_7.vegetables.*;

public class lab7 {
     /* 
    C_2 = 1
    Set
    C_3 = 2
    Двозв’язний список
    */
    public static void main(String[] args) throws Exception {
        Tomat tomat = new Tomat("simple tomat", 200, 4, 3);
        Onion onion = new Onion("simple onion", 100, 3, 3);
        Cucumber cucumber = new Cucumber("just cucumber", 300, 5, 2);

        Salat salat = new Salat();
        salat.addVegetble(tomat);
        salat.addVegetble(onion);
        salat.addVegetble(cucumber);
        for (Vegetable vegetable : salat.caloritySearch(50, 250)) {
            System.out.println(vegetable);
        }
        System.out.println(salat.calculateCalority());
        for (Vegetable vegetable : salat.getVegetables()) {
            System.out.println(vegetable);
        }
        salat.caloritySorting();
        for (Vegetable veg : salat.getVegetables()) {
            System.out.println(veg);
        }
    }
}
