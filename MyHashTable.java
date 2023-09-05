package lesson10.hwHash;

import java.util.LinkedList;

public class MyHashTable {
    private static final int DEFAULT_CAPAСITY = 10;
    private LinkedList<Entry>[] table;
    private  int size;

    public MyHashTable(){
        this(DEFAULT_CAPAСITY);
    }

    public MyHashTable(int capacity){
        table = new LinkedList[capacity];
        size = 0;
    }

    public void put(String key, int value){
        int index = hash(key);
        if (table[index] == null){
            table[index] = new LinkedList<>();
        }

        for (Entry entry : table[index]){
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry(key,value));
        size++;
    }

    public int get(String key){
        int index = hash(key);
        if (table[index] != null){
            for (Entry entry : table[index]){
                if (entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        throw new IllegalArgumentException("Key is not found");
    }

    public void remove(String key){
        int index = hash(key);
        if (table[index] != null){
            table[index].removeIf(entry -> entry.getKey().equals(key));
            size--;
        }
    }

    public int size(){
        return size;
    }

    private int hash(String key){
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LinkedList<Entry> list : table) {
            if (list != null) {
                for (Entry entry : list) {
                    result.append(entry.toString()).append(", ");
                }
            }
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2); // Удаляем последнюю запятую и пробел
        }
        return "[" + result.toString() + "]";
    }





}
