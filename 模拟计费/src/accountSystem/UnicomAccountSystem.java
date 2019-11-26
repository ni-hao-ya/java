package accountSystem;
import user.*;
public class UnicomAccountSystem implements AccountSystem{
	public User produce(String phonenumber) {
		return new UnicomUser(phonenumber);
	}
}
