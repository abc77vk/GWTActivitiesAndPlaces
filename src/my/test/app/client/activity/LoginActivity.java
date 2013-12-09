package my.test.app.client.activity;

import my.test.app.client.ClientFactory;
import my.test.app.client.place.LoginPlace;
import my.test.app.client.ui.LoginFormView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoginActivity extends AbstractActivity implements LoginFormView.Presenter{

	private ClientFactory clientFactory;
	@SuppressWarnings("unused")
	private Place place;
	
	public LoginActivity(ClientFactory clientFactory,LoginPlace loginPlace) {
		this.clientFactory = clientFactory;
		this.place = loginPlace;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		LoginFormView loginFormView = clientFactory.getLoginFormView();
		loginFormView.setPresenter(this);
		panel.setWidget(loginFormView.asWidget());
		
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);		
	}	

}
