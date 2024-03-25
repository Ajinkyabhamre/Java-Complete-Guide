import java.util.*;
import java.util.Arrays;
public class xyz {

    public static double fact(double n){
        if (n==0) {
            return 1;
        }
    return fact(n - 1)*n;
    }
    public static double func(int n, int k){
        double X = 5; double Y = 21; int count = 0;double finalAdd = 0 ;
        for (double i = 0; i <= k; i++) {
            double res1 = fact(n)/(fact(n - i) * fact(i));
            double res2 = Math.pow(X, i);
            double res3 = Math.pow(Y, n-i);
            double add = res1 * res2 * res3;
            finalAdd  += add ;
            count++; 

        }
      
        return finalAdd;
    }
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sorted = new String(charArr);
            System.out.println(sorted);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(strs[i]);
        }
      return new ArrayList<>(map.values());
     }
    
     
     
     public static void main(String[] args) {
    
      
      
 //      System.out.println( func(4, 2));
    //    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    // System.out.println(groupAnagrams(strs)); 

    

    }
}
