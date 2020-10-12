package main.task2;

import java.util.NoSuchElementException;

public class ClosedAddressingHashTable {
    private final int tableSize;
    private final HashEntry[] table;

    public ClosedAddressingHashTable(int size) {
        tableSize = size;
        table = new HashEntry[tableSize];
        for (int i = 0; i < tableSize; i++)
            table[i] = null;
    }

    public void insert(long value) {
        if (validateValue(value)) {
            int index = this.calcHash(value);
            if (table[index] == null) {
                table[index] = new HashEntry(value);
            } else {
                table[index] = new HashEntry(value, table[index]);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean find(long value) {
        if (validateValue(value)) {
            int index = this.calcHash(value);

            if (table[index] == null)
                throw new NoSuchElementException();

            HashEntry next = table[index];
            do {
                if (next.getValue() == value)
                    return true;

                next = next.getNext();
            } while (next != null);

            throw new NoSuchElementException();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean delete(long value) {
        if (validateValue(value)) {
            int index = this.calcHash(value);

            if (table[index] == null)
                throw new NoSuchElementException();

            if (table[index].getValue() == value) {
                table[index] = table[index].getNext();
                return true;
            }

            HashEntry prev = table[index];
            HashEntry current = table[index].getNext();
            while (prev.getNext() != null){
                if (current.getValue() == value) {
                    prev.setNext(current.getNext());
                    return true;
                }

                prev = current;
                current = current.getNext();
            }

            throw new NoSuchElementException();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private int calcHash(long value) {
        return (int) (value % tableSize);
    }

    private boolean validateValue(long value) {
        return (value >= 0 && value <= 9999999999L);
    }

    public String toString() {
        String result = "[";

        for (HashEntry item: table) {
            result += "{";
            HashEntry current = item;
            while (current != null) {
                result += current.getValue();
                current = current.getNext();
                if (current != null)
                    result += "->";
            }
            result += "},";
        }

        return result.substring(0, result.length() - 1) + "]";
    }
}
