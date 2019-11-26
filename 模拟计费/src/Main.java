import user.*;
import accountSystem.*;
import utility.XMLUtility;

public class Main {
	public static void main(String args[]) {
		User user;

		String phonenumber="15636981478";
		AccountSystem accountSystem = (AccountSystem)XMLUtility.getname();
		user=accountSystem.produce(phonenumber);
		user.generateCommunicateRecord();
		user.printDetails();
	}
      
}

