package my.test.app.client;

import my.test.app.client.ui.GoodbyeView;
import my.test.app.client.ui.GoodbyeViewImpl;
import my.test.app.client.ui.HelloView;
import my.test.app.client.ui.HelloViewImpl;
import my.test.app.client.ui.LoginFormView;
import my.test.app.client.ui.LoginFormViewImpl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;


public class ClientFactoryImpl implements ClientFactory
{
	private static final EventBus eventBus = new SimpleEventBus();
	@SuppressWarnings("deprecation")
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final HelloView helloView = new HelloViewImpl();
	private static final GoodbyeView goodbyeView = new GoodbyeViewImpl();
	private static final LoginFormView LOGIN_FORM_VIEW = new LoginFormViewImpl();

	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}

	@Override
	public HelloView getHelloView()
	{
		return helloView;
	}

	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}

	@Override
	public GoodbyeView getGoodbyeView()
	{
		return goodbyeView;
	}

	@Override
	public LoginFormView getLoginFormView() {
		return LOGIN_FORM_VIEW;
	}

}
