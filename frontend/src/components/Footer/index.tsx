import Start from "components/StartApp/Start";

const Footer = () => {
  return (
    <footer className="footer mt-auto bg-dark">
      <div className="text-center text-light align-items-center p-3 px-md-4 mb-3 back-logo">
        <div className="container ">
          App desenvolvido por:{" "}
          <a href="https://github.com/wagnerpires" target="_blank" rel="noreferrer">{" "} Wagner Pires</a>
          <br />
          <small>
            <strong>WR - TECNOLOGIA EM SISTEMAS - (61)98162-6852</strong>
            <Start />
          </small>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
