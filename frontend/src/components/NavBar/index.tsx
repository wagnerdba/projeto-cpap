import ImgDsDark from 'assets/img/ds_dark.png';
import { Link } from 'react-router-dom';

// function NavBar() {
const NavBar = () => {
  return (
    <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 border-bottom back-logo">
      <div className="container text-center" >
        <nav className="my-2 my-md-0 mr-md-3">
          <Link to="/">
            <img src={ImgDsDark} alt="WR - Tecnologia em Sistemas" width="297" />
          </Link>
        </nav>
      </div>
    </div>
  );
}

export default NavBar;