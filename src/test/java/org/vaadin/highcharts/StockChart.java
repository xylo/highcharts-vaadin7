package org.vaadin.highcharts;

import com.vaadin.annotations.JavaScript;

/**
 * This is the chart class we are using in the demo application.
 * It loads jquery 1.7.1 and highcharts.js located in the same package.
 * Extend you own class in order to load other JS files.
 * Make sure "highcharts-connector.js" is loaded at the end.
 *
 * @author Stefan Endrullis
 */
@JavaScript({"jquery-1.7.1.min.js", "highstock.js", "highcharts-connector.js"})
public class StockChart extends AbstractHighChart {
	private static final long serialVersionUID = -7326315426217377755L;
}
