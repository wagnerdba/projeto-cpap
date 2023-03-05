import Header from "components/Header";
import Footer from "components/Footer";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <>
      <Header />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4 text-center">Infográfico CPAP</h1>
          <p className="lead text-center">Analise o rendimento diário do uso do CPAP por diferentes perspectivas</p>
          <hr />
          <div className="text-center">
          <Link className="btn btn-primary btn-lg" to="/dashboard">
            Acessar painel
          </Link>
          </div>
            <div className="text-center">
            <p>
            </p>
            <p>Esta aplicação consiste em exibir um infográfico a partir de dados fornecidos por um backend Spring e frontend React (typescript).</p>
          </div>
        </div>
      </div>
      <Footer />
      </>
  );
}

export default Home;