public class price{

switch (each.getMovie().getPriceCode() ) {
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
    totalAmount += thisAmount;}
