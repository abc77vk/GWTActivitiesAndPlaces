package my.test.app.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationAsync {
	void registration(String login, String password, String name, Integer age,AsyncCallback<Boolean> callback);
}
