package my.test.app.client;

import my.test.app.client.ui.LoginFormView;
import my.test.app.client.ui.LoginFormViewImpl;
import my.test.app.client.ui.MainPage;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;


public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	@SuppressWarnings("deprecation")
	private static final PlaceController placeController = new PlaceController(eventBus);

	private static final LoginFormView LOGIN_FORM_VIEW = new LoginFormViewImpl();

	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}



	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}


	@Override
	public LoginFormView getLoginFormView() {
		return LOGIN_FORM_VIEW;
	}



	@Override
	public MainPage getMainPage() {
		// TODO Auto-generated method stub
		return null;
	}
}
