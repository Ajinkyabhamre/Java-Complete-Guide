import java.util.*;

public class OopsII {
    public static void main(String[] args) {
//Abstraction & Abstract Classes

    // Horse h1 = new Horse();
    // h1.eat();
    // h1.walks();
    // System.out.println(h1.color);

    // Chicken chick = new Chicken();
    // chick.eat();
    // chick.walks();
    // chick.changeColor("White");
    // System.out.println(chick.color);

    // Mustang m1 = new Mustang(); // Animal constructor called -> Horse Constructor -> Mustang constructor
        
//Interfaces

    Queen qn = new Queen();
    qn.moves();

    Bear bhalu = new Bear();
    bhalu.eatsFlesh();
    bhalu.eatsGrass();

// Static Keyword
Student s1 = new Student();
s1.schoolName = "NMIMS";

Student s2 = new Student();
System.out.println(s2.schoolName);

Student s3 = new Student();
s3.schoolName = "VIT";
System.out.println(s3.schoolName);
System.out.println(s2.schoolName);

//Super
swift mycar = new swift();
System.out.println(mycar.color);





        
    }
}

//Abstract Classes & Abstract Methods
abstract class Animal{ //object of Animal class cannot be created, but obj of subclass can be created.
    String color;
    
    //constructor - while creating obj of abstract class -> the new obj can have properties passed by parent class
    Animal(){
        color = "brown";
        System.out.println("Animal constructor is called !");
    }

    void eat(){
        System.out.println("Eats !!!");
    }
// abstract method are not implemented in abstract class but they are implemented in their subclasses.
    abstract void walks();
 
}
class Horse extends Animal{
Horse(){
    System.out.println("Horse constructor is called !");
}

//implementation of abstract method in parent class // It is essential to add this method in subclasses of Animal
    void walks(){
        System.out.println("walks using 4 legs");
    }
// change the variable which was assigned when obj was created -> constructor of abstract assigned some variable when initialised 
    void changeColor(String newColor){
        this.color = newColor;
    }
}
class Chicken extends Animal{
//implementation of abstract method in parent class // It is essential to add this method in subclasses of Animal
    void walks(){
        System.out.println("walks on 2 legs");
    }
// change the variable which was assigned when obj was created -> constructor of abstract assigned some variable when initialised 
    void changeColor(String newColor){
        this.color = newColor;
    }
}
class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor is called !");
    }
}


//Total Abstraction - Interface
interface ChessPlayer{
    //blueprint moves -> total abstraction
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
    System.out.println("up, down, left, right, diagonal any direction");
    }
}
class King implements ChessPlayer{
    public void moves(){
    System.out.println("up, down, left, right, diagonal (only one step))");
    }
}

//Multiple Inheritance - Interface
interface Herbivores{
    void eatsGrass();
}
interface Carnivores{
    void eatsFlesh();
}
class Bear implements Carnivores,Herbivores{
    public void eatsGrass(){
        System.out.println("Eats Grass");
    }
    public void eatsFlesh(){
        System.out.println("Eats Flesh");
    }
}


//static keyword
class Student{
    String name;
    int rollNum;
    static String schoolName;
    void setName(String newName){
        this.name = newName;
    }
    String getName(){
        return this.name;
    }
//static props or func created once in memory, and all the obj of same class use them. 
    static int returnPercentage(int phy, int chem, int math){
        return (phy + chem + math)/3;
    }
}


//Super
class Car{
    String color;
    Car(){
        System.out.println("Car(parent) - vroom vroom !");
    }
}
class swift extends Car{
    swift(){
        System.out.println("swift - vroom vroom !");
        super.color = "red";
    }
}