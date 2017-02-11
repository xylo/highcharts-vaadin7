package org.vaadin.highcharts;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stefan Endrullis &lt;stefan@endrullis.de&gt;
 */
@Theme("valo")
public class DemoSelectorUI extends UI {
	private static final long serialVersionUID = 50358519355178939L;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoSelectorUI.class, widgetset = "org.vaadin.highcharts.DemoWidgetset")
	public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = 3799410497191971791L;
	}

	private IndexedContainer testClasses;

	@Override
	protected void init(VaadinRequest request) {
		loadTestClasses(this);
	}

	private void loadTestClasses(DemoSelectorUI aThis) {
		if (testClasses != null) {
			return;
		}
		try {
			testClasses = listTestClasses();
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		Table table = new Table("Test cases", testClasses);
		table.setVisibleColumns("name", "description");
		table.addGeneratedColumn("name", new Table.ColumnGenerator() {
			public Object generateCell(Table source, Object itemId,
			                           Object columnId) {
				String name = (String) source.getItem(itemId).getItemProperty(
						columnId).getValue();
				Class clazz = (Class) source.getItem(itemId).getItemProperty("clazz").getValue();
				Link link = new Link();
				link.setResource(new ExternalResource(Page.getCurrent().getLocation() + clazz.getName()));
				link.setCaption(name);
				link.setTargetName("_new");
				return link;
			}
		});
		table.addGeneratedColumn("description", new Table.ColumnGenerator() {
			public Object generateCell(Table source, Object itemId,
			                           Object columnId) {
				String description = (String) source.getItem(itemId).
						getItemProperty(columnId).getValue();
				return new Label(description);
			}
		});
		table.setSizeFull();
		table.setColumnExpandRatio("description", 1);
		VerticalLayout verticalLayout = new VerticalLayout();
		TextField filter = new TextField();
		filter.setInputPrompt("Filter list");
		filter.addTextChangeListener(new FieldEvents.TextChangeListener() {
			@Override
			public void textChange(FieldEvents.TextChangeEvent event) {
				String text = event.getText();
				testClasses.removeAllContainerFilters();
				testClasses.addContainerFilter("name", text, true, false);
			}
		});
		verticalLayout.addComponent(filter);
		filter.focus();
		verticalLayout.addComponent(table);
		verticalLayout.setSizeFull();
		verticalLayout.setExpandRatio(table, 1);
		verticalLayout.setMargin(true);
		setContent(verticalLayout);
	}

	public static IndexedContainer listTestClasses() throws IllegalAccessException, InstantiationException {
		final IndexedContainer indexedContainer = new IndexedContainer();
		indexedContainer.addContainerProperty("name", String.class, "");
		indexedContainer.addContainerProperty("description", String.class, "");
		indexedContainer.addContainerProperty("clazz", Class.class, null);

		List<Class<? extends UI>> classes = Arrays.asList(
				HighChartDemoUI.class,
				StockChartDemoUI.class
		);

		for (Class<? extends UI> aClass : classes) {
			addTest(indexedContainer, aClass.getSimpleName(), aClass);
		}

		return indexedContainer;
	}

	static void addTest(IndexedContainer indexedContainer, String simpleName,
	                    Class<? extends UI> forName) throws InstantiationException, IllegalAccessException {
		if (UI.class.isAssignableFrom(forName)) {
			UI newInstance = forName.newInstance();
			Object id = indexedContainer.addItem();
			Item item = indexedContainer.getItem(id);
			item.getItemProperty("clazz").setValue(forName);
			item.getItemProperty("name").setValue(simpleName);
			item.getItemProperty("description").setValue(newInstance.getDescription());
		}
	}

}
