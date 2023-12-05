package Java_lab_2023.lab_7.MySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import Java_lab_2023.lab_7.vegetables.Vegetable;

class Node {
    private Vegetable data;
    public Node next;
    public Node prev;

    public Node(Vegetable data){
        this.data = data;
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
       this.head = null;
       this.tail = null;
       this.size = 0;
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
    public boolean add(Vegetable vegetable){
        if(contains(vegetable)) return false;
        Node node = new Node(vegetable);
        if(head == null){
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
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
    public boolean remove(Object o){
        if (o instanceof Vegetable) {
            Vegetable vegetable = (Vegetable) o;
            Node current = head;
            while (current != null) {
                if (current.getData().equals(vegetable)) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection){
        boolean result = true;
        for(Object o : collection){
            result = result && remove(o);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
    }

    @Override
    public Vegetable[] toArray() {
        Node current = head;
        Vegetable[] arr= new Vegetable[size];
        int i = 0;
        while (current != null) {
            arr[i] = current.getData();
            i++;
            current = current.next;
            }
        return arr;
    }

    public void sort(Comparator<? super Vegetable> comparator) {
        List<Vegetable> sortedList = new ArrayList<>(this);
        Collections.sort(sortedList, comparator);
        
        clear();
        addAll(sortedList);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Unimplemented method 'toArray'");
    }

}