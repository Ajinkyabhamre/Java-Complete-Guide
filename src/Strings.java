import java.util.Arrays;
import java.util.Scanner;

public class Strings {

    public static void printLetters(String fullName){
        for (int i = 0; i < fullName.length(); i++) {
            System.out.print(fullName.charAt(i) + " ");
        }
        System.out.println();
    }
    
    public static boolean checkPailindrome(String str){
        int n = str.length();
        for (int i = 0; i < n/2; i++) {
            if (str.charAt(i) != str.charAt(n - 1 - i)) {
                System.out.println(str + " is not a palindrome !");
                return false;
            }
        }
        System.out.println(str+" is a palindrome !");
        return true;
    }
    
    public static float getPath(String path){
    int x = 0, y = 0 ;
    for (int i = 0; i < path.length(); i++) {
        char dir = path.charAt(i);
        //South
        if (dir == 'S' ) {
        y--; 
        }else if(dir == 'N'){
            y++;
        }else if(dir == 'W'){
            x--;
        }else{
            x++;
        }
    }
    int X2 = x*x;
    int Y2 = y*y;
    return (float)Math.sqrt(X2 + Y2);
        }
    
    public static String substring(String str, int si, int ei){
        String substr = "";
        for (int i = si; i < ei; i++) {
            substr += str.charAt(i) ;
        }
        System.out.println();
        return substr ;

    }
    
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0)) ;
        sb.append(ch);
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public static String compressStr(String str){

    String st = "";
    for (int i = 0; i < str.length(); i++) {
        Integer count = 1;
        while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
            count++;
            i++;
        }
        st += str.charAt(i);
        if (count > 1) {
            st += count.toString();
        }
    }
    return st; 
}

    public static String stringCompression(String str){
        StringBuilder sb = new StringBuilder("");
        String st = new String("");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = 1 ;
            while ( i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)  ) {
                count++;
                i++;
            }
        sb.append(ch);
        if(count > 1){
            sb.append(count.toString());
            st += sb.toString();
        }
        }
        return sb.toString();
    }
    

//-----------------------------------------------------------------------------
public static boolean checkvowels(char ch){
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        return true;
    }
    return false;
}

public static int countVowels(String str){
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if (checkvowels(ch)) {
        count++;
    }
}
return count;
}


public static void checkAnagrams(String str1, String str2){

    //convert both strings to lowerCase
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    if (str1.length() == str2.length()) {
        
        //convert strings to arrays
        char stringArray1[] = str1.toCharArray();
        char stringArray2[] = str2.toCharArray();

        //sort the char array
        Arrays.sort(stringArray1);
        Arrays.sort(stringArray2);

        //check if both the arrays are same
        boolean result = Arrays.equals(stringArray1, stringArray2);

    if (result) {
        System.out.println(str1 + " and " + str2 + " are anagrams of each other !");
    }else{
        System.out.println(str1 + " and " + str2 + " are NOT anagrams of each other !");
    }

    }else{
        System.out.println(str1 + " and " + str2 + " are NOT anagrams of each other !");
    }

}



        public static void main(String[] args) {
       //strings are immutable
            // String str = "abcd";
            // String str2 = new String("efgh");
            // System.out.println(str + str2);

    //input - output

    // Scanner sc = new Scanner(System.in);
    // String name = sc.nextLine();
    // System.out.println(name);

//length() is a function in Strings, but its a property in arrays - array.length
    //System.out.println(name.length());

    // String firstName = "Ajinkya";
    // String lastName = "Bhamre";
    // String fullName = firstName + " " + lastName;
    // System.out.println(fullName); 
    // System.out.println(fullName.charAt(8));

    // printLetters(fullName);


    // String checkstr = "racpwcar";
    // checkPailindrome(checkstr);


    // String path = "WNEENESENNN";
    // System.out.println(getPath(path)); 

//subString
    // String str = "HelloWorld";
    // System.out.println(str.substring(0,4));

//find largest string - lexicographically using compareTo
    // String fruits[] = {"apple", "mango", "banana"};
    // String largest = fruits[0];
    // for (int i = 0; i < fruits.length; i++) {
    //     if (largest.compareTo(fruits[i]) < 0) {
    //         largest = fruits[i];
    //     }
    // }
    // System.out.println(largest);


//string-builder
// StringBuilder sb = new StringBuilder();
// for (char ch = 'a'; ch <= 'z'; ch++) {
//     sb.append(ch);
// }
// System.out.println(sb);

//For a given string convert each the first letter of each word to uppercase.
    // String str = "hi my name is ajinkya bhamre ";
    // System.out.println(toUpperCase(str));

//String Compression
//String str = "aaabbcccdd";
//System.out.println(compressStr(str));
//System.out.println(stringCompression(str));

//-----------------------------------------------------------------------------
//Q.1. Count how many times lowercase vowels occurred in a String entered by the user.
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter your string ----->");
    // String str = sc.nextLine();
    // System.out.println("no. of vowels in string are "+countVowels(str));


//Q.2. what will be the output ?

    // String str = "ShradhaDidi";
    // String str1 = "ApnaCollege";
    // String str2 = "ShradhaDidi";
    // System.out.println(str.equals(str1) +" "+str.equals(str2));

//Q.3. what will be the output ?

    // String str = "ApnaCollege".replace("l","");
    // System.out.println(str);
    

//Q.4. Determine if 2 Strings are anagrams of each other
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter two anagrams to compare -->");
    // String str1 = sc.nextLine();
    // String str2 = sc.nextLine();
    // checkAnagrams(str1, str2);





}
}
