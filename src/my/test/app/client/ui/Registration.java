package my.test.app.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Label;

public class Registration extends Composite {

	private static RegistrationUiBinder uiBinder = GWT.create(RegistrationUiBinder.class);
	@UiField
	ListBox ageComboBox;
	@UiField
	TextBox inputLogin;
	@UiField
	PasswordTextBox inputPassword;
	@UiField
	TextBox inputName;
	@UiField Button okButton;
	@UiField Button noButton;
	@UiField Label output;
	

	interface RegistrationUiBinder extends UiBinder<Widget, Registration> {
	}
	
	@Override
	protected void onLoad() {
		for (int i = 15; i < 25; i++) {
			ageComboBox.addItem(String.valueOf(i));
		}
		
	}

	public Registration() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public Registration(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("noButton")
	void onNoButtonClick(ClickEvent event) {
		RootPanel.get("container").clear();
		RootPanel.get("container").add(new LoginFormViewImpl());
	}
	@UiHandler("okButton")
	void onOkButtonClick(ClickEvent event) {
		String login = inputLogin.getText();
		String password = inputPassword.getText();
		String name = inputName.getText();
		int selectedItemNumber = ageComboBox.getSelectedIndex();
		Integer age = Integer.parseInt(ageComboBox.getItemText(selectedItemNumber));
		
		my.test.app.client.service.Registration.Util.getInstance().registration(login, password, name, age, new AsyncCallback<Boolean>() {
			
			@Override
			public void onSuccess(Boolean result) {
				if (result) {
					output.setText("User created successfully.");
				} else {
					output.setText("This login is already used.");
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
		});
	}
}
