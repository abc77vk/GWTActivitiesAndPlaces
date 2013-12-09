package my.test.app.client.ui;

import my.test.app.db.ofy.OfyService;
import my.test.app.entity.Student;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginFormViewImpl extends Composite implements LoginFormView {

	private static LoginFormUiBinder uiBinder = GWT.create(LoginFormUiBinder.class);
	private Presenter listener;
	
	@UiField Grid loginTable;
	@UiField Label loginLable;
	@UiField TextBox loginInput;
	@UiField Label passwordLable;
	@UiField PasswordTextBox passwordInput;
	@UiField Button loginButton;
	@UiField Label output;

	interface LoginFormUiBinder extends UiBinder<Widget, LoginFormViewImpl> {
	}

	public LoginFormViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public LoginFormViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}


	@UiHandler("loginButton")
	void onLoginButtonClick(ClickEvent event) {
		String login = loginInput.getText();
		String password = passwordInput.getText();
		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			output.setText("Please, fill all filds.");
			return;
		}
		Student student = OfyService.ofy().query(Student.class).filter("login", login).filter("password", password).get();
		if (student == null) {
			output.setText("No found such user.");
		}
		
	}

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
}
