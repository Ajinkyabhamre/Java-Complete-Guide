import java.util.*;
public class Hashing {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 50);
        hm.put("USA", 20);
        hm.put("Indonasia", 29);
        hm.put("UK", 40);

        System.out.println(hm);

    //     //Get - O(1)
    //    int population =  hm.get("India");
    //    System.out.println(population);

    //    System.out.println(hm.get("pakistan"));

    //    //ContainsKey - O(1) True/False
    //    System.out.println(hm.containsKey("India"));
    //    System.out.println(hm.containsKey("pakistan"));

    //    //Remove - O(1)
    //    System.out.println(hm.remove("China"));
    //    System.out.println(hm.remove("pakistan"));
    //    System.out.println(hm);

    //    //Size
    //    System.out.println(hm.size());

    //    //isEmpty
    //    hm.clear();
    //    System.out.println(hm.isEmpty());
       

    //Iteraiton
    //hm.entrySet(); --> pairs
    Set<String> keys = hm.keySet();
    System.out.println(keys);

    for (String k : keys) {
        System.out.println("key = " + k + ", value = " + hm.get(k));
    }

    }
}
