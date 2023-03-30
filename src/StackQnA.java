import java.util.* ;

public class StackQnA {
   public static class Node{
    int data ;
    Node next  ;

    public Node(int data){
        this.data = data ;
        this.next = null ;
    }
   }

public static boolean isPalindrome(Node head){
    Node slow = head ;
    Stack<Integer> s = new Stack<>();
    boolean isPalin = true ;
    while (slow != null) {
        s.push(slow.data);
        slow = slow.next ;
    }

    while (head != null) {
        int i = s.pop();
        if (head.data == i) {
            isPalin = true ;
        }else{
            isPalin = false ;
            break ;
        }
        head = head.next ;
    }
    return isPalin ;

   }

public static String simplifyPath(String path){

Stack<String> s = new Stack<>();
String res = "";
res += "/" ;
for (int i = 0; i < path.length(); i++) {
    String dir = "";
    while (i < path.length()  && path.charAt(i) == '/') {
        i++ ;
    }

    while (i < path.length() && path.charAt(i) != '/') {
        dir += path.charAt(i);
        i++;
    }

    if (dir.equals(".") == true) {
        continue ;
    }
    else if(dir.equals("..")){
        if (!s.isEmpty()) {
            s.pop();
        }
    }
    else if(dir.length() != 0){
        s.push(dir);
    }
}

Stack<String> st = new Stack<>();
while (!s.isEmpty()) {
    st.push(s.pop());
}
while (!st.isEmpty()) {
    if (st.size() != 1) {
        res += st.pop() + "/" ;
    }else{
        res += st.pop() ;
    }
}

return res ;


}

public static String decodeString(String str){
Stack<Integer> counts = new Stack<>();
Stack<String> result = new Stack<>();
String res = "";
int index = 0 ;

while (index < str.length()) {
    if (Character.isDigit(str.charAt(index))) {
        int count = 0 ;
        while (Character.isDigit(str.charAt(index))) {
            count = count * 10 + str.charAt(index) - '0' ;
            index++ ;
        }
        counts.push(count) ;
    }else if(str.charAt(index) == '['){
        result.push(res);
        res = "";
        index++ ;
    }else if (str.charAt(index) == ']') {
        StringBuilder temp = new StringBuilder(result.pop());
        int count = counts.pop();
        for (int i = 0; i < count; i++) {
            temp.append(res);
        }
        res = temp.toString() ;
        index++ ;
    }else{
        res += str.charAt(index); 
        index++ ;
    }
}
return res ;
}

public static int trappedWater(int[] heights){
int ans = 0;
Stack<Integer> s = new Stack<>() ;

    for (int i = 0; i < heights.length; i++) {
        while (!s.isEmpty() && heights[s.peek()] < heights[i]) {
                int pop_ht = heights[s.peek()];
                s.pop();
                if (s.isEmpty()) {
                    break;
                }
                int distance = i - s.peek() - 1 ;
                int min_ht = Math.min(heights[s.peek()], heights[i]) - pop_ht;
                ans += distance * min_ht ;
            }
        s.push(i);    
    }
return ans ;
}
   public static void main(String[] args) {
//Q.1. Palindrome Linked List
    // Node one = new Node(1);
    // Node two = new Node(2);
    // Node three = new Node(3);
    // Node four = new Node(4);
    // Node five = new Node(3);
    // Node six = new Node(2);
    // Node seven = new Node(1);

    // one.next = two;
    // two.next = three ;
    // three.next = four ;
    // four.next = five;
    // five.next = six ;
    // six.next = seven;

    // boolean checkCondition = isPalindrome(one);
    // System.out.println(checkCondition);


//Q.2. Simplify Path
    // String str = "/a/./b/../../c/";
    // String newstr = simplifyPath(str);
    // System.out.println(newstr);

//Q.3. Decode a string
    //String str = new String("2[c3[v]]");
    // String newStr = decodeString(str);
    // System.out.println(newStr);

//Q.4. Trapping Rain Water
int[] heights = {7, 0, 4, 2, 5, 0, 6, 4, 0, 6 };
int trapwater = trappedWater(heights);
System.out.println(trapwater);








}
}
