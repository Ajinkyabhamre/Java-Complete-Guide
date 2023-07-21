import java.util.*;

public class Linkedlist {
    
public static class Node{
    int data ;
    Node next ;

    public  Node(int data){
        this.data = data;
        this.next = null; 
    }

}
public static Node head ;
public static Node tail ;
public static int size ;

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

//add node at last in linked-list  
public void addLast(int data){  //O(1)
    //step.1 create a new node
    Node newNode = new Node(data);
    size++;

    if (head == null) {
        head = tail = newNode ;
        return ;
    }

    //step.2 tail next = newNode
    tail.next = newNode ; //link

    //step.3 tail = newNode
    tail = newNode ;
}

//add node at index idx
public void add(int idx, int data){

    if (idx == 1) {
        addFirst(data);
        return ;
    }

    Node newNode = new Node(data);
    size++ ;
    Node temp = head ;
    int i = 0;

    while(i < idx - 1){
        temp = temp.next ;
        i++ ;
    }

    newNode.next = temp.next;
    temp.next = newNode ;
}

//Remove first Node
public int removeFirst(){
    if (size == 0) {                    
        System.out.println("Linked list is empty");
        return Integer.MIN_VALUE;
    
    }else if(size == 1){
        int val = head.data ;
        head = tail = null ;
        size = 0 ;
        return val ;
    }

    int val = head.data;
    head = head.next;
    size --;
    return val;
}

//Remove last Node
public int removeLast(){
    if (size == 0) {                    
        System.out.println("Linked list is empty");
        return Integer.MIN_VALUE;
    
    }else if(size == 1){
        int val = head.data ;
        head = tail = null ;
        size = 0 ;
        return val ;
    }

    //prev : i = size - 2
    Node prev = head ;
    for (int i = 0; i < size - 2; i++) {
        prev = prev.next ;
    }
    int val = prev.next.data ;  //tail data
    prev.next = null ;
    tail = prev ;
    size--;
    return val;


}

//find key using iteration
public int itrSearch(int key){    //O(n)
//linear search
Node temp = head ;
int i = 0;

while(temp != null){
if (temp.data == key) {
    return i ;
}
temp = temp.next ;
i++ ;
}

//key not found
return -1 ;
}

//Find Key using recursion
public static int helper(Node head, int key){
//base
if (head == null) {
    return -1 ;
}
//recursion
if (head.data == key) {
    return 0 ;
}
int idx = helper(head.next, key);
if (idx == -1) {
    return -1 ;
}
return idx + 1 ;  //backtrack

}
public static int recurSearch(int key){
    return helper(head, key);
}

//Reverse a linked list
public static void reverse(){       //O(n)
    Node prev = null ;
    Node curr = tail = head ;       //assign head -> tail -> curr (right to left)
    Node next ;

    while (curr != null) {
        next = curr.next ;
        curr.next = prev ;
        prev = curr ;
        curr = next ;
    }
    head = prev ;
}

//Find & Remove Nth Node from n
public void deleteNthfrmend(int n){

//size
int sz = 0;
Node temp = head ;
while (temp != null) {
    temp = temp.next ;
    sz++ ;
}

if (size == n) {
    head = head.next ; //remove First
    return ;
}

//sz - n
int i = 1;
int itoFind = sz - n ;
Node prev = head ;
while (i < itoFind) {
    prev = prev.next;
    i++;
}
prev.next = prev.next.next ;
return ;

}


public Node findmidNode(Node head){ //helper func
Node slow = head ;
Node fast = head ;
while (fast != null && fast.next != null) {
    slow = slow.next ;          //+1
    fast = fast.next.next ;     //+2
}

return slow; //slow is my midNode
}

public boolean checkpalidrome(){
    if (head == null || head.next == null) {
        return true ;
    }

    //1. find mid
    Node midNode =findmidNode(head);

    //2. reverse 2nd half
    Node prev = null ;
    Node curr = midNode;
    Node next ;
    while (curr != null) {
        next = curr.next;
        curr.next = prev ;
        prev = curr;
        curr = next;
    }

    Node right = prev ; //right half head
    Node left = head ;


    //3. check left half & right half
    while (right != null) {
        if (left.data != right.data) {
            return false;
        }
        left = left.next ;
        right = right.next ;
    }

    return true ;


}


public void print(){      //O(n)
if (head == null) {
    System.out.println("Linked List is empty ! ");
    return ;
}

    Node temp = head ;
    while(temp != null){
        System.out.print(temp.data+ "-->");
        temp = temp.next;
    }
    System.out.println("null");
}


public static void main(String[] args) {

        Linkedlist ll = new Linkedlist() ;
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.add(3, 6);
        ll.print();
        System.out.println("Size of the linked-list is "+ ll.size);

        // ll.removeFirst();
        // ll.print();
        // System.out.println("Size of the linked-list is "+ ll.size);

        //ll.removeLast();
        // ll.print();
        // System.out.println("Size of the linked-list is "+ ll.size);

       System.out.println("key is at index " + ll.itrSearch(6));
       System.out.println("key is at index " + ll.itrSearch(10));

       System.out.println("key is at index "+recurSearch(3));

    //   ll.reverse();
    //   ll.print();

      ll.print();
      ll.deleteNthfrmend(2);
      ll.print();
      
      System.out.println(ll.checkpalidrome());


      

    }
}
