public class Customer {
  private Sring _name;
  private Vector _rentals = new Vector();
  public Customer (String name) {
  _name = name;
}
public void addRental(Rental arg){
 _rentals.addElement (arg);
}
public String getName (){
 return _name;
}

public String statement () {
  double totalAmount = 0;
  int frequentRenterPoints = 0;
   Enumeration rentals = _rentals.elements();
String result = "Rental record for " + getName() + "\n";
while (rentals.hasMoreElements() ) {
  double tatalAmount = 0 ;
  Rental each = (Rental) rentals.nextElement();
result += "\t" + each.getMovie().getTitle() + "\t" +
String.valueOf(each.getCharge()) + "\n";		
}
         //switch (each.getMovie().getPriceCode() ) {
   case Movie.REGULAR:
            thisAmount += 2;
             if (each.getDayRented() >2)
                  thisAmount += 2;
                  if (each.getDaysRented() >2)
                        thisAmount +=(each.getDaysRented() -  2) * 1.5;
                   break;
            case Movie.New_RELEASE:
                      thisAmount += each.getDayRented() * 3 ;
                    break;
            case Movie.CHILDRENS:
                   thisAmount += 1.5;
                   if (each.getDaysRented() > 3)
                          thisAmount +=(each.getDaysRented() - 3) * 1.5;
            break;
}
  frequentRenterPoints ++;
if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)&&each.getDaysRented() >1) frequentRenterPoints ++;
   result += "\t" + each.getMovie().getTitle() + "\t" + 
          String.valueOf(thisAmount) + "\n";
    totalAmount += thisAmount;
}//

  result +="Amount owed is " + String.valueOf(totalAmount) + "\n";
  result +="You earned" + String.valueOf(frequentRenterPoints)+"frequent renter points";
  return result;
}
private double getTotalCharge() {
double result = 0;
Enumeration rentals = _rentals.elements();
while (rentals.hasMoreElements()) {
Rental each = (Rental) rentals.nextElement();
result += each.getCharge();
}
return result;
}
private int getTotalFrequentRenterPoints() {
int result = 0 ;
Enumeration rentals = _rentals.elements();
while (rentals.hasMoreElements()) {
Rental each = (Rental) rentals.nextElement();
result += each.getFrequentRenterPoints();
}
return result;
}