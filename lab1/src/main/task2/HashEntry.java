package main.task2;

public class HashEntry {
    private long value;
    private HashEntry next;

    HashEntry(long value) {
        this.value = value;
        this.next = null;
    }

    HashEntry(long value, HashEntry entry) {
        this.value = value;
        this.next = entry;
    }

    public long getValue() {
        return value;
    }

    public HashEntry getNext() {
        return next;
    }

    public void setNext(HashEntry next) {
        this.next = next;
    }
}