public class Movie {
 public static final int CHILDRENS = 2;
 public static final int REGULAR = 0;
 public static final int New_RELEASE = 1;
 private String _title;
 private int _priceCode;
private Price_price;
 public Movie(String title, int priceCode){
    _title = title;
    //_priceCode = priceCode;
   setPriceCode(priceCode);
 }
public int getPriceCode() {
return _price.getPriceCode();
}
public void setPriceCode(int arg) {
switch (arg) {
case Movie.REGULAR:
 _price=new RegularPrice();			
break;
case Movie.NEW_RELEASE:
_price=new NewReleasePrice();	
break;
case Movie.CHILDRENS:
_price=new ChildrensPrice();	
break;
default:
throw new IllegalArgumentException("Incorrect Price Code");
}
}
public String getTitle() {
return _title;
}

}
