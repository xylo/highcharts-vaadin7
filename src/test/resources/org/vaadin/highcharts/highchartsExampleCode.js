var options = {
	title: {
		text: 'test diagram'
	},
	series: [
		{
			name: 's1',
			data: [1, 3, 2]
		},
		{
			name: 's2',
			data: [2, 1, 3]
		}
	],
	chart: {
		events: {
			click: function (event) {
				connector.onClick(event.xAxis[0].value, event.yAxis[0].value);
			}
		}
	}
};