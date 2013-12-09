/**
 * 
 */
package my.test.app.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author psypitiy
 *
 */
public class LeftPanel extends Composite implements HasText {

	private static LeftPanelUiBinder uiBinder = GWT.create(LeftPanelUiBinder.class);
	@UiField TextBox textBox;
	@UiField Hyperlink hyperlink;

	interface LeftPanelUiBinder extends UiBinder<Widget, LeftPanel> {
	}

	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	public LeftPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public LeftPanel(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));

		// Can access @UiField after calling createAndBindUi
	}

	public void setText(String text) {
	}

	/**
	 * Gets invoked when the default constructor is called
	 * and a string is provided in the ui.xml file.
	 */
	public String getText() {
		return null;
	}

	@UiHandler("hyperlink")
	void onHyperlinkClick(ClickEvent event) {
		textBox.setText("Login!");
	}
	
	
	@UiHandler("hyperlink_1")
	void onHyperlink_1Click(ClickEvent event) {
		textBox.setText("Password!");
	}
}
