package lesson10.hwHash;

public class HashTableTester {

    public static void main(String[] args) {
        MyHashTable hashTable = new MyHashTable();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("Size: " + hashTable.size());
        System.out.println("Value for key 'two': " + hashTable.get("two"));
        System.out.println("HashTable: " + hashTable);

        hashTable.remove("one");
        System.out.println("Size after removing 'one': " + hashTable.size());
        System.out.println("HashTable after removal: " + hashTable);
    }
}

