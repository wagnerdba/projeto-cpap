import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type SeriesData = {
	name: string;
	data: number[];
  };

type ChartData = {
	labels: {
	  categories: string[];
	};
	series: SeriesData[];
  };

const DonutChart = () => {

	const [chartData, setChartData] = useState<ChartData>({
		labels: {
		  categories: [],
		},
		series: [
		  {
			name: "",
			data: [],
		  },
		],
	  });

	useEffect(() => {
		axios.get(`${BASE_URL}/cpap/media-eventos-mes`)
			.then((response) => {
				const data = response.data as SaleSum[];
				const myLabels = data.map(x => x.data);
				const mySeries = data.map(x => round(x.eventos_hora, 1));

				setChartData({
					labels: {
					  categories: myLabels,
					},
					series: [
					  {
						name: "IAH médio do mês",
						data: mySeries,
					  },
					],
				  });
			});
	}, []);  
    
	
    const options = {
		legend: {
			show: false
		},

		plotOptions: {
			bar: {
			  horizontal: false,
			  columnWidth: '19%',
			  distributed: true,
			},
			
		  },

/*		  
		fill: {
			colors: ['#1ab2ff']
		  },
*/
 		  dataLabels: {
			style: {
			  colors: ['#FFFFFF']
			}
		  },

		  // colors: ['#0998B5']
		  colors: ['#ff1e05', '#ff8205', '#059c1b', '#69d2e7', '#546E7A', '#d4526e', '#13d8aa', '#A5978B', '#2b908f', '#f9a3a4', '#90ee7e', '#1ab2ff'],
		};

	return (
		<Chart
			options={{ ...options, xaxis: chartData.labels }}
			series={chartData.series}
			type="bar"
			height="350"
		/>

	);
}

export default DonutChart;