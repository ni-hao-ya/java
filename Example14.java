interface Animal {
  void shout ();
 }
class Cat implements Animal{
  public void shout () {
   System.out.println("喵喵······");
 }
  void sleep () {
  System.out.println("猫睡觉······");
 } 
}
public class Example14{
   public  static  void  main (String [] args){
   Cat cat=new Cat();
   animalShout(cat);
  }
  public  static void  animalShout (Animal animal){
     Cat cat =(Cat)  animal;
    cat.shout();
     cat.sleep();
}