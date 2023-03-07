import java.util.* ;

public class BST2 {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
        this.data = data ;
        }
    }

     static class Info{
        boolean isBST ;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    
public static void preOrder(Node root){
    if (root == null) {
        return ;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
}    
    
public static int maxBST = 0 ;
public static Info largestBST(Node root){
    if (root == null) {
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    Info lefInfo = largestBST(root.left);
    Info righInfo = largestBST(root.right);
    int size = lefInfo.size + righInfo.size + 1 ;
    int min = Math.min(root.data, Math.min(lefInfo.min, righInfo.min));
    int max = Math.max(root.data, Math.max(lefInfo.max, righInfo.max));

    if (root.data <= lefInfo.max || root.data >= righInfo.min) {
        return new Info(false, size, min, max);
    }

    if (lefInfo.isBST && righInfo.isBST) {
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max); 
    }

    return new Info(false, size, min, max); 
}

public static void getInOrderSeq(Node root, ArrayList<Integer> arr){
    if (root == null) {
        return ;
    }
    getInOrderSeq(root.left, arr);
    arr.add(root.data);
    getInOrderSeq(root.right, arr);
}
public static Node createBST(ArrayList<Integer> arr, int st, int end){
    if (st > end) {
        return null ;
    }
    int mid = (st + end)/ 2 ;
    Node root = new Node(arr.get(mid));
    root.left = createBST(arr, st, mid - 1);
    root.right = createBST(arr, mid + 1, end);

    return root ;
}
public static Node mergeBST(Node root1, Node root2){
    //step 1
    ArrayList<Integer> arr1 = new ArrayList<>();
    getInOrderSeq(root1, arr1);

    //step 2
    ArrayList<Integer> arr2 = new ArrayList<>();
    getInOrderSeq(root2, arr2);

    //merge
    ArrayList<Integer> finalArr = new ArrayList<>();
    int i = 0, j = 0 ;
    while(i < arr1.size() && j < arr2.size()){
        if (arr1.get(i) < arr2.get(j)) {
            finalArr.add(arr1.get(i));
            i++;
        }else{
            finalArr.add(arr2.get(j));
            j++;
        }
    }

    while(i < arr1.size()){
        finalArr.add(arr1.get(i));
        i++;
    }

    while(j < arr2.size()){
        finalArr.add(arr2.get(j));
        j++;
    }

    //make bal BST
   return createBST(finalArr, 0, finalArr.size()-1);
}

public static Node insert(Node root, int val){
    if (root == null) {
        return new Node(val);
    }

    if (val <= root.data) {
        root.left = insert(root.left, val);
    }else{
        root.right = insert(root.right, val);
    }

    return root ;
}

static int sum = 0 ;
public static int RangeSum(Node root, int lo, int hi){
if (root == null) {
    return 0 ;
}
Queue<Node> q = new LinkedList<Node>();
q.add(root);

while (q.isEmpty() == false) {
    Node curr = q.poll();
    if (curr.data >= lo && curr.data <= hi) {
        sum += curr.data ;
    }

    if (curr.left != null && curr.left.data > lo) {
        q.add(curr.left);
    }
    if (curr.right != null && curr.right.data < hi) {
        q.add(curr.right);
    }
}
    return sum ;
}
    // public static int rangeSumBST(Node root, int low, int high) {
    //     if(root == null){
    //         return 0 ;
    //     }

    //     if(root.data < low){
    //         return rangeSumBST(root.right, low, high);
    //     }else if(root.data > high){
    //         return rangeSumBST(root.left, low, high);
    //     }
    //     int leftSide = rangeSumBST(root.left, low, high);
    //     int rightSide = rangeSumBST(root.right, low, high);
        
    //         return root.data + leftSide + rightSide ;
        
    // }


    // public static int findClosest(Node root, int key){
    //     if (root.data == key) {
    //         return root.data ;
    //     }

    //     if (root.data < key) {
    //         return findClosest(root.right, key);
    //     }
    //     if (root.data > key) {
    //         return findClosest(root.left, key);
    //     }
    //     return root.data ;
    // }
static int min_Diff, min_Diff_key ;

public static void maxDiffUtil(Node root, int k){
if (root == null) {
    return ;
}
if (root.data == k) {
    min_Diff_key = k ;
    return  ;
}

if (min_Diff > Math.abs(root.data - k)) {
    min_Diff = Math.abs(root.data - k);
    min_Diff_key = root.data ;
}

if (k < root.data) {
    maxDiffUtil(root.left, k);
}else{
    maxDiffUtil(root.right, k);
}

}
public static int maxDiff(Node root, int k){
    min_Diff = Integer.MAX_VALUE;
    min_Diff_key = -1 ;
    maxDiffUtil(root, k);

    return min_Diff_key; 
}

public static void inOrderSeq(Node root1, ArrayList<Integer> arr1){
    if (root1 == null) {
        return ;
    }
    inOrderSeq(root1.left, arr1);
    arr1.add(root1.data);
    inOrderSeq(root1.right, arr1);
}
public static void TwoSumBST(Node root1, Node root2, int sum){
ArrayList<Integer> arr1 = new ArrayList<>();
inOrderSeq(root1, arr1);

ArrayList<Integer> arr2 = new ArrayList<>();
inOrderSeq(root2, arr2);

for (int i = 0; i <= arr1.size() - 1; i++) {
    for (int j = 0; j <= arr2.size() - 1; j++) {
        if (arr1.get(i) + arr2.get(j) == sum) {
            System.out.println("( " + arr1.get(i) + ", " + arr2.get(j) + " )");
        }
    }
}


}

static int Sum = 0; 
static class Info2{
    boolean isBST;
    int min;
    int max;
    int sum;


    public Info2(boolean isBST, int min, int max, int sum){
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.sum = sum;

    }
}

public static Info2 maxUtil(Node root){
    if(root == null){
    return new Info2(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    Info2 leftInfo = maxUtil(root.left);
    Info2 rightInfo = maxUtil(root.right);
    int sum = root.data + leftInfo.sum + rightInfo.sum ;
    int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
    int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max)); 

    if(root.data < leftInfo.max || root.data > rightInfo.min){
    return new Info2(false, min, max, sum);
   }

   if(leftInfo.isBST && rightInfo.isBST){
        Sum = Math.max(Sum, sum);
       return new Info2(true, min, max, sum);
   }
   return new Info2(false, min, max, sum);
}

public static int maxSumBST(Node root) {
    
    Info2 res = maxUtil(root);
    return Sum  ;

}





    public static void main(String[] args) {
        /*
                  50
                /  \
               30    60
              / \    / \
             5   20 45   70
                         / \ 
                        65  80
*/
        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);

        // root.right = new Node(60);
        // root.right.right = new Node(70);
        // root.right.left = new Node(45);
        // root.right.right.right = new Node(80);
        // root.right.right.left = new Node(65);

            //     60
            //     / \
            //   45   70
            //        / \ 
            //       65  80
//expected BST - size = 5
 
    // Info res = largestBST(root);
    // System.out.println("largest BST size = " + maxBST);

/* 
     2
    / \
   1   4

*/
// Node root1 = new Node(2);
// root1.left = new Node(1);
// root1.right = new Node(4);

/* 
     9
    / \
   3   12

*/

// Node root2 = new Node(9);
// root2.left = new Node(3);
// root2.right = new Node(12);

/* final BST ans
     3
    /  \
   1    9
    \   / \
     2  4  12
*/

// Node res = mergeBST(root1, root2);
// preOrder(res);
// System.out.println();


// Node rangeRoot = new Node(8);
// rangeRoot.left = new Node(5);
// rangeRoot.right = new Node(11);
// rangeRoot.left.left = new Node(3);
// rangeRoot.left.right = new Node(6);
// rangeRoot.right.right = new Node(20);

// Node rangeRoot = null ;
// rangeRoot = insert(rangeRoot, 8);
// insert(rangeRoot, 5);
// insert(rangeRoot, 11);
// insert(rangeRoot, 3);
// insert(rangeRoot, 6);
// insert(rangeRoot, 20);

// int sum = RangeSum(rangeRoot, 5, 11);
// System.out.println("sum of nodes in range is "+ sum);

// Node closeRoot = null ;
// closeRoot = insert(closeRoot, 9);
// insert(closeRoot, 4);
// insert(closeRoot, 17);
// insert(closeRoot, 3);
// insert(closeRoot, 6);
// insert(closeRoot, 5);
// insert(closeRoot, 7);
// insert(closeRoot, 22);
// insert(closeRoot, 20);
// int k  = 19 ;
// System.out.println(maxDiff(closeRoot, k));


/* Two Sum BST
    5 
   /  \
  3    7
 / \  / \
2  4  6  8    


    10
   /  \
  6    15
 / \   / \
3  8  11  18

*/
 
Node root1 = null ;
root1 = insert(root1, 5);
insert(root1, 3);
insert(root1, 2);
insert(root1, 4);
insert(root1, 7);
insert(root1, 6);
insert(root1, 8);

Node root2 = null ;
root2 = insert(root2, 10);
insert(root2, 6);
insert(root2, 3);
insert(root2, 8);
insert(root2, 15);
insert(root2, 11);
insert(root2, 18);

TwoSumBST(root1, root2, 16);

/*

      5
    /  \
   9    2
  /     \
  6      3
/  \
8   7

 */

Node valRoot = new Node(5);
valRoot.left = new Node(9);
valRoot.left.left = new Node(6);
valRoot.left.left.left = new Node(8);
valRoot.left.left.right = new Node(7);
valRoot.right = new Node(2);
valRoot.right.right = new Node(3);

System.out.println(maxSumBST(valRoot));





    }
}
