import NavBar from "components/NavBar";
import LineChart from "components/LineChart";
import BarChartAverage from "components/BarChartAverage";
import DataTable from "components/DataTable";
import Footer from "components/Footer";
import BarChart from "components/BarChart";

const Dashboard = () => {
    return (
        <>
            <NavBar />
            <div className="container">
                <h1 className="text-center text-primary py-3">Painel de Eventos - CPAP</h1>

                <div className="row px-3">
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Registros diários (IAH) - por dia</h5>
                        <LineChart />
                    </div>
                    <div className="col-sm-6">
                        <h5 className="text-center text-secondary">Média (IAH) - por mês</h5>
                        <BarChartAverage />
                        <h5 className="text-center text-secondary">Registros diários (IAH) - últimos 10 dias</h5>
                        <BarChart />                        
                    </div>
                    <div className="col-sm-6">

                    </div>                    
                </div>

                <div className="row px-3">
                    <h2 className="text-primary">Tabela de registro diário</h2>
                </div>
                <DataTable />
            </div>
            <Footer />
        </>
    );
}

export default Dashboard;