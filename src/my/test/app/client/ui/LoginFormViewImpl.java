package my.test.app.client.ui;

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
		GWT.log("Button is presed!");
		GWT.log("login = " + loginInput.getText());
		GWT.log("password = " + passwordInput.getText());
	}

	public void setPresenter(Presenter listener) {
		this.listener = listener;
	}
}
