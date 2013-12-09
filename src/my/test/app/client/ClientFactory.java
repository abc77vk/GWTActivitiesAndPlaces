package my.test.app.client;

import my.test.app.client.ui.GoodbyeView;
import my.test.app.client.ui.HelloView;
import my.test.app.client.ui.LoginFormView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;


public interface ClientFactory
{
	EventBus getEventBus();
	PlaceController getPlaceController();
	HelloView getHelloView();
	GoodbyeView getGoodbyeView();
	LoginFormView getLoginFormView();
}
