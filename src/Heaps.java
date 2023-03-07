import java.util.*;

public class Heaps {

//Comparable is an interface which gives power to a class to compare its objects.
//Override is used, because Comparable interface has this method, so child class has to use the method -> leading to function overriding 

 static class Student implements Comparable<Student>{
    String name;
    int rank;

    public Student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s2){
        return this.rank - s2.rank ;
    }
 }

static class Heap{
    
ArrayList<Integer> arr = new ArrayList<>();

public void add(int data){ //O(logn)

    //add at last idx
    arr.add(data);

    int x = arr.size() - 1 ; //x is child index
    int par = (x - 1) / 2 ;  //par index

    while (arr.get(x) < arr.get(par)) { //O(logn)
        //swap
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par;
        par = (x-1)/2 ;
    }

}

public int peek(){
    return arr.get(0);
}

private void heapify(int i){
    int leftidx = 2*i+1; 
    int rightidx = 2*i+2;
    int minIdx = i ;

    if (leftidx < arr.size() && arr.get(minIdx) > arr.get(leftidx)) {
        minIdx = leftidx ;
    }

    if (rightidx < arr.size() && arr.get(minIdx) > arr.get(rightidx)) {
        minIdx = rightidx ;
    }

    if (minIdx != i) {
        //swap
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx);
    }
}

public int remove(){
    int data = arr.get(0);

    //step1. swap first and last
    int temp = arr.get(0);
    arr.set(0, arr.get(arr.size() - 1));
    arr.set(arr.size() - 1, temp);

    //step2. delete last
    arr.remove(arr.size() - 1);

    //step3. heapify
    heapify(0);

    return data ;
}

public boolean isEmpty(){
    return arr.size() == 0 ;
}
}

public static void heapSort(int arr[]){

    //step1. create maxheap 
    int n = arr.length;
    for (int i = n/2; i >= 0; i--) {
        maxheapify(arr, i, n);
    }

    //step2. push the largest element at end 
    for (int i = n-1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        maxheapify(arr, 0, i);
    }
  }

public static void maxheapify(int arr[], int i, int size){
    int leftidx = 2*i + 1; 
    int rightidx = 2*i + 2;
    int maxidx = i ;

    if (leftidx < size && arr[leftidx] > arr[maxidx]) {
        maxidx = leftidx;
    }

    if (rightidx < size && arr[rightidx] > arr[maxidx]) {
        maxidx = rightidx;
    }

    if (maxidx != i) {
        //swap
        int temp = arr[i];
        arr[i] = arr[maxidx] ;
        arr[maxidx] = temp;

        maxheapify(arr, maxidx, size);
    }
    }

static class Point implements Comparable<Point>{
    int x;
    int y; 
    int distSq;
    int idx;

    public Point(int x, int y, int distSq, int idx){
        this.x = x ;
        this.y = y; 
        this.distSq = distSq;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point P2){
       return  this.distSq - P2.distSq ;  //ascending order
    }

}





    public static void main(String[] args) {
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // //PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());  // Comparator -> is an interface which gives logic to compare, reverseOrder is an function -> desc order

    // pq.add(3);  //O(logn)
    // pq.add(9);
    // pq.add(1);
    // pq.add(4);
    // pq.add(2);
    // pq.add(7);

    // while (!pq.isEmpty()) {
    //     System.out.println(pq.peek());//O(1)
    //     pq.remove();        //O(logn)
    // }



    // PriorityQueue<Student> pq = new PriorityQueue<>();
    // pq.add(new Student("A", 5));
    // pq.add(new Student("C", 3));
    // pq.add(new Student("D", 2));
    // pq.add(new Student("B", 1));
    // pq.add(new Student("E", 4));

    // while (!pq.isEmpty()) {
    //     System.out.println(pq.peek().name + "->" + pq.peek().rank); //O(1)
    //     pq.remove();                   //O(logn)
    // }



    // Heap h = new Heap();
    // h.add(3);
    // h.add(4);
    // h.add(1);
    // h.add(5);

    // while (!h.isEmpty()) {
    //     System.out.println(h.peek());
    //     h.remove();
    // }


//heapSort
    // int arr[] = {1, 2, 4, 5, 3};
    // heapSort(arr);
    // for (int i = 0; i < arr.length; i++) {
    //     System.out.print(arr[i] +" ");
    // }


//Q. Nearby Cars
//we are given N points in 2D plane which are locations of N cars 
//if we are at origin, print the nearest k cars

int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
int k = 2 ;

PriorityQueue<Point> pq = new PriorityQueue<>();
for (int i = 0; i < pts.length; i++) {
    int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
    pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
}

for (int i = 0; i < k; i++) {
    System.out.println("C"+pq.remove().idx);
}





    }
}
