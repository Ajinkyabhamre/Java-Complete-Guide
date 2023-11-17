import java.util.*;

public class HashMapCode {
    static class myHashMap<K,V>{ //<K,V> --> Generics -> K,V can have any datatype
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n size of nodes
        private int N; //N bucket length
        private LinkedList<Node> buckets[];  //N -> buckets length

        @SuppressWarnings("unchecked") // it supresses warning since we are not defining type of LL array
        public myHashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i< 4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N ;
        }

        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key){
                    return di ;
                }
                di++ ;
            }

            return -1 ;
        }
          @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[N*2];
            N = 2*N; 
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            //nodes --> add in bucket
            for (int i = 0; i < oldbucket.length; i++) {
                LinkedList<Node> ll = oldbucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){    //O(lambda) --> O(1)
            int bi = hashFunction(key); // 0 to 3
            int di = SearchInLL(key, bi); //valid ->update  : -1 -> newNode

            if(di != -1){
             Node node = buckets[bi].get(di);
             node.value = value ;
            }else{
                buckets[bi].add(new Node(key, value));
                n++ ;
            }

            double lambda = (double)n/N ;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){   //O(1)
            int bi = hashFunction(key); 
            int di = SearchInLL(key, bi); 

            if(di != -1){
            return true ;
            }else{
                return false ;
            }
        }

        public V get(K key){        //O(1)
            int bi = hashFunction(key); 
            int di = SearchInLL(key, bi); 

            if(di != -1){
             Node node = buckets[bi].get(di);
             return node.value ;
            }else{
             return null ;
            }
        }

        public V remove(K key){
        int bi = hashFunction(key); 
        int di = SearchInLL(key, bi); 

            if(di != -1){
             Node node = buckets[bi].remove(di);
             n--;
            return node.value ;
            }else{
            return null ;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys ;
        }

        public boolean isEmpty(){
            return n==0 ;
        }

    }
    
public static boolean validAnagram(String s, String t){

HashMap<Character, Integer> map = new HashMap<>();
for (int i = 0; i < s.length(); i++) {
    char ch = s.charAt(i);
    map.put(ch, map.getOrDefault(ch, 0) + 1);
}

for (int j = 0; j < t.length(); j++) {
    char ch = t.charAt(j);
    if (map.get(ch) != null) {
        if (map.get(ch) == 1) {
            map.remove(ch);
        }else{
            map.put(ch, map.get(ch) - 1);
        }
    }else{
        return false ;
    }
}
return map.isEmpty();
    }
    
    public static void main(String[] args) {
        // myHashMap<String, Integer> hm = new myHashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("USA", 50);
        // hm.put("Nepal", 5);

        // ArrayList< String> keys = hm.keySet();
        // for (String key : keys) {
        //     System.out.println(key);
        // }

        // System.out.println(hm.get("India"));
        //  System.out.println(hm.remove("India"));
        //   System.out.println(hm.get("India"));

//LinkedHashMap -> keys are insertion order
    //LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    // lhm.put("India", 100);
    // lhm.put("USA", 50);
    // lhm.put("China", 150);

    // System.out.println(lhm);

//TreeMap -> Keys are Sorted -> O(logn)
    // TreeMap<String, Integer> tm = new TreeMap<>();
    // tm.put("USA", 50);
    // tm.put("India", 100);
    // tm.put("China", 150);

    // System.out.println(tm);


//Q. Majority Element
    // int arr[] = {1,3,2,5,1,3,1,5,1};    
    // HashMap<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < arr.length; i++) {
    //  map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    // }

    // for (Integer key :  map.keySet()) {
    //     if (map.get(key) > arr.length/3) {
    //         System.out.println(key);
    //     }
    // }

//Q.Valid Anagram
    // String s = "race";
    // String t = "care";
    // System.out.println(validAnagram(s,t));


//HashSet
    // HashSet<Integer> set = new HashSet<>();
    // set.add(1);
    // set.add(2);
    // set.add(4);
    // set.add(2);
    // set.add(1);

    // System.out.println(set);

    // if (set.contains(2)) {
    //     System.out.println("contains 2");
    // }
    // set.remove(2);
    // System.out.println(set);

    // set.clear();
    // System.out.println(set.size());
    // System.out.println(set.isEmpty());


//Iterations on HashSets
    // HashSet<String> cities = new HashSet<>();
    // cities.add("New York");
    // cities.add("Tokyo");
    // cities.add("Mumbai");
    // cities.add("Berlin");

    // Iterator it = cities.iterator();
    // while (it.hasNext()) {
    //     System.out.println(it.next());
    //}
//Adv loop
    // for (String city : cities) {
    // System.out.println(city); 
    // }

//Linked Hash Set
    // LinkedHashSet<String> lhs = new LinkedHashSet<>();
    // lhs.add("New York");
    // lhs.add("Tokyo");
    // lhs.add("Mumbai");
    // lhs.add("Berlin");
    // System.out.println(lhs);
    // lhs.remove("Mumbai");
    // System.out.println(lhs);

//Tree Set
    // TreeSet<String> ts = new TreeSet<>();
    // ts.add("New York");
    // ts.add("Tokyo");
    // ts.add("Mumbai");
    // ts.add("Berlin");

    // System.out.println(ts);


//Q. Count Distinct Numbers

    // int num[]  = {4,3,2,5,6,7,3,4,2,1};
    // HashSet<Integer> set = new HashSet<>();
    // for (int i = 0; i < num.length; i++) {  //O(n)
    //     set.add(num[i]);
    // } 

    // System.out.println("Count of total distict no.s are " + set.size());

//Q. Union And Intersection
    // int arr1[] = {7,3,9};
    // int arr2[] = {6,3,9,2,9,4};
    // HashSet<Integer> set = new HashSet<>();
    // for (int i = 0; i < arr1.length; i++) {
    // set.add(arr1[i]);    
    // }
    // for (int i = 0; i < arr2.length; i++) {
    // set.add(arr2[i]);    
    // }
    // System.out.println("union set size = " + set.size() );

    // //Intersection
    // set.clear();
    // for (int i = 0; i < arr1.length; i++) {
    // set.add(arr1[i]);    
    // }
    // int count = 0;
    // for (int i = 0; i < arr2.length; i++) {
    // if (set.contains(arr2[i])) {
    //     count++ ;
    //     set.remove(arr2[i]);  
    // }  
    // }
    // System.out.println("Intersection set size = " + count );


//Q. Largest subarray with zero sum

int arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; 
HashMap<Integer, Integer> map = new HashMap<>();
//(sum, idx)
int sum = 0; int len = 0 ;

for (int i = 0; i < arr.length; i++) {
    sum += arr[i];
    if (map.containsKey(sum)) {
        len = Math.max(len, i - map.get(sum));
    }else{
        map.put(sum, i);
    }
}

System.out.println("Length of largest subarray with sum zero is " + len);


    }
}
