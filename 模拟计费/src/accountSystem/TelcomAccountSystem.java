package accountSystem;

import user.*;

public class TelcomAccountSystem implements AccountSystem {
	public User produce(String phonenumber) {
		return new TelcomUser(phonenumber);
	}
}
