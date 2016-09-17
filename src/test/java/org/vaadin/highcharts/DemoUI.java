package org.vaadin.highcharts;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.JavaScriptFunction;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import elemental.json.JsonArray;
import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;

import javax.servlet.annotation.WebServlet;
import java.util.Scanner;

/**
 * This is the demo application demonstrating the use of this Highcharts Vaadin wrapper.
 * It uses the nice AceEditor add-on that provides an editor with JavaScript syntax highlighting for editing the
 * chart code.
 *
 * @author Stefan Endrullis
 */
@SuppressWarnings("serial")
public class DemoUI extends UI {

	public static final String INITIAL_HCJS = new Scanner(DemoUI.class.getResourceAsStream("highchartsExampleCode.js"), "UTF-8").useDelimiter("\\A").next();

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "org.vaadin.highcharts.DemoWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final AceEditor chartCodeField = new AceEditor() {{
			setCaption("Chart Code");
			setSizeFull();
			setMode(AceMode.javascript);
			setValue(INITIAL_HCJS);
			setImmediate(true);
		}};

		final HighChart chart = new HighChart() {{
			setSizeFull();
			setHcjs(chartCodeField.getValue());

			addFunction("onClick", new JavaScriptFunction() {
				@Override
				public void call(JsonArray args) {
					Notification.show("Chart clicked: (" + args.getNumber(0) + ", " + args.getNumber(1) + ")", Notification.Type.TRAY_NOTIFICATION);

					manipulateChart(
							"chart.addSeries({\n" +
							"    name: 'pos',\n" +
							"    data: [{x: " + args.getNumber(0) + ", y: " + args.getNumber(1) + "}]\n" +
							"});"
					);
				}
			});
		}};

		chartCodeField.addTextChangeListener(new FieldEvents.TextChangeListener() {
			@Override
			public void textChange(FieldEvents.TextChangeEvent event) {
				chart.setHcjs(event.getText());
			}
		});

		HorizontalLayout horizontalLayout = new HorizontalLayout() {{
			setSizeFull();
			setMargin(true);
			setSpacing(true);
			addComponent(chartCodeField);
			setExpandRatio(chartCodeField, 1);
			addComponent(chart);
			setExpandRatio(chart, 1);
		}};

		setContent(horizontalLayout);
	}

}
