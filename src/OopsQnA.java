import java.util.*;

class Student{
    String name;
    int marks ;

}

class Vehicle{
    void print(){
        System.out.println("Base Class (Vehicle)");
    }
}
class Car extends Vehicle{
    void print(){
        System.out.println("Derived Class (Car)");
    }
}

class Book{
    int price;
    static int count;
    Book(int newPrice){
        this.price = newPrice;
        count++;
    }
}

class Test{
    static int marks;
    void set_marks(int newMarks){
        this.marks = newMarks;
    }
}

class Exam{
    static int a  = 10;
    static int b;
    static void changeB(){
        b = a * 3;
    }
}
//------------------------------------------------------------------------------------------------------
//Q1. Print the sum, difference and product of two complex numbers by creating a class named 'Complex' 
//with separate methods for each operation whose real and imaginary parts are entered by the user.

class Complex{
    int real;
    int img;

    Complex(int r , int i){
     real = r;
     img = i;
    }

public static Complex add(Complex a, Complex b){
    return new Complex(a.real + b.real, a.img + b.img);
}
public static Complex diff(Complex a, Complex b){
    return new Complex(a.real - b.real, a.img - b.img);
}
public static Complex prod(Complex a, Complex b){
    return new Complex(((a.real * b.real) - (a.img * b.img)),((a.real * b.img) + (a.img * b.real)));
}

public void printComplex(){
    if(real == 0 && img != 0){
        System.out.println(img + "i");
    }else if(img == 0 && real != 0){
        System.out.println(real);
    }else{
        System.out.println(real + "+" + img+"i");
    }
}
}










//------------------------------------------------------------------------------------------------------
public class OopsQnA {
public static void main(String[] args) {

    // Student s = new Student();
    // s.name = "Ajinkya";
    // System.out.println(s.name);

    // Vehicle obj1 = new Car();
    // obj1.print(); // Due to function overriding concept -> child/Derived method is called
    // Vehicle obj2 = new Vehicle();
    // obj2.print();

    // System.out.println("Total books are "+Book.count); //since count is a static variable -> class.variable is possible !
    // Book b1 = new Book(150);
    // Book b2 = new Book(250);
    // System.out.println("Total books are "+Book.count); //class.staticVariable

    // Test t1 = new Test();
    // t1.set_marks(50);
    // System.out.println(Test.marks);   //class.staticVariable

    // Exam e1 = new Exam();
    // e1.changeB();
    // System.out.println(Exam.a + Exam.b);

//------------------------------------------------------------------------------------------------------
//sheet Questions
//Q.1 
Complex c = new Complex(4,5);
Complex d = new Complex(9,4);
Complex e =Complex.add(c,d);
Complex f =Complex.diff(c,d);
Complex g =Complex.prod(c,d);
e.printComplex();
f.printComplex();
g.printComplex();




}    
}
