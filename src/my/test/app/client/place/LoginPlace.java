package my.test.app.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class LoginPlace extends Place {

	private static final String LOGIN_TOKEN = "login";

	public LoginPlace() {
	}

	@Prefix(value = LOGIN_TOKEN)
	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		public LoginPlace getPlace(String token) {
			return new LoginPlace();
		}

		public String getToken(LoginPlace place) {
			return "";
		}

	}

}
