import Header from "components/Header";
import Footer from "components/Footer";
import { Link } from "react-router-dom";
import ImgCpap from "assets/img/cpap.png";

const Home = () => {
  return (
    <>
      <Header />
      <div className="container">
        <div className="jumbotron">
          <h1 className="display-4 text-center">Infográfico CPAP</h1>
          <p className="lead text-center">
            Analise o rendimento diário do uso do CPAP por diferentes
            perspectivas
          </p>
          <hr />
          <div className="text-center">
            <Link className="btn btn-primary btn-lg" to="/dashboard">
              Acessar painel
            </Link>
          </div>
          <div className="text-center">
            <p></p>
            <p>
              <br /><br />
              <strong>CPAP </strong>é um pequeno aparelho compressor de ar
              silencioso, utilizado no tratamento da apnéia do sono do tipo
              obstrutiva. Foi inventado por um médico australiano em 1981,
              juntamente ao nome dado à máquina, que é uma abreviação de
              <strong> Continuous Positive Airway Pressure</strong>, ou seja,
              pressão positiva contínua nas vias aéreas.
            </p>
          </div><br /><br />
          <div className="container text-center">
            <img src={ImgCpap} alt="" width="336"/>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default Home;
