import axios from "axios";
import { useEffect, useState } from "react";
import Chart from "react-apexcharts";
import { CpapEvents } from "types/cpap";
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
      const data = response.data as CpapEvents[];
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

    grid: {
      show: true,
      borderColor: '#1AB2FF',
      xaxis: {
          lines: {
              /* borderColor: '#C0C0C0', */
              show: true
          }
      },

      row: {
        colors: ['#f0f4fa', '#ffffff', '#f0f4fa']
      },

      column: {
        colors: ['#ffffff', '#f0f4fa', '#ffffff']
      }
  },
  };
  
  return (
    <Chart 
      options={{...options, xaxis: chartData.labels, 
                /* 
                fill: {
                  colors: ['#1AB2FF']
                 },
                */
                 stroke: {
                    show: true,
                    colors:['#FF6688'], 
                    width: [3], 
                    curve: 'straight', // curve: ['smooth', 'straight', 'stepline']
                    /*dashArray: 5*/},
                 dataLabels: {
                    enabled: true,
                    style: {
                      colors: ['#0634FE'], fontSize: '8px' /* , FontFace: 'Courier' */
                    },
                    enabledOnSeries: [0],
                    // offsetX: 1, 
                    },
                }} 
      
      series={chartData.series}
      type="line"
      height="800"
      // height="500"
      // width="720"
    />
  );
};

export default BarChart;
