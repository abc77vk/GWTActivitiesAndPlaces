package my.test.app.client;

import my.test.app.client.place.LoginPlace;
import my.test.app.client.ui.LoginFormViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ApplicationEntryPoint implements EntryPoint {
	
	private Place defaultPlace = new LoginPlace();
	private SimplePanel appWidget = new SimplePanel();

	@SuppressWarnings("deprecation")
	public void onModuleLoad() {
		// Create ClientFactory using deferred binding so we can replace with
		// different
		// impls in gwt.xml
//		ClientFactory clientFactory = GWT.create(ClientFactory.class);
//		EventBus eventBus = clientFactory.getEventBus();
//		PlaceController placeController = clientFactory.getPlaceController();
//
//		// Start ActivityManager for the main widget with our ActivityMapper
//		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
//		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
//		activityManager.setDisplay(appWidget);
//
//		// Start PlaceHistoryHandler with our PlaceHistoryMapper
//		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
//		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
//		historyHandler.register(placeController, eventBus, defaultPlace);
//
//		RootPanel.get("content").add(appWidget);
//		// Goes to place represented on URL or default place
//		historyHandler.handleCurrentHistory();
		RootPanel.get("container").add(new LoginFormViewImpl());
	}

}
