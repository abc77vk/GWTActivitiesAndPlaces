package my.test.app.client.service;

import my.test.app.entity.Student;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	public void doLogin(Student student,AsyncCallback<Void> callback);
}
