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
    axios.get(`${BASE_URL}/cpap/eventos-mes`).then((response) => {
      const data = response.data as SaleSuccess[];
      const myLabels = data.map((x) => x.data);
      const mySeries = data.map((x) => x.eventos_hora);

      setChartData({
        labels: {
          categories: myLabels
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
    plotOptions: {
      bar: {
        horizontal: true,
      },
    },

    /*
    fill: {
      colors: ['#1AB2FF']
    },
    */
    
    dataLabels: {
      style: {
        colors: ['#0634FE'], fontSize: '8px', FontFace: 'Roboto'
      },
      enabledOnSeries: [0], 
      enabled: true
    },
    
    /*
    markers: {
      colors: ['#F44336', '#E91E63', '#9C27B0']
   },
   */

    noData: {
      text: 'Carregando...'
    },

    
    background: {
      enabled: true,
    },
    
    stroke: {
      show: true,
      width: 2,
      colors: ['#FF6688'],
      //curve: 'smooth' //['smooth', 'straight', 'stepline']
    },

    grid: {
      show: true,
      xaxis: {
          lines: {
              show: true
          }
      },
/*
      row: {
        colors: ['#F44336', '#E91E63', '#9C27B0']
      },

      column: {
        colors: ['#F44336', '#E91E63', '#9C27B0']
      }
*/
  },
    // colors: ['#FF6688']
  };
  
  return (
    <Chart 
      options={{...options, xaxis: chartData.labels}}
      series={chartData.series}
      type="line"
      height="800"
      //height="500"
      //width="1280"
    />
  );
};

export default BarChart;
