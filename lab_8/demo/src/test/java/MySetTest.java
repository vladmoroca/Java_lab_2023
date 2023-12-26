package Java_lab_2023.lab_8.demo.src.test.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Java_lab_2023.lab_8.demo.src.main.java.MySet.MySet;
import Java_lab_2023.lab_8.demo.src.main.java.exceptions_hadler.MyExceptionHandler;
import Java_lab_2023.lab_8.demo.src.main.java.vegetables.*;

class MySetTest {

    @Test
    void testAdd() {
        MySet mySet = new MySet();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);

        assertTrue(mySet.add(tom1));
        assertTrue(mySet.contains(tom1));
        assertEquals(1, mySet.size());
    }

    @Test
    void testAddAll() {
        MySet mySet = new MySet();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Tomat tom2 = new Tomat("Tom2", 120, 3, 4);

        assertTrue(mySet.addAll(List.of(tom1, tom2)));
        assertTrue(mySet.contains(tom1));
        assertTrue(mySet.contains(tom2));
        assertEquals(2, mySet.size());
    }

    @Test
    void testRemove() {
        MySet mySet = new MySet();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);

        mySet.add(tom1);

        assertTrue(mySet.remove(tom1));
        assertFalse(mySet.contains(tom1));
        assertEquals(0, mySet.size());
    }

    @Test
    void testRemoveAll() {
        MySet mySet = new MySet();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Tomat tom2 = new Tomat("Tom2", 120, 3, 4);

        mySet.addAll(Arrays.asList(tom1, tom2));

        assertTrue(mySet.removeAll(Arrays.asList(tom1, tom2)));
        assertFalse(mySet.contains(tom1));
        assertFalse(mySet.contains(tom2));
        assertEquals(0, mySet.size());
    }

    @Test
    void testRetainAll() {
        MySet mySet = new MySet();
        Tomat tom1 = new Tomat("Tom1", 100, 2, 3);
        Tomat tom2 = new Tomat("Tom2", 120, 3, 4);

        mySet.addAll(Arrays.asList(tom1, tom2));

        assertTrue(mySet.retainAll(Arrays.asList(tom1)));
        assertTrue(mySet.contains(tom1));
        assertFalse(mySet.contains(tom2));
        assertEquals(1, mySet.size());
    }

    @Test
    void testAddInvalidElement() {
        MySet mySet = new MySet();
        Tomat tom1 = null;

        MyExceptionHandler exception = assertThrows(MyExceptionHandler.class, () -> mySet.add(tom1));
        assertEquals("Error adding to MySet", exception.getMessage());
    }

    @Test
    void testRemoveInvalidElement() {
        MySet mySet = new MySet();
        Tomat tom1 = null;

        MyExceptionHandler exception = assertThrows(MyExceptionHandler.class, () -> mySet.remove(tom1));
        assertEquals("Error removing from MySet", exception.getMessage());
    }

    @Test
    void testRemoveAllInvalidElement() {
        MySet mySet = new MySet();
        Tomat tom1 = null;
        Onion on2 = null;

        MyExceptionHandler exception = assertThrows(MyExceptionHandler.class, () -> mySet.removeAll(Arrays.asList(tom1, on2)));
        assertEquals("Error removing from MySet", exception.getMessage());
    }
}