package my.test.app.client.mvp;

import my.test.app.client.ClientFactory;
import my.test.app.client.activity.GoodbyeActivity;
import my.test.app.client.activity.HelloActivity;
import my.test.app.client.activity.LoginActivity;
import my.test.app.client.place.GoodbyePlace;
import my.test.app.client.place.HelloPlace;
import my.test.app.client.place.LoginPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Map each Place to its corresponding Activity. This would be a great use
	 * for GIN.
	 */
	@Override
	public Activity getActivity(Place place) {
		// This is begging for GIN
		if (place instanceof HelloPlace)
			return new HelloActivity((HelloPlace) place, clientFactory);
		else if (place instanceof GoodbyePlace)
			return new GoodbyeActivity((GoodbyePlace) place, clientFactory);
		else if (place instanceof LoginPlace)
			return new LoginActivity(clientFactory, (LoginPlace) place);

		return null;
	}

}
