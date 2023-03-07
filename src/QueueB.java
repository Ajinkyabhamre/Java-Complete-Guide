import java.util.* ;

public class QueueB {

    static class QueueArr{
        static int arr[] ;
        static int size ;
        static int rear ;

        QueueArr(int n){
            arr = new int[n];
            size = n ;
            rear = -1 ;
        }

        public boolean isEmpty(){
         return rear == -1 ;
        }

        public void add(int data){     //TC = O(1)
            if (rear == size - 1) {
                System.out.println("Queue is full !");
            }
            rear = rear + 1 ;
            arr[rear] = data ;
        }

        public int remove(){        //TC = O(n)
            if (isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1 ;
            return front ;
        }

        public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty !");
            return -1;
        }
        return arr[0];
        }
    }
    
    static class circularQueue{
        static int arr[] ;
        static int size ;
        static int rear ;
        static int front ;

        circularQueue(int n){
            arr = new int[n] ;
            size = n ;
            rear = -1 ;
            front = -1 ;
        }

        public  boolean isEmpty(){
            return rear == -1 && front == -1 ;
        }

        public static boolean isFull(){
          return (rear + 1)% size == front ;
        }

        public  void add(int data){
            if (isFull()) {
                System.out.println("Queue is Full !");
            }
            //to add first element
            if (front == -1) {
               front = 0 ;
            }

            rear = (rear + 1) % size ;
            arr[rear] = data ;
        }

        public  int remove(){
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1 ;
            }

            int result = arr[front] ;

            //last element delete
            if (rear == front) {
                rear = front = -1 ;
            } else{
                front = (front + 1) % size ;
            }
            return result ;
        }

        public  int peek(){
            if (isEmpty()) {
                System.out.println("empty queue !");
                return -1 ;
            }

            return arr[front] ;

        }
    }
    
    static class Node {
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next = null ;
        }
    }

    static class QueueLL{
        static Node head = null ;
        static Node tail = null ;

        public boolean isEmpty(){
            return head == null && tail == null ;
        }

        public void add(int data){
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = tail = newNode;
                return ;
            }
                tail.next = newNode ;
                tail = newNode ;
            
        }

        public int remove(){
            if (isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }
            int front = head.data ;
            if (tail == head) {
                tail = head = null ;
            }else{
                head = head.next ;
            }
            return front ;

        }

        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }
            
            return head.data ; 
        }
    }
    
    //implement queue using 2 stacks 
    static class Queue2Stack{
       static Stack<Integer> S1 = new Stack<>();
       static Stack<Integer> S2 = new Stack<>() ;

        public boolean isEmpty(){       
            return S1.isEmpty() ;
        }

        public void add(int data){      //O(2n) => O(n)
            while (!S1.isEmpty()) {     //O(n)
                S2.push(S1.pop());
            }

            S1.add(data); 

            while (!S2.isEmpty()) {     //O(n)
                S1.push(S2.pop());
            }

        }

        public  int remove(){       //O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }

            return S1.pop() ;
        }

        public  int peek(){
            if (isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }

            return S1.peek() ;
        }
    }
    
    static class Queue2Stack2{
        static Stack<Integer> S1 = new Stack<>() ;
        static Stack<Integer> S2 = new Stack<>() ;

        public boolean isEmpty(){
            return S1.isEmpty() ;
        }

        public void add(int data){
            S1.push(data);
        }

        public int remove(){
            if (S1.isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }

            while (S1.size() != 1 ) {
                S2.push(S1.pop());
            }

           int val =  S1.pop() ;

            while (!S2.isEmpty()) {
                S1.push(S2.pop()) ;
            }

            return val ;
        }

        public int peek(){
            if (S1.isEmpty()) {
                System.out.println("Queue is Empty !");
                return -1 ;
            }

            while (S1.size() != 1 ) {
                S2.push(S1.pop());
            }

            int val =  S1.peek() ;

            while (!S2.isEmpty()) {
                S1.push(S2.pop()) ;
            }

            return val ;
        }
    }
    
    //implement Stack using 2 queues
    static class Stack1queue2{
        static Queue<Integer> q1 = new LinkedList<>() ;
        static Queue<Integer> q2 = new LinkedList<>() ;

        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty() ;
        }
            
        public void push(int data){ 
            if (!q1.isEmpty()) {
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public int pop(){
        if (isEmpty()) {
            System.out.println("Stack is Empty !");
            return -1 ;
        }

            int top = -1 ;
        if (!q1.isEmpty()) {
            //case 1
            while (!q1.isEmpty()) {
                top = q1.remove() ;
                if (q1.isEmpty()) {
                    break ;
                }
                q2.add(top);
            }  
        }else{
            //case 2
            while (!q2.isEmpty()) {
                top = q2.remove() ;
                if (q2.isEmpty()) {
                    break ;
                }
                q1.add(top);
            }
        }
           return top ;
        }

        public int peek(){
            if (isEmpty()) {
                System.out.println("Stack is Empty !");
                return -1 ;
            }

            int top = -1 ;
        if (!q1.isEmpty()) {
            //case 1
            while (!q1.isEmpty()) {
                top = q1.remove() ;
              
                q2.add(top);
            }  
        }else{
            //case 2
            while (!q2.isEmpty()) {
                top = q2.remove() ;
            
                q1.add(top);
            }
        }
           return top ;
        }
        
    }
    
    static class StackQueue2{
Queue<Integer> q1 = new LinkedList<>();
Queue<Integer> q2 = new LinkedList<>() ;

public boolean isEmpty(){
    return q1.isEmpty() && q2.isEmpty() ;
}

public int pop(){
    if (isEmpty()) {
        System.out.println("Stack is Empty !");
        return -1 ;
    }
    int val = -1 ;
    if (!q1.isEmpty()) {
        val = q1.remove() ;
    }else{
        val = q2.remove() ;
    }
    return val ;
}

public void push(int data){
    if (isEmpty()) {
        q1.add(data);
        return ;
    }
    if (q1.size() >= 1) {
        q1.add(data);
        while (q1.size() != 1) {
           q2.add(q1.remove()); 
        }
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }

}
public int peek(){
    if (isEmpty()) {
        System.out.println("Stack is Empty !");
        return -1 ;
    }
    int val = -1 ;
    if (!q1.isEmpty()) {
        val = q1.peek() ;
    }else{
        val = q2.peek() ;
    }
    return val ;
}

}
    
    static class StackDeque{
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data){
            deque.addLast(data);
        }

        public int pop(){
           return deque.removeLast();
        }

        public int peek(){
            return deque.getLast() ;
        }
    }

    static class QueueDeque{
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data){
            deque.addLast(data);
        }

        public int remove(){
          return  deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst() ;
        }

    }

public static void printNonrepating(String str){
    Queue<Character> q = new LinkedList<>();
    int freq[] = new int[26];

    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        q.add(ch);
        freq[ch - 'a']++ ;

        while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
            q.remove() ;
        }

        if (q.isEmpty()) {
            System.out.print(-1 +" ");
        }else{
            System.out.print(q.peek() + " ");
        }
    }
    System.out.println();

}
   
public static void interleaveQueues(Queue<Integer> oldQ){
Queue<Integer> firstHalf = new LinkedList<>();
int size = oldQ.size(); 
for (int i = 0; i < size/2; i++) {
    firstHalf.add(oldQ.remove());
}

while (!firstHalf.isEmpty()) {
    oldQ.add(firstHalf.remove());
    oldQ.add(oldQ.remove());
}



}

public static void reverseQueue(Queue<Integer> q){

    Stack<Integer> s = new Stack<>() ;

    while (!q.isEmpty()) {
        s.push(q.remove());
    }
    while (!s.isEmpty()) {
        q.add(s.pop());
    }

}

public static int DectoBinary(int n){
    int pow = 0 ;
    int bin = 0;

    while (n > 0) {
        int rem = n % 2 ;
        bin = (int)(bin + rem * Math.pow(10, pow));
        pow++ ;
        n = n / 2 ;
    }

    return bin ;
}
public static void generateBinary(int N){
Queue<Integer> q = new LinkedList<>();

for (int i = 1; i <= N; i++) {
   int bin =  DectoBinary(i);
   q.add(bin) ;

}
while (!q.isEmpty()) {
    System.out.print(q.remove()+",");
}
System.out.println();
}


public static int minCost(int n, int arr[]){
//create a priority Queue 
PriorityQueue<Integer> pq = new PriorityQueue<>();
for (int i = 0; i < n; i++) {
    pq.add(arr[i]);
}

int res = 0 ;
while (pq.size() > 1) {
    int first = pq.poll();
    int second = pq.poll() ;
    res += first + second ;
    pq.add(res) ;
}
 return res ;   
}


public static void solve(Queue<Integer> q, int k){
    if (k == 0) {
        return ;
    }
    int temp = q.poll() ;
    solve(q, k - 1);
    q.add(temp);
}
public static Queue<Integer> reverseKelements(Queue<Integer> q, int k ){

//use call stack & recurssion
solve(q, k);

int s = q.size() - k ;
while (s-- > 0) {
    int temp = q.poll() ;
    q.add(temp) ;
}

return q ;

}

public static void main(String[] args) {

//Queue implementation using array

        // QueueArr q = new QueueArr(5);
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

//Circular-Queue implementation using array

        // circularQueue cq = new circularQueue(3);
        // cq.add(1);
        // cq.add(2);
        // cq.add(3);

        // System.out.println(cq.remove());
        // cq.add(4);
        // System.out.println(cq.remove());
        // cq.add(5);

        // while (!cq.isEmpty()) {
        //     System.out.println(cq.peek());
        //     cq.remove();
        // }


//Queue implementation using Linked List
        // QueueLL qll = new QueueLL() ;
        // qll.add(1);
        // qll.add(2);
        // qll.add(3);

        // qll.remove();
        // qll.add(4);

        // while (!qll.isEmpty()) {
        //     System.out.println(qll.peek());
        //     qll.remove() ;
        // }


//Queue implementation using JCF
//Queue is an interface which has 2 classes -> Linked Lists, ArrayDequeue

    //Queue<Integer> q = new LinkedList<>() ;
            // Queue<Integer> q = new ArrayDeque<>() ;
            // q.add(1);
            // q.add(2);
            // q.add(3);
            // q.add(4);
            

            // while (!q.isEmpty()) {
            //     System.out.println(q.peek());
            //     q.remove() ;
            // }

//Q.1. Implement Queue using 2 Stacks

    //Queue2Stack q = new Queue2Stack() ;

    //Queue2Stack2 q = new Queue2Stack2() ;

    // q.add(1);
    // q.add(2);
    // q.add(3);



    // while (!q.isEmpty()) {
    //     System.out.println(q.peek());
    //     q.remove() ;
    // }

//Q.2. Implement Stack using 2 Queues

    //Stack1queue2 s = new Stack1queue2() ;   //pop() peek() = O(n)

    // StackQueue2 s = new StackQueue2() ;       //push() - O(n), pop(),peek() - O(1)
    // s.push(1);
    // s.push(2);
    // s.push(3);

    // while (!s.isEmpty()) {
    //     System.out.println(s.peek());
    //     s.pop();
    // }

//Q3. First non repeating letter 

    // String str = "aabccxb";
    // printNonrepating(str); 


//Q.4. InterLeave Queue's - 
    // Queue<Integer> q = new LinkedList<>(); 
    // for (int i = 1; i <= 10; i++) {
    //     q.add(i);
    // }

    // interleaveQueues(q);

    // while (!q.isEmpty()) {
    //     System.out.print(q.remove() + " ");
    // }
    // System.out.println();

//Q.5 Reverse a Queue
    // Queue<Integer> q = new LinkedList<>();
    // for (int i = 1; i <= 10; i++) {
    //     q.add(i);
    // }

    // reverseQueue(q);

    // while (!q.isEmpty()) {
    //     System.out.print(q.remove() + " ");
    // }
    // System.out.println();

//Deque

    // Deque<Integer> deque = new LinkedList<>() ;
    // deque.addFirst(1); // 1
    // deque.addFirst(2); //2 1 
    // System.out.println(deque);
    // deque.removeFirst();
    // System.out.println(deque);
    // deque.addLast(3);
    // deque.addLast(4);
    // deque.addLast(5);
    // deque.addLast(6);
    // System.out.println(deque);
    // deque.removeFirst();
    // deque.removeLast();
    // System.out.println(deque);
    // System.out.println("Get first element-> " + deque.getFirst());
    // System.out.println("Get last element-> " + deque.getLast());

//Implement Stack using Deque

    // StackDeque sd = new StackDeque();
    // sd.push(1);
    // sd.push(2);
    // sd.push(3);
    // System.out.println(sd.pop());
    // System.out.println(sd.pop());
    // System.out.println(sd.pop());

//Implement Queue using Deque

    // QueueDeque qd = new QueueDeque();
    // qd.add(1);
    // qd.add(2);
    // qd.add(3);
    // System.out.println("peek -> " + qd.peek());
    // System.out.println(qd.remove());
    // System.out.println(qd.remove());
    // System.out.println(qd.remove());

//Q. Generate Binary Numbers - Given a number N.The task is to generate and print all 
//binary numbers with decimal values from 1 to N.

    // int N = 5 ;
    // generateBinary(N);

//Q. Connect n ropes with minimum cost
    // int n = 4 ;
    // int arr[] = {4,3,2,6} ;
    // System.out.println(minCost(n, arr));

//Q. Job Sequencing Problem 

//Q. Reversing the first K elements of a Queue - 

    // Queue<Integer> q = new LinkedList<>() ;
    // for (int i = 1; i <= 10; i++) {
    //     q.add(i);
    // }

    // int k = 5 ;
    // q = reverseKelements(q, k) ;
    // while (!q.isEmpty()) {
    //     System.out.print(q.poll() + " ");
    // }
    // System.out.println();

//Q. Maximum of all subarrays of size k







    }
}
