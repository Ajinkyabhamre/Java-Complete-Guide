import java.util.*;

public class Oops {
public static void main(String[] args) {
    Pen p1 = new Pen(); //created a pen object called p1.
    p1.setColor("Blue");
    p1.setTip(5);
    System.out.println("color of pen is "+p1.getColor());
    p1.setColor("Red");
    System.out.println("color of pen is "+p1.getColor());

// Private Keyword Ussage -
BankAccount myAccount = new BankAccount();
myAccount.username = "AjinkyaBhamre";
myAccount.setPassword("@jju2699"); 
System.out.println(myAccount.username);

//Constructors
 //Non Parametrised Constructor
Student s1 = new Student();
s1.marks[0] = 100;
s1.marks[1] = 90;
s1.marks[2] = 80;
System.out.println(s1.marks[0]);
System.out.println(s1.marks[1]);
System.out.println(s1.marks[2]);

 //Parametrised Constructor
Student s2 = new Student("Ajinkya");
Student s3 = new Student(5);

//Copy Constructor
Student s4 = new Student(s1); //copy
s1.marks[1] = 100;
for (int i = 0; i < 3; i++) {
    System.out.println(s4.marks[i]);
}

//Inheritance
//Single-level inheritance
Fish shark = new Fish();
shark.eats();

//Multi-level Inheritance
dog milo = new dog();
milo.breath();
milo.breed = "Golden-Retriever";
System.out.println(milo.breed); 

calculator calc = new calculator();
System.out.println("sum is " + calc.sum(1, 2));
System.out.println("sum is "+ calc.sum(1.2f, 2.1f));
System.out.println("sum is "+ calc.sum(2, 3, 4));

Deer bambi = new Deer();
bambi.eats();


}
}

class BankAccount{
   public String username;
   private String password;

   public void setPassword(String pwd){
    password = pwd;
   }

}

class Pen {
   private String color;
   private int tip;

   //Get
    String getColor(){
    //this keyword referes to current object
    return this.color;  
    }
    int getTip(){
        return this.tip;
    }

    //Set
    void setColor(String newColor){
        this.color = newColor;
    }
    void setTip(int newTip){
        this.tip = newTip ;
    }
}

class Student{
    String name;
    int rollNum;
    String password;
    int marks[];

//constructor overloading - phenomenon where multiple constructors(methods)
// with same name but different params

    //Non Parametrised Constructor
    Student(){
        marks = new int[3];
        System.out.println("Constructor is initialised ! ");
    }
    //Parametrised Constructor
    Student(String myname){
        this.name = myname;
    }
    Student(int myrollNum){
        this.rollNum = myrollNum;
    }
    //Shallow Copy constructor
        // Student(Student s1){
        //     marks = new int[3];
        //     this.name = s1.name;
        //     this.rollNum = s1.rollNum;
        //     this.marks = s1.marks;     // only array reference got copied here, not the whole array
                                         // changes reflect here
        // }
    
    //Deep Copy Constructor
        Student(Student s1){
            marks = new int[3];
            this.name = s1.name;
            this.rollNum = s1.rollNum;
            for (int i = 0; i < marks.length; i++) {
                this.marks[i] = s1.marks[i];
            }
        }
 


}

//Inheritance

class Animal{
    String color;
    void eats(){
        System.out.println("Eats");
    }
    void breath(){
        System.out.println("breaths");
    }
}

//Hierarchial Inheritance
class Mammal extends Animal{
    String legs;
    void walks(){
        System.out.println("walks !");
    }
}

class bird extends Animal{
    void fly(){
        System.out.println("fly !");
    }
}

//multilevel inheritance
class dog extends Mammal{
    String breed;
}

//single-level inheritance
class Fish extends Animal{
    int fins;
    void swims(){
        System.out.println("swims !");
    } 

}

//Method Overloading - Compile time polymorphism
class calculator{
    int sum(int a, int b){
       return a + b;
    }

    float sum(float a, float b){
        return a + b;
    }
    int sum(int a, int b, int c){
        return a + b + c;
    }
}

//Method Overriding 
class Deer extends Animal{
    void eats(){
        System.out.println("eats grass !!!! ");
    }
}