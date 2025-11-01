package main.java;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("Ivan", 1);
        map.put("Anatoly", 2);
        map.put(null, 0);

        System.out.println(map.get("Ivan"));  // 1
        System.out.println(map.get("Anatoly")); // 2
        System.out.println(map.get(null));     // 0

        map.remove("Ivan");
        System.out.println(map.get("Ivan"));  // null

        System.out.println("Size: " + map.size()); // 2
    }
}
