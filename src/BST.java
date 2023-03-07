import java.util.*;
public class BST {
    static class Node{
        int data ;
        Node left; 
        Node right;

        Node(int data){
            this.data = data ;
        }
    }

    public static Node insert(Node root, int val){
        if (root == null) {
            root = new Node(val);
            return root ;
        }

        //left subtree
        if (root.data > val) {
           root.left = insert(root.left, val);
        }else{
            //right subtree
            root.right = insert(root.right, val);
        }

        return root ;
    }

    public static void inOrder(Node root){
        if (root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){   //O(H)
        if (root == null) {
            return false ;
        }
        if (root.data == key) {
            return true ;
        }
        if (root.data > key) {

          return  search(root.left, key);

        }else{

            return search(root.right, key);

        }
    }
    
    public static Node  inorderSuccesor(Node root){
        while (root.left != null) {
            root = root.left ;
        }
        return root ;
    }

    public static Node delete(Node root, int val){
        if (root.data < val) {
          root.right = delete(root.right, val);
        }else if (root.data > val) {
            root.left = delete(root.left, val);
        }else{
            //case 1 - 
            if (root.left == null && root.right == null) {
                return null ;
            }
            //case 2 -
            if (root.left == null) {
                return root.right ;
            }else if (root.right == null) {
                return root.left ;
            }

            //case 3 - 
            Node IS = inorderSuccesor(root.right);
            root.data = IS.data ;
            root.right = delete(root.right, IS.data);
        }

        return root ;
    }

    public static void printRange(Node root, int k1, int k2){
        if (root == null) {
            return ;
        }

        if(root.data >= k1 && root.data <= k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        }else if(root.data < k1){
            printRange(root.left, k1, k2);
        }else{
            printRange(root.right, k1, k2);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.print("null");
        System.out.println();
    }
    public static void print2Leaf(Node root, ArrayList<Integer> path){
        if (root == null) {
            return ;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        print2Leaf(root.left, path);
        print2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValid(Node root, Node min, Node max){
        if(root == null){
            return true ;
        }

        //check for false condition
        if (min != null && root.data <= min.data) {
            return false ;
        }
        else if(max != null && root.data >= max.data){
            return false ;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max) ;
    }

    public static Node mirrorBST(Node root){
        if (root == null) {
            return null ;
        }

        Node leftSide = mirrorBST(root.left);
        Node rightSide = mirrorBST(root.right);

        root.left = rightSide ;
        root.right = leftSide ;

        return root ;
    }
    public static void preOrder(Node root){
        if (root == null) {
            return  ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node arrtoBst(int arr[], int st, int end){

        if (st > end) {
            return null ;
        }

        int mid = (st + end) / 2 ;
        Node root = new Node(arr[mid]);
        root.left = arrtoBst(arr, st, mid - 1);
        root.right = arrtoBst(arr, mid + 1, end);
        
        return root ;
    }
public static void inOrderSeq(Node root, ArrayList<Integer> arr){
    if (root == null) {
        return  ;
    }
    inOrderSeq(root.left, arr);
    arr.add(root.data);
    inOrderSeq(root.right, arr);

}
public static Node arrListtoBST(ArrayList<Integer> arr, int si, int end){
    if(si > end){
        return null ;
    }
    int mid = (si + end) / 2 ;
    Node root = new Node(arr.get(mid)) ;
    root.left = arrListtoBST(arr, si, mid - 1);
    root.right = arrListtoBST(arr, mid + 1, end);

    return root ;
}
    public static Node unbalToBal(Node root){
        //get the inOrder sequence first - (sorted arrayList)
        ArrayList<Integer> arr = new ArrayList<>() ;
        inOrderSeq(root ,arr) ;

        //call sorted arrList to bal BST function
        Node res = arrListtoBST(arr, 0, arr.size() - 1 );
        return res ;
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1 ,4, 6, 10, 11, 14};
        Node root = null ;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root) ;
        System.out.println();

//Search a Node
       if (search(root, 6)) {
        System.out.println("Found !");
       }else{
        System.out.println("Not Found !");
       }

//Delete a Node
    root = delete(root, 5);
    System.out.println();
    inOrder(root);

//Print range of nodes in BST
System.out.println();
printRange(root, 5, 12);
System.out.println();

ArrayList<Integer> path = new ArrayList<>() ;
print2Leaf(root, path) ;

if (isValid(root, null, null)) {
    System.out.println("Valid BST");
}else{
    System.out.println("Not Valid BST");
}



Node mroot = new Node(8);
mroot.left = new Node(5);
mroot.right = new Node(10);
mroot.left.left = new Node(3);
mroot.left.right = new Node(6);
mroot.right.right = new Node(11); 

/*
                  8
                /  \
               5    10
              / \     \
             3   6     11

*/

//mirror BST
    preOrder(mroot);
    mirrorBST(mroot);
    System.out.println();
    preOrder(mroot);
    System.out.println();

//sorted arr to BST
    int arr[] = {3, 5, 6, 8, 10, 11, 12};
    Node arrRoot  = arrtoBst(arr, 0, arr.length - 1);
    preOrder(arrRoot);
    System.out.println();


/*
                  8
                /  \
               6    10
              /      \
             5        11
            /           \
           3             12   
*/

Node UnbalRoot = new Node(8);
UnbalRoot.left = new Node(6);
UnbalRoot.right = new Node(10);
UnbalRoot.left.left = new Node(5);
UnbalRoot.left.left.left = new Node(3);
UnbalRoot.right.right = new Node(11);
UnbalRoot.right.right.right = new Node(12);

preOrder( UnbalRoot);
System.out.println();
Node balRoot = unbalToBal(UnbalRoot);
preOrder(balRoot);


    }
}
