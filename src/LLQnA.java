import java.util.* ;

public class LLQnA {
    public static class Node{
        int data;
        Node next ;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    // public static Node head;
    // public static Node tail;
    // public static int size ; 
    
    public  Node getIntersectionnode(Node head1, Node head2){
        while (head2 != null) {
            Node temp = head1;
                while (temp != null) {
                    if (temp == head2) {
                        return temp ;
                    }else{
                        temp = temp.next ;
                    }
                }
                head2 = head2.next ;
        }
        return null ;
    }
    
    public static void skipMdeleteN(int M, int N, Node head){
//1 t2-2 3 t1-4 5 6 7 8 9 -> 1 2 5 6 7 8 9
    Node temp1 = head ;
    Node temp2 = head ;
        while (head != null) {
            for (int i = 1; i < M+N; i++) {
                temp1 = temp1.next ;
            }

            for (int i = 1; i < M; i++) {
                temp2 = temp2.next ;
            }
            temp2.next = temp1.next ;
            return ;
        }
    }

    public static void swapNodes(int x, int y, Node head){
        Node temp1 = head ;
        Node temp2 = head ;
        while (head != null) {
            for (int i = 1; i < x; i++) {
                temp1 = temp1.next ;
            }
            for (int i = 1; i < y; i++) {
                temp2 = temp2.next ;
            }
            int temp = temp1.data ;
            temp1.data = temp2.data ;
            temp2.data = temp ;
            return;
        }
    }

    public static Node evenOdd(Node head){
     Node evenHead = null; Node evenTail = null ;
     Node oddHead= null; Node oddTail = null ;
     Node curr = head ;
     while (curr != null) {
        if (curr.data % 2 == 0) {
            if (evenHead == null) {
                evenHead = evenTail = curr ;
            }else{
                evenTail.next = curr ;
                evenTail = evenTail.next ;
            }
        }else{
            if (oddHead == null) {
                oddHead = oddTail = curr ;
            }else{
                oddTail.next = curr ;
                oddTail = oddTail.next ;
            }
        }

        curr = curr.next ;

     }
     oddTail.next = null ;
     evenTail.next = oddHead ;
     return evenHead ;

    }

    public static Node mergeKlists(Node[] lists){
        return partition(lists, 0, lists.length - 1);
    }
    public static Node partition(Node[] lists, int si, int ei){
        if (si == ei ) {
            return lists[si] ;
        }
        if (si < ei) {
            int mid = (si + ei)/2 ;
            Node l1 = partition(lists, si, mid);
            Node l2 = partition(lists, mid+1, ei);
            return merge(l1, l2);
        }else{

            return null ;
        }

    }

    public static Node merge(Node l1, Node l2){
        if (l1 == null) {
            return l2 ;
        }else if(l2 == null){
            return l1 ;
        }
        if (l1.data < l2.data) {
            l1.next = merge(l1.next, l2);
            return l1 ;
        }else{
            l2.next = merge(l1, l2.next);
            return l2 ;
        }

    }

    static void printList( Node head){
        Node temp = head;
        while (temp != null){
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("\n");
    }
    
    public static void main(String[] args) {
        LLQnA ll = new LLQnA();
        // Node head1, head2 ;
        // head1 = new Node(10);
        // head2 = new Node(3);

        // Node newNode = new Node(6);
        // head2.next = newNode;

        // newNode = new Node(9);
        // head2.next.next = newNode;

        // newNode = new Node(15);
        // head1.next = newNode;
        // head2.next.next.next = newNode;     //intersection point
        // newNode = new Node(30);
        // head1.next.next = newNode ;
        // head1.next.next.next = null ;

        // Node intrsctnPt = ll.getIntersectionnode( head1,  head2); 
        // if (intrsctnPt == null) {
        //     System.out.println("There is no intersection point");
        // }else{
        //     System.out.println("intersection point is "+intrsctnPt.data);
        // }


//Q.2. Delete N Nodes After M Nodes of a Linked List

// Node head;
// head = new Node(1);

// Node temp = head;
// for (int i = 2; i <= 8; i++) {
//     Node newNode = new Node(i);
//     temp.next = newNode ;
//     temp = newNode ;
// }

// printList(head);
// skipMdeleteN(2,2,head);
// printList(head);
        
//Q.3. Swapping Nodes in a Linked List

// Node head;
// head = new Node(1);

// Node temp = head;
// for (int i = 2; i <= 4; i++) {
//     Node newNode = new Node(i);
//     temp.next = newNode ;
//     temp = newNode ;
// }

// printList(head);
// swapNodes(2,4, head);
// printList(head);

//Q.4. Odd Even Linked List
// Node head;
// head = new Node(8);

// Node newNode = new Node(12);
// head.next = newNode;
// newNode = new Node(10);
// head.next.next = newNode ;
// newNode = new Node(5);
// head.next.next.next = newNode ;
// newNode = new Node(4);
// head.next.next.next.next = newNode ;
// newNode = new Node(1);
// head.next.next.next.next.next = newNode ;
// newNode = new Node(6);
// head.next.next.next.next.next.next = newNode ;

// evenOdd(head);
// printList(head);

//Q.5. Merge k Sorted Lists

int k = 3;
Node arr[] = new Node[k];
arr[0] = new Node(1);
arr[0].next = new Node(4);
arr[0].next.next = new Node(5);

arr[1] = new Node(1);
arr[1].next = new Node(3);
arr[1].next.next = new Node(4);

arr[2] = new Node(2);
arr[2].next = new Node(6);


mergeKlists(arr);
printList(arr[0]);




    }
}
