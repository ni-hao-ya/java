class Animal{
      void shout ()  {
           System.out.println("动物发出叫声");
      }
}
class Dog extends Animal {
   void  shout (){
          System.out.println("汪汪··· ···");
      }
}
public  class   Example02{
    public static void main (String[] args) {
         Dog dog=new Dog ();
         dog.shout();
    }
}