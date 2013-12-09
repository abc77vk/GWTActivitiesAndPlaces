package my.test.app.client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import my.test.app.client.mvp.AppActivityMapper;
import my.test.app.client.mvp.AppPlaceHistoryMapper;
import my.test.app.client.place.LoginPlace;
import my.test.app.entity.Student;

public class ApplicationStart extends RemoteServiceServlet {
	
	private Place defaultPlace = new LoginPlace();
	private SimplePanel appWidget = new SimplePanel();
	
	private static final long serialVersionUID = 1L;

	public void CreateAppWithUser(Student student) {
		HttpServletRequest request = this.getThreadLocalRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user", student);
		
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get("content").add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();
	}
}
