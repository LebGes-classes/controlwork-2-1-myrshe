package org.example;

import javax.naming.SizeLimitExceededException;

public class ArrayList<T> implements ListInterface<T>{
    int size;

    int capacity;
    T[] array;

    public ArrayList() {
        capacity = 10;
        array = (T[]) new Object[capacity];
    }

    public ArrayList(int capacity) throws SizeLimitExceededException {
        if (capacity == 0) {
            throw new SizeLimitExceededException();
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void increaseCapacity() {
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    @Override
    public void add(T data) {
        if (size >= capacity) {
            increaseCapacity();
        }
        array[size] = data;
        size++;
    }

    @Override
    public void add(T data, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        array[capacity - 1] = data;
        for(int i = 0; i < (capacity - index - 1); i++){
            T elem = array[capacity - i - 1];
            array[capacity - i - 1] = array[capacity - i - 2];
            array[capacity - i - 2] = elem;
        }
        size++;
    }

    @Override
    public T findByIndex(int index) {
        return array[index];
    }

    @Override
    public void print() {

        for (Object data: array) {
            System.out.print(data + " ");
        }
        System.out.println();

    }

    @Override
    public void remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            T elem = findByIndex(index);
            for (int i = index; i < size; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }
}
