package org.vaadin.highcharts.demo;

import com.vaadin.annotations.JavaScript;
import org.vaadin.highcharts.AbstractHighChart;

/**
 * This is the chart class we are using in the demo application.
 * It loads jquery 1.7.1 and the latest version of highcharts from external web pages.
 * Extend you own class in order to load other JS files or to load them locally from the corresponding resource directory.
 *
 * @author Stefan Endrullis
 */
@JavaScript({"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js", "http://code.highcharts.com/highcharts.js"})
public class HighChart extends AbstractHighChart {
	private static final long serialVersionUID = -7326315426217377753L;
}
