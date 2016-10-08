var chartType = 'StockChart';
var options = {
	rangeSelector: {
		selected: 1
	},

	title: {
		text: 'AAPL Stock Price'
	},

	series: [{
		name: 'AAPL',
		data: [
			[1255046400000,27.21],
			[1255305600000,27.26],
			[1255392000000,27.15],
			[1255478400000,27.33],
			[1255564800000,27.22],
			[1255651200000,26.86],
			[1255910400000,27.12],
			[1255996800000,28.39],
			[1256083200000,29.27],
			[1256169600000,29.31],
			[1256256000000,29.13],
			[1256515200000,28.93],
			[1256601600000,28.20],
			[1256688000000,27.49],
			[1256774400000,28.05],
			[1256860800000,26.93]
		],
		tooltip: {
				valueDecimals: 2
		}
	}]
};