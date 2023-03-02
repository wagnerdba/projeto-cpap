import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { SaleSuccess } from "types/sale";
import { BASE_URL } from "utils/requests";

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

const BarChart = () => {
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
    axios.get(`${BASE_URL}/cpap/eventos-mes-limit`).then((response) => {
      const data = response.data as SaleSuccess[];
      const myLabels = data.map((x) => x.data);
      const mySeries = data.map((x) => x.eventos_hora);

      setChartData({
        labels: {
          categories: myLabels,
        },
        series: [
          {
            name: "Eventos/hora",
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
        columnWidth: '65',
        distributed: true,
      },
    },

   /*
    fill: {
     colors: ['#FF6D05']
    },
  */  
    dataLabels: {
      style: {
        colors: ['#FFFFFF']
      }
    },

     colors: ['#1A0FF2']
     // colors: ['#33b2df', '#546E7A', '#d4526e', '#13d8aa', '#A5978B', '#2b908f', '#f9a3a4', '#90ee7e', '#f48024', '#69d2e7'],
  };
  

  return (
    <Chart 
      options={{...options, xaxis: chartData.labels}}
      series={chartData.series}
      type="bar"
      height="400"
    />
  );
};

export default BarChart;
