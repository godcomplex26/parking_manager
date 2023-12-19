package com.java.parking;

import java.util.ArrayList;
import java.util.function.Predicate;

public class CRUD<T> {
    private ArrayList<T> list = new ArrayList<>();

    // Create
    public void add(T item) {
        list.add(item);
    }

    // Read
    public T get(int index) {
        return list.get(index);
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(list);
    }

    // Update
    public void update(int index, T item) {
        list.set(index, item);
    }

    // Delete
    public void delete(int index) {
        list.remove(index);
    }

    // Find (optional, based on a condition)
    public ArrayList<T> find(Predicate<T> condition) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}