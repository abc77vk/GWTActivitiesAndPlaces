package my.test.app.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface LoginFormView extends IsWidget{
	
	void setPresenter(Presenter listener);

	public interface Presenter
	{
		void goTo(Place place);
	}
}
