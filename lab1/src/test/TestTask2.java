package test;

import main.task2.ClosedAddressingHashTable;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TestTask2 {
    ClosedAddressingHashTable table;

    @Before
    public void recreate() {
        table = new ClosedAddressingHashTable(10);
    }

    @Test
    public void simpleInsert(){
        long value = 13;
        table.insert(value);
        assertTrue(table.find(value));
    }

    @Test
    public void insertPresentValue() {
        long value = 13;
        table.insert(value);
        assertTrue(table.find(value));
        table.insert(value);
        assertTrue(table.find(value));
        // after delete and find we make sure that previous value was not overwritten
        assertTrue(table.delete(value));
        assertTrue(table.find(value));
    }

    @Test
    public void insertDifferentValueWithPresentIndex() {
        long value1 = 0;
        table.insert(value1);
        assertTrue(table.find(value1));
        long value2 = 10;
        table.insert(value2);
        // they both will be inserted with index 0
        assertTrue(table.find(value1));
        assertTrue(table.find(value2));
    }

    @Test
    public void insertDifferentValues() {
        long value1 = 33;
        table.insert(value1);
        assertTrue(table.find(value1));
        table.insert(value1);
        assertTrue(table.find(value1));
        long value2 = 777;
        table.insert(value2);
        assertTrue(table.find(value2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNotValidValue1() {
        long value = -15;
        table.insert(value);
    }

    @Test (expected = IllegalArgumentException.class)
    public void insertNotValidValue2() {
        long value = 99999999999L;
        table.insert(value);
    }

    @Test (expected = NoSuchElementException.class)
    public void findNotPresentValue() {
        long value = 333;
        table.find(value);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findNotValidValue1() {
        long value = -37;
        table.find(value);
    }

    @Test (expected = IllegalArgumentException.class)
    public void findNotValidValue2() {
        long value = 185151564313L;
        table.find(value);
    }

    @Test
    public void findPresentValue() {
        long value = 1;
        table.insert(value);
        assertTrue(table.find(value));
    }

    @Test (expected = NoSuchElementException.class)
    public void deleteNotPresentValue() {
        long value = 87;
        table.delete(value);
    }

    @Test
    public void deletePresentValue() {
        long value = 256;
        table.insert(value);
        assertTrue(table.delete(value));
    }

    @Test
    public void deleteSamePresentValue() {
        long value = 981;
        table.insert(value);
        table.insert(value);
        assertTrue(table.delete(value));
        assertTrue(table.delete(value));
    }

    @Test (expected = IllegalArgumentException.class)
    public void deleteNotValidValue1() {
        long value = -15;
        table.delete(value);
    }

    @Test (expected = IllegalArgumentException.class)
    public void deleteNotValidValue2() {
        long value = 99999999999L;
        table.delete(value);
    }

    @Test
    public void checkToString(){
        table.insert(2);
        table.insert(2);
        table.insert(2);
        table.insert(9);
        table.insert(15);
        table.insert(12);
        assertEquals("[{},{},{12->2->2->2},{},{},{15},{},{},{},{9}]", table.toString());
    }
}
