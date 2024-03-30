package org.example;

public interface ListInterface<T> {
    void add(T data);
    void add(T data, int index);
    T findByIndex(int index);
    void print();
    void remove(int index);

}
