package accountSystem;
import user.*;
public class MobileAccountSystem implements AccountSystem{
	public User produce(String phonenumber) {
		return new MobileUser(phonenumber);
	}
}
