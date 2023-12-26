package Java_lab_2023.lab_8.demo.src.test.java;

import Java_lab_2023.lab_8.demo.src.main.java.MySet.MySet;
import Java_lab_2023.lab_8.demo.src.main.java.exceptions_hadler.MyExceptionHandler;
import Java_lab_2023.lab_8.demo.src.main.java.salat.Salat;
import Java_lab_2023.lab_8.demo.src.main.java.vegetables.Onion;
import Java_lab_2023.lab_8.demo.src.main.java.vegetables.Tomat;
import Java_lab_2023.lab_8.demo.src.main.java.vegetables.Vegetable;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SalatTest {

    @Test
    void testAddVegetable() {
        Salat salat = new Salat();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);

        salat.addVegetble(tom1);
        assertTrue(salat.getVegetables().contains(tom1));
    }

    @Test
    void testCalculateCalority() {
        Salat salat = new Salat();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Onion onion1 = new Onion("On1", 50, 1, 6);

        salat.addVegetble(tom1);
        salat.addVegetble(onion1);

        assertEquals(150, salat.calculateCalority());
    }

    @Test
    void testCaloritySearch() {
        Salat salat = new Salat();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Onion onion1 = new Onion("On1", 50, 1, 6);
        Onion onion2 = new Onion("On2", 70, 1, 6);

        salat.addVegetble(tom1);
        salat.addVegetble(onion1);
        salat.addVegetble(onion2);

        MySet result = salat.caloritySearch(60, 80);

        assertEquals(1, result.size());
        assertTrue(result.contains(onion2));
    }

    @Test
    void testCaloritySorting() {
        Salat salat = new Salat();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Onion onion1 = new Onion("On1", 50, 1, 6);
        Onion onion2 = new Onion("On2", 70, 1, 6);

        salat.addVegetble(tom1);
        salat.addVegetble(onion1);
        salat.addVegetble(onion2);

        salat.caloritySorting();
        Object[] sortedVegetables = salat.getVegetables().toArray();
        assertEquals(onion1, sortedVegetables[0]);
        assertEquals(onion2, sortedVegetables[1]);
        assertEquals(tom1, sortedVegetables[2]);
    }

    @Test
    void testAddInvalidVegetable() {
        Salat salat = new Salat();
        Tomat tom1 = null;

        MyExceptionHandler exception = assertThrows(MyExceptionHandler.class, () -> salat.addVegetble(tom1));
        assertEquals("Error adding to Salat", exception.getMessage());
    }
}
