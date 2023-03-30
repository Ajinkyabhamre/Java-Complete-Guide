import java.util.*;


public class binaryTree1 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
        this.data = data ;
        }
    }
    
    static class binaryTree{
        static int idx = -1 ;
        public static Node buildNode(int nodes[]){
            idx++ ;
            if (nodes[idx] == -1) {
                return null ;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildNode(nodes);
            newNode.right = buildNode(nodes);

            return newNode ;
        }

        //Tree Traversal - a. PreOrder
        public static void preOrder(Node root){
        if (root == null) {
            //System.out.print("-1 ");
            return ;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
        }

        //Tree Traversal - b. InOrder
        public static void inOrder(Node root){
            if (root == null) {
                return ;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        //Tree Traversal - c. PostOrder
        public static void postOrder(Node root){
        if (root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
        }

        //Tree Traversal - d. LevelOrder
        public static void levelOrder(Node root){
            if (root == null) {
                return ;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break ;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data +" ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

public static int heightofTree(Node root){
    if (root == null) {
        return 0 ;
    }
    int leftht = heightofTree(root.left);
    int rightht = heightofTree(root.right);
    return Math.max(leftht, rightht) + 1;
}

public static int counttreeNodes(Node root){
    if (root == null) {
        return 0 ;
    }
    int lcount = counttreeNodes(root.left);
    int rcount = counttreeNodes(root.right);
    return lcount + rcount + 1 ;
}

public static int sumofNodes(Node root){
    if (root == null) {
        return 0 ;
    }
    int leftSum = sumofNodes(root.left);
    int rightSum = sumofNodes(root.right);
    return leftSum + rightSum + root.data;
}

public static int diameter2(Node root){
    if (root == null) {
        return 0 ;
    }

    int leftdia = diameter2(root.left);
    int leftht = heightofTree(root.left);
    int rightdia = diameter2(root.right);
    int rightht = heightofTree(root.right);

    int selfDiam = leftht + rightht + 1 ;

    return Math.max(selfDiam, Math.max(leftdia, rightdia));

}

static class Info{
    int diam;
    int ht; 
    Info(int diam, int ht){
        this.diam = diam ;
        this.ht = ht ;
    }
}

public static Info diameter(Node root){
    if (root == null) {
        return new Info(0,0);
    }

    Info leftInfo = diameter(root.left);
    Info rightInfo = diameter(root.right);

    int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1 );
    int height = Math.max(leftInfo.ht, rightInfo.ht) + 1 ;

    return new Info(diam, height);

}

public static boolean isIdentical(Node root, Node subRoot){
    if (root == null && subRoot == null) {
        return true ;
    }else if (root == null || subRoot == null || root.data != subRoot.data) {
        return false ;
    }

    if (!isIdentical(root.left, subRoot.left)) {
        return false ;
    }
    if (!isIdentical(root.right, subRoot.right)) {
        return false ;
    }
    return true ;
}

public static boolean issubRoot(Node root, Node subRoot){
    if (root == null) {
        return false ;
    }
    if (root.data == subRoot.data) {
        if (isIdentical(root, subRoot)) {
            return true ;
        }
    }
    return issubRoot(root.left, subRoot) || issubRoot(root.right, subRoot);
}

static class nodeInfo{
    Node node ;
    int hd ;

    nodeInfo(Node node, int hd){
        this.node = node ;
        this.hd = hd ;
    }
}
public static void topView(Node root){
 Queue<nodeInfo> q = new LinkedList<>() ;
 HashMap<Integer, Node> map = new HashMap<>(); 
 int min = 0; int max = 0 ;

 q.add(new nodeInfo(root, 0));
 q.add(null);
 
 while (!q.isEmpty()) {
   nodeInfo curr = q.remove();
   if (curr == null) {
        if (q.isEmpty()) {
            break ;
        }else{
            q.add(null);
        }
   }else{

        if (!map.containsKey(curr.hd)) { 
            map.put(curr.hd, curr.node);
        }
        if (curr.node.left != null) {
            q.add(new nodeInfo(curr.node.left, curr.hd - 1));
            min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
            q.add(new nodeInfo(curr.node.right, curr.hd + 1));
            max = Math.max(max, curr.hd + 1);
        }

   }
 }

    for (int i = min; i <= max; i++) {
        System.out.print(map.get(i).data + " ");
    }
    System.out.println();

}

public static void KLevel(Node root, int lvl, int k){
    if (root == null) {
        return ;
    }
    if (k == lvl) {
        System.out.print(root.data + " ");
        return ;
    }
    KLevel(root.left, lvl + 1, k);
    KLevel(root.right, lvl + 1, k);
}

public static boolean getPath(Node root, int n, ArrayList<Node> path){
    if (root == null) {
        return false ;
    }
    path.add(root);
    if (root.data == n) {
        return true ;
    }
    boolean foundLeft = getPath(root.left, n, path);
    boolean foundRight = getPath(root.right, n, path);

    if (foundLeft || foundRight) {
        return true ;
    }
    path.remove(path.size() - 1); 

    return false ;

}

public static Node lca(Node root, int n1, int n2){
ArrayList<Node> path1 = new ArrayList<>();
ArrayList<Node> path2 = new ArrayList<>();

getPath(root, n1, path1);
getPath(root, n2, path2);

//Last common ancestor 
int i = 0 ;
for (; i < path1.size() && i < path2.size(); i++) {
    if (path1.get(i) != path2.get(i)) {
        break ;
    }
}

//last equal node = path.get(i - 1)
Node lca = path1.get(i - 1);
return lca ;

}

public static Node lca2(Node root, int n1, int n2){
    if (root == null || root.data == n1 || root.data == n2) {
        return root ;
    }

    Node leftLca = lca2(root.left, n1, n2);
    Node rightLca = lca2(root.right, n1, n2);

    //leftLca = val & rightLca = null
    if (rightLca == null) {
        return leftLca ;
    }
    if (leftLca == null) {
        return rightLca ;
    }

    return root ;
}

public static int lcaDist(Node root, int n){
    if (root == null) {
        return -1 ;
    }

    if (root.data == n) {
        return 0 ;
    }

    int leftDist = lcaDist(root.left, n);
    int rightDist = lcaDist(root.right, n);

    if (leftDist == -1 && rightDist == -1) {
        return -1 ;
    }else if (leftDist == -1) {
        return rightDist + 1 ;
    }else{
        return leftDist + 1 ;
    }

}

public static int minDist(Node root, int n1, int n2){
   Node lca = lca2(root, n1, n2);
   int dist1 = lcaDist(lca, n1);
   int dist2 = lcaDist(lca, n2);
   
   return dist1 + dist2 ;
}

public static int kthAncestor(Node root, int n, int k){
    if (root == null ) {
        return -1 ;
    }
    if (root.data == n) {
        return 0;
    }
    int checkLeft = kthAncestor(root.left, n, k);
    int checkRight = kthAncestor(root.right, n, checkLeft);

    if (checkLeft == -1 && checkRight == -1) {
        return -1 ;
    }
    int max = Math.max(checkLeft, checkRight);
    if (max + 1 == k) {
        System.out.println(root.data);       
    }
    return max + 1 ;
}

public static int transForm(Node root){
    if (root == null) {
        return 0 ;
    }

    int leftChild = transForm(root.left);
    int rightChild = transForm(root.right);

    int data = root.data ;
    int newLeft = root.left == null ? 0 : root.left.data ;
    int newRight = root.right == null ? 0 : root.right.data ;
    root.data = newLeft + leftChild + newRight + rightChild ;
    return data ;
}
public static void preOrder(Node root){
if (root == null) {
    return ;
}
System.out.print(root.data + " ");
preOrder(root.left);
preOrder(root.right);
}

public static boolean isUnivalued(Node root){
if (root == null) {
    return true ;
}
if (root.left != null && root.data != root.left.data) {
    return false ;
}
if (root.right != null && root.data != root.right.data) {
    return false ;
}

return isUnivalued(root.left) && isUnivalued(root.right);
}

public static Node mirrorBT(Node root){
    if (root == null) {
        return null;
    }
    Node temp = root.left ;
    root.left = mirrorBT(root.right);
    root.right = mirrorBT(temp);

    return root ;

}

public static Node Deleteleafs(Node root, int k){
    if (root == null) {
        return null ;
    }
    root.left = Deleteleafs(root.left, k);
    root.right = Deleteleafs(root.right, k);
    if (root.data == k && root.left == null && root.right == null ) {
        return null ;
    }
return root ;

}
static Map<String, Integer> map ;
static ArrayList<Integer> result;
public static ArrayList<Integer> findDuplicate(Node root){
    result = new ArrayList<>();
    map = new HashMap<>();
    traverse(root);
    return result ;
}
public static  String traverse(Node root){
    if (root == null) {
        return "$" ;
    }
    String subpath = root.data + "," + traverse(root.left) + "," + traverse(root.right);
        //System.out.println(subpath);
    map.put(subpath, map.getOrDefault(subpath, 0) + 1) ;
    if (map.get(subpath) == 2) {
        result.add(root.data);
    }
    return subpath ;
}

public static void inOrder(Node root){
    if (root == null) {
        return ;
    }

    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
}



public static void main(String[] args) {
    
//Preorder Sequence -
    // int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
    // binaryTree tree = new binaryTre e();
    // Node root = tree.buildNode(nodes);
    // System.out.println(root.data);

    // tree.preOrder(root);
    // System.out.println();
    // tree.inOrder(root);
    // System.out.println();

    // tree.postOrder(root);
    // System.out.println();

    // tree.levelOrder(root);

/*Q. Calculate Height of a Tree
                 1
                /  \
               2     3
              / \   / \
             4   5  6  7

*/
Node root = new Node(1);
root.left = new Node(2);
root.right = new Node(3);
root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);

System.out.println("Height of the tree is "+ heightofTree(root));

System.out.println("Total Count of tree nodes are "+ counttreeNodes(root));

System.out.println("Total sum of all tree nodes is "+ sumofNodes(root));

System.out.println("Diameter of tree is " + diameter2(root));   // O(n^2)

System.out.println("Diameter of Binary tree is " + diameter(root).diam);  //O(n)

//Q. subTree -> check if it exists in upper tree
//   2   
//  /  \   
// 4    5  

Node subRoot = new Node(2);
subRoot.left = new Node(4);
subRoot.right = new Node(5);


System.out.println(issubRoot(root, subRoot));

topView(root);

int k = 3 ;
KLevel(root, 1, k);

System.out.println();
int n1 = 4; int n2 = 6 ;
System.out.println("common ancestor between "+n1+" & "+n2+" is "+lca(root, n1, n2).data);


System.out.println("LCA2 - common ancestor between "+n1+" & "+n2+" is "+lca(root, n1, n2).data);

System.out.println("Minimum distance between "+ n1+ " & "+ n2 + " is " + minDist(root, n1, n2));


kthAncestor(root, 5, 1);


/*
                  1
                /  \
               2     3
              / \   / \
             4   5  6  7

             expected sum tree is :

                 27
                /  \
               9    13
              / \   / \
             0   0  0  0
 */

//  transForm(root);
//  preOrder(root);

//Q.1
Node sameroot = new Node(2);
sameroot.left = new Node(2);
sameroot.right = new Node(2);
sameroot.left.left = new Node(2);
sameroot.left.right = new Node(2);
sameroot.right.left = new Node(2);
sameroot.right.right = new Node(2);

System.out.println(isUnivalued(sameroot));


// mirrorBT(root);
// preOrder(root);

Node leaf = new Node(10);
leaf.left = new Node(3);
leaf.right = new Node(10);
leaf.left.left = new Node(3);
leaf.left.right = new Node(1);
leaf.right.right = new Node(3);
leaf.right.right.left = new Node(3);
leaf.right.right.right = new Node(3);
Deleteleafs(leaf, 3);

inOrder(leaf);
System.out.println();



Node dupi = new Node(1);
dupi.left = new Node(2);
dupi.right = new Node(3);
dupi.left.left = new Node(4);
dupi.right.left = new Node(2);
dupi.right.left.left = new Node(4);
dupi.right.right = new Node(4);
preOrder(root);
System.out.println();
System.out.println(findDuplicate(dupi));


System.out.println(sumofNodes(dupi));
} 
}
