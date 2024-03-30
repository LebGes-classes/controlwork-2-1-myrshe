package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.naming.SizeLimitExceededException;
public class ArrayListTest {
    ArrayList array;
    int capacity;

    @BeforeEach
    void init() throws SizeLimitExceededException {
        capacity = 1;
        array = new ArrayList(capacity);
    }

    @Test
    void addToEndTestWithNormalCapacityTest() {
        array.add(12);
        array.add(12);
        array.add(12);
        Assertions.assertEquals(12, array.findByIndex(0));
    }
    @Test
    void addToEndTestWithNullCapacityTest() {
        capacity = 0;
        Assertions.assertThrows(SizeLimitExceededException.class, () -> new ArrayList(capacity));
    }

    

}
