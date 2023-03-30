import java.util.* ;
public class StackB {
 static class StackArr{
    static ArrayList<Integer> list = new ArrayList<>() ;
    //isEmpty func
    public static boolean isEmpty(){
        return list.size() == 0;
    }

    //push
    public static void push(int data){
        list.add(data);
    }

    //pop
    public static int pop(){
        //corner case
        if (isEmpty()) {
            return -1 ;
        }

        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top ;
    }

    //peek
    public static int peek(){
        //corner case
        if (isEmpty()) {
            return -1 ;
        }

        return list.get(list.size() - 1) ;
    }
 }
    
 static class Node{
    int data ;
    Node next ;
    Node(int data){
        this.data = data ;
        this.next = null ;
    }


}
static class StackLL{
    static Node head = null ;

    public static boolean isEmpty(){
        return head == null ;
    }

    //push
    public static void push(int data){
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            head = newNode ;
            return ;
        }

        newNode.next = head ;
        head = newNode ;

    }
    //pop
    public static int pop(){
        if (isEmpty()) {
            return -1 ;
        }

       int top = head.data ;
       head = head.next ;
       return top ;

    }

    //peek 
    public static int peek(){
        if (isEmpty()) {
            return -1 ;
        }
        return head.data ;
    }
}

//Q.1 push at bottom
public static void pushatBottom(Stack<Integer> s, int data){
    //Base
    if (s.isEmpty()) {
        s.push(data);           //push int at bottom
        return ;
    }
    //recurssion
    int top = s.pop();          //remove top element
    pushatBottom(s, data);
    s.push(top);                //backtrack
}

public static void reverseStack(Stack<Integer> s){
    if (s.isEmpty()) {
        return ;
    }

    int top = s.pop();
    reverseStack(s);
    pushatBottom(s, top);
}

public static String reverseStr(String str){
    Stack<Character> sc = new Stack<>();
    int idx = 0;
    while (idx < str.length()) {
        sc.push(str.charAt(idx));
        idx++ ;
    }

    StringBuilder sb = new StringBuilder("") ;
    while (!sc.isEmpty()) {
        char curr = sc.pop();
        sb.append(curr);
    }

    return sb.toString();
}

//REMEMBER - also removes int after printing 
public static void printStack(Stack<Integer> s){
    while (!s.isEmpty()) {
    System.out.println(s.peek());
    s.pop() ;
    }
}

public static void stockSpan(int[] stock, int[] span){

Stack<Integer> s = new Stack<>();
span[0] =  1 ;
s.push(0);

for (int i = 1; i < stock.length; i++) {
    int currPrice = stock[i];
    while (!s.isEmpty() && currPrice > stock[s.peek()]) {
        s.pop();
    }

    if (s.isEmpty()) {
        span[i] = i + 1 ;
    }else{
        int prevHigh = s.peek();
        span[i] = i - prevHigh ;
    }
    
    s.push(i);

  }
}

public static int[] nextGreater(int[] arr){

int[] result = new int[arr.length];
Stack<Integer> s = new Stack<>() ;
for (int i = arr.length  - 1; i >= 0; i--) {
    int curr = arr[i];
    while (!s.isEmpty() && arr[s.peek()] <= curr ) {
        s.pop();
    }
    if (s.isEmpty()) {
        result[i] = -1 ;
    }else{
        result[i] = arr[s.peek()] ;
    }
    s.push(i);
}
return result ;
}

public static boolean validParantheses(String str){
    Stack<Character> s = new Stack<>() ;
   
    for (int i = 0; i < str.length(); i++) {
    char ch = str.charAt(i);
    if ((ch == '(') || (ch == '{') || (ch == '[')) {
        s.push(ch) ;
        
    }else{
            //closing
            if (s.isEmpty()) {
                return false ;
            }
            if ((s.peek() == '(' && ch == ')') 
            || (s.peek() == '{' && ch == '}')
            || (s.peek() == '[' && ch == ']'))
             {
                s.pop();
                
            }else{
                return false ;
            }

        }
    }

    if (s.isEmpty()) {
        return true ;
    }else{
        return false ;
    }
}

public static boolean isDuplicate(String str){
    Stack<Character> s = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

        if ((ch != ')')) {
            s.push(ch);
        }else{
            // Condition - ))))) - corner case
            if (s.isEmpty()) {
                return false ;
            }

            int count = 0 ;
            while (s.peek() != '(') {
                s.pop();
                count++ ;
            }
            if (count < 1) {
                return true ;
            }
            s.pop() ;

        }
    }

    return false ;
}

public static void maxAreaHistogram(int[] arr){

int maxArea = 0 ;
int nxtsmlleft[] = new int[arr.length];
int nxtsmlright[] = new int[arr.length];
Stack<Integer> s = new Stack<>() ;

//next smaller right
for (int i = arr.length - 1; i >= 0; i--) {
    while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
    }
    if (s.isEmpty()) {
        nxtsmlright[i] = arr.length ;       //take arr.lenghth is no smaller is present
    }else{
        nxtsmlright[i] = s.peek() ;
    }
    s.push(i);
}

//next smaller left
s = new Stack<>(); //empty the stack
for (int i = 0; i < arr.length; i++) {
    while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
        s.pop();
    }
    if (s.isEmpty()) {
        nxtsmlleft[i] = -1 ;
    }else{
        nxtsmlleft[i] = s.peek() ;
    }
    s.push(i) ;
}

//Current Area : width = j - i - 1 => nsR[i] - nsL[i] - 1 => j - i - 1
for (int i = 0; i < arr.length; i++) {
    int ht = arr[i];
    int width = nxtsmlright[i] - nxtsmlleft[i] - 1 ;
    int currArea = ht * width ;
    maxArea = Math.max(currArea, maxArea);

}

System.out.println("Maximum Area in histogram is " + maxArea);

}

//-----------------------------------------------------------------------------------------------------

public static void main(String[] args) {
//stack implementation using ArrayList
        // StackArr s = new StackArr() ;
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }


//stack implementation using Linked List
        // StackLL sl = new StackLL();
        // sl.push(1);
        // sl.push(2);
        // sl.push(3);

        // while (!sl.isEmpty()) {
        //     System.out.println(sl.peek());
        //     sl.pop();
        // }
//-----------------------------------------------------------------------
//stack implementation using JAVA COLLECTION FRAMEWORK
//         Stack<Integer> s = new Stack<Integer>();
//         s.push(1);
//         s.push(2);
//         s.push(3);

// //Q1. push at bottom
//         pushatBottom(s, 4);
//         while (!s.isEmpty()) {
//             System.out.println(s.peek());
//             s.pop();
//         }


//Q.2. Reverse a string using stack
// String str = "Hello-World" ;
// System.out.println("Reverse of "+ str +" is "+reverseStr(str));


//Q.3 Reverse a Stack
    // Stack<Integer> s = new Stack<>() ;
    // s.push(1);
    // s.push(2);
    // s.push(3);
    // // 3,2,1
    // reverseStack(s);
    // printStack(s);          //REMEMBER - also removes int after printing 
    // // 1,2,3



//Q.4. Stock Span Problem
    // int stock[] = {100, 80, 60, 70, 60, 85, 100};
    // int span[] = new int[stock.length];
    // stockSpan(stock, span);

    // //print span array
    // for (int i = 0; i < span.length; i++) {
    //     System.out.print(span[i]+ " ");
    // }
    // System.out.println();

//Q.5. Next Greater Element
    // int[] arr = {6, 8, 0, 1, 3};
    // int[] result = nextGreater(arr);
    // for (int i = 0; i < result.length; i++) {
    //     System.out.print(result[i]+ " ");
    // }
    // System.out.println();


//Q.6. Valid Parantheses
    // String str = "(()[]{})";
    // System.out.println(validParantheses(str));


//Q.7. Duplicate Parantheses
    // String str = "(((a+b)-(c)))";
    // System.out.println(isDuplicate(str));

//Q.8. Max Area is Histogram 
    // int heights[] = {2, 1, 5, 6, 2, 3};
    // maxAreaHistogram(heights);









    
        
    }
}
