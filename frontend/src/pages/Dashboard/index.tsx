import Header from "components/Header";
import LineChart from "components/LineChart";
import BarChartAverage from "components/BarChartAverage";
import DataTable from "components/DataTable";
import Footer from "components/Footer";
import BarChart from "components/BarChartLimit";

const Dashboard = () => {
    return (
        <>
            <Header />
            <div className="container">
                <h1 className="text-center text-primary py-3">Painel de Eventos - CPAP</h1>

                <div className="row px-3">
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Registros (IAH) - diário</h5>
                        <LineChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Média (IAH) - mensal</h5>
                        <BarChartAverage />
                        <h5 className="text-center text-secondary">Registros (IAH) - últimos 10 dias</h5>
                        <BarChart />                        
                    </div>
                </div>
                <div className="row px-3">
                    <h2 className="text-primary text-center">Tabela geral de marcações</h2>
                </div>
                <DataTable />
            </div>
            <Footer />
        </>
    );
}

export default Dashboard;