package my.test.app.client;

import my.test.app.client.ui.LoginFormView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import my.test.app.client.ui.MainPage;


public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	LoginFormView getLoginFormView();
	public MainPage getMainPage();
}
