package Java_lab_2023.lab_8.demo.src.main.java.MySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import Java_lab_2023.lab_8.demo.src.main.java.vegetables.Vegetable;
import Java_lab_2023.lab_8.demo.src.main.java.exceptions_hadler.MyExceptionHandler;

class Node {
    private Vegetable data;
    public Node next;
    public Node prev;

    public Node(Vegetable data){
        if(data == null){
            throw new MyExceptionHandler("Null data");
        } else {
            this.data = data;
        }
    }

    public Vegetable getData(){
        return data;
    }
}

public class MySet implements Set<Vegetable> {
    private Node head;
    private Node tail;
    private int size;

    public MySet(){
    }

    public MySet(Vegetable vegetable) {
        add(vegetable);
    }

    public MySet(Collection<? extends Vegetable> collection) {
        addAll(collection);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<>() {
            private Node current = head;
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Vegetable data = current.getData();
                current = current.next;
                i++;
                return data;
            }
        };
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Vegetable) {
            Vegetable vegetable = (Vegetable) o;
            Node current = head;
            while (current != null) {
                if (current.getData().equals(vegetable)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection){
        boolean result = true;
        if(collection.isEmpty()) return false;
        for(Object o : collection){
            result = result && contains(o);
        }
        return result;
    }

    @Override
    public boolean add(Vegetable vegetable) {
        try {
            if (contains(vegetable)) return false;
            Node node = new Node(vegetable);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            size++;
            return true;
        } catch (Exception e) {
            throw new MyExceptionHandler("Error adding to MySet", e);
        }
    }

    @Override
    public boolean addAll(Collection<? extends Vegetable> collection){
        boolean result = true;
        for(Vegetable vegetable : collection){
            result = result && add(vegetable);
        }
        return result;
    }

    @Override
    public boolean remove(Object o) {
        try {
            if (o == null) {
                throw new MyExceptionHandler("Error removing from MySet: element is null");
            }

            if (o instanceof Vegetable) {
                Vegetable vegetable = (Vegetable) o;
                Node current = head;
                while (current != null) {
                    if (current.getData().equals(vegetable)) {
                        Node prev = current.prev;
                        Node next = current.next;
                        if (prev != null) {
                            prev.next = next;
                        } else {
                            head = next;
                        }
                        if (next != null) {
                            next.prev = prev;
                        } else {
                            tail = prev;
                        }
                        size--;
                        return true;
                    }
                    current = current.next;
                }
            }
            return false;
        } catch (Exception e) {
            throw new MyExceptionHandler("Error removing from MySet", e);
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection){
        boolean result = true;
        for(Object o : collection){
            result = result && remove(o);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        try {
            if (collection == null) {
                throw new MyExceptionHandler("Error retaining in MySet: collection is null");
            }

            boolean modified = false;
            Iterator<Vegetable> iterator = iterator();
            while (iterator.hasNext()) {
                Vegetable currentVegetable = iterator.next();
                if (!collection.contains(currentVegetable)) {
                    remove(currentVegetable);
                    modified = true;
                }
            }
            return modified;
        } catch (Exception e) {
            throw new MyExceptionHandler("Error retaining in MySet", e);
        }
    }

    @Override
    public Vegetable[] toArray() {
        try {
            Node current = head;
            Vegetable[] arr= new Vegetable[size];
            int i = 0;
            while (current != null) {
                arr[i] = current.getData();
                i++;
                current = current.next;
            }
            return arr;
        } catch (Exception e) {
            throw new MyExceptionHandler("Error converting MySet to array", e);
        }
    }

    public void sort(Comparator<? super Vegetable> comparator) {
        try {
            List<Vegetable> sortedList = new ArrayList<>(this);
            Collections.sort(sortedList, comparator);

            clear();
            addAll(sortedList);
        } catch (Exception e) {
            throw new MyExceptionHandler("Error sorting MySet", e);
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }
}
