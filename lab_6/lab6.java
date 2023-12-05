package Java_lab_2023.lab_6;

import Java_lab_2023.lab_6.salat.Salat;
import Java_lab_2023.lab_6.vegetables.*;

public class lab6 {
     /* 
    C_13 =3
    Визначити ієрархію овочів. Зробити салат. Порахувати калорійність салату.
    Провести сортування овочів для салату на основі одного з параметрів. Знайти
    овоч у салаті, , що відповідає заданому діапазону калорійності.
    */
    public static void main(String[] args) throws Exception {
        Tomat tomat = new Tomat("simple tomat", 200, 4, 3);
        Onion onion = new Onion("simple onion", 100, 3, 3);
        Cucumber cucumber = new Cucumber("just cucumber", 300, 5, 2);

        Salat salat = new Salat();
        salat.addVegetble(tomat);
        salat.addVegetble(onion);
        salat.addVegetble(cucumber);
        
        System.out.println(salat.calculateCalority());
        for (Vegetable veg : salat.getVegetables()) {
            System.out.println(veg.toString());
        }
        salat.caloritySorting();
        for (Vegetable veg : salat.getVegetables()) {
            System.out.println(veg.toString());
        }
    }
}
