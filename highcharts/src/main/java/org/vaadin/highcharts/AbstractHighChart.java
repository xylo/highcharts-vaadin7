package org.vaadin.highcharts;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Abstract Highcharts chart.
 *
 * Inherit a subclass from this abstract class and add a proper JavaScript annotation to it in order to load all
 * necessary JavaScript libraries that you need (e.g. jquery.js, highcharts.js, highcharts-more.js, ...).
 * Make sure your project complies with the licenses of those libraries.
 *
 * <p>Example of how to extend <code>AbstractHighChart</code>:</p>
 * <pre>
 * {@literal @}JavaScript({"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js", "http://code.highcharts.com/highcharts.js"})
 * public class HighChart extends AbstractHighChart {
 *	private static final long serialVersionUID = -7326315426217377753L;
 * }
 * </pre>
 *
 * Instead of linking the JS files via URLs you can also download the JS files to the package where your sub class of
 * <code>AbstractHighChart</code> is located.  In this case just use the file names of the JS files when loading them
 * via the JavaScript annotation.
 *
 * @author Stefan Endrullis
 */
@JavaScript({"highcharts-connector.js"})
public abstract class AbstractHighChart extends AbstractJavaScriptComponent {
	private static final long serialVersionUID = 7738496276049495017L;

	public static int currChartId = 0;

	public static int nextChartId() {
		return ++currChartId;
	}


	protected int chartId = nextChartId();

	/** Creates the chart object. */
	public AbstractHighChart() {
		setId(getDomId());
		getState().domId = getDomId();
		getState().hcjs = "";
	}

	/** Returns the stage of the chart that is shared with the web browser. */
	@Override
	protected HighChartState getState() {
		return (HighChartState) super.getState();
	}

	/**
	 * Returns the DOM ID of the chart component.
	 *
	 * @return DOM ID of the chart component
	 */
	public String getDomId() {
		return "highchart_" + chartId;
	}

	/**
	 * Sets the Highcharts JavaScript code describing the chart.
	 * Note that this code needs to bind the the JSON definition of the chart to a JS variable called <code>options</code>.
	 *
	 * <p>Example:</p>
	 * <pre>chart.setHcjs("var options = { chart: { title: 'my title' } };")</pre>
	 *
	 * @param hcjs Highcharts JavaScript code describing the chart
	 */
	public void setHcjs(String hcjs) {
		getState().hcjs = hcjs;
  }
}
