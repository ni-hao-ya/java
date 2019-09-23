class Animal{
     String name="动物";
     void shout () {
        System.out.println("动物发出叫声");
 }
}
class Dog extends Animal{
     String name="犬类";
    void shout () {
         super.shout();
    }
  void printName(){
       System.out.println("name="+super.name);
  }
}
public class Example03{
  public static void main (String [] args) {
    Dog dog = new Dog();
   dog.shout();
  dog.printName();
 }
}
    