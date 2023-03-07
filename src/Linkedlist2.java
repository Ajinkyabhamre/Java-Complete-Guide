import java.util.* ;

public class Linkedlist2 {

public static class Node{
    int data;
    Node next ;

    public Node(int data){  //constructor
        this.data = data ;
        this.next = null ;
    }
}
public static Node head ;
public static Node tail;
public static int size ;

//add node at Last in linked-list 
public void addLast(int data){

//create a new node
Node newNode = new Node(data);

if (head == null) {
    head = tail = newNode ;
}

tail.next = newNode ;

tail = newNode ;
}

//add node at first in linked-list  
public void addFirst(int data){ //we use method to perform operations  //O(1)
    //step.1 create a new node
    Node newNode = new Node(data);
    size++;
    
    if (head == null) {
        head = tail = newNode ;
        return ;
    }
    
    //step.2 newNode next = head
    newNode.next = head ; //link
    
    //step.3 head = newNode
    head = newNode ;
    
    } 


// //Floyd's cycle finding algorithm
// public static boolean isCycle(){
//     Node slow = head; 
//     Node fast = head;
//     while(fast != null && fast.next != null) {   // normal LL condition
//         slow = slow.next ;
//         fast = fast.next.next ;
//         if (slow == fast) {
//             return true ;       //cycle exists
//         }
//     }
    
//     return false ;          //cycle doesn't exist
// }

// public static void removeCycle(){
//     //detect cycle
//     Node slow = head ;
//     Node fast = head ;
//     boolean cycle = false ;
//     while (fast != null && fast.next != null) {
//         slow = slow.next ;
//         fast = fast.next.next ;
//         if (slow == fast) {
//             cycle = true ;
//             break ;
//         }
//     }
//     if (cycle == false) {
//         return ;
//     }

//     //find meeting point
//     slow = head ;
//     Node prev = null ;
//     while (slow != fast) {
//         prev = fast ;
//         slow = slow.next ;
//         fast = fast.next ;
//     }

//     //remove cycle -> last.next = null
//     prev.next = null ;
// }

public void print(){
    if (head == null) {
        System.out.println("Linked list is empty");
        return ;
    }
    Node temp = head;
    while (temp != null) {
        System.out.print(temp.data+"->");
        temp = temp.next ;
    }
    System.out.println("null");
}

//Merge Sort in a Linked List

private Node getMid(Node head){
    Node slow = head ;
    Node fast = head.next ;     // to get last node in first half

    while (fast != null && fast.next != null) {
        slow = slow.next ;
        fast = fast.next.next ;
    }
    return slow; //midNode

}

private Node merge(Node head1, Node head2){

Node mergedLL = new Node(-1);
Node temp = mergedLL;

while (head1 != null && head2 != null) {
   
    if (head1.data <= head2.data) {
            temp.next = head1 ;
            head1 = head1.next;
            temp = temp.next ;
    }else{
            temp.next = head2 ;
            head2 = head2.next;
            temp = temp.next ;
    }
}

while (head1 != null) {
    temp.next = head1;
    head1 = head1.next;
    temp = temp.next ;
}

while (head2 != null) {
    temp.next = head2;
    head2 = head2.next ;
    temp = temp.next ; 
}

return mergedLL.next ;      // since we took -1 node first, we've to take it's next node.

}

public Node mergeSort(Node head){

    //Base
    if (head == null || head.next == null) {
        return head ;
    }    
    // find mid node
    Node mid = getMid(head);

    // left & right merge Sort
    Node righthead = mid.next ;
    mid.next = null ;
    Node newLeft = mergeSort(head);
    Node newRight = mergeSort(righthead);

    //merge
    return merge(newLeft, newRight);

}

//Zig-Zag Linked List
public void zigZag(){
    //find mid node
    Node slow = head ;
    Node fast = head.next ;

    while (fast != null && fast.next != null) {
        slow = slow.next ;
        fast = fast.next.next ;
    }
    Node mid = slow ;

    //reverse 2nd half
    Node curr = mid.next ;
    mid.next = null ;
    Node prev = null ;
    Node next ;

    while (curr != null) {
        next = curr.next;
        curr.next = prev ;
        prev = curr ;
        curr = next ;
    }

    Node left = head;
    Node right = prev ;
    Node nextL, nextR ;

    //alternate merge
    while (left != null && right != null) {
        
        //zig-zag
        nextL = left.next ;
        left.next = right ;
        nextR = right.next ;
        right.next = nextL ;

        //update
        right = nextR ;
        left = nextL ;
    }

}


    public static void main(String[] args) {
        // Linkedlist2 ll = new Linkedlist2();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addLast(head.data);
        

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp ;
        // head.next.next = new Node(3);
        // head.next.next.next = temp ;
        // // 1->2->3->2
        // head.
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());


        // LinkedList<Integer> ll = new LinkedList<>();
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(3);
        // ll.addFirst(0);
        // System.out.println(ll);
        // ll.removeLast();
        // ll.removeFirst();
        // System.out.println(ll);

        Linkedlist2 ll2 = new Linkedlist2();
        //5-->4-->3-->2-->1
        ll2.addFirst(1);
        ll2.addFirst(2);
        ll2.addFirst(3);
        ll2.addFirst(4);
        ll2.addFirst(5);
        ll2.addFirst(6);
        ll2.print();
        ll2.head = ll2.mergeSort(ll2.head);
        ll2.print();

//zigzag

        ll2.zigZag();
        ll2.print();

    }
}
