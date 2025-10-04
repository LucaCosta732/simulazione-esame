import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    // Container principale con sfondo scuro e bordo inferiore semi-trasparente
    <nav className="bg-gray-900/80 backdrop-blur-md border-b border-gray-700/50  top-0 z-50">
      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div className="flex items-center justify-between h-16">
          {/* Sezione SINISTRA: Nome/Logo */}
          <div className="flex-shrink-0">
            <Link
              to="/"
              className="text-white text-2xl font-bold tracking-wide hover:text-indigo-400 transition-colors duration-300"
            >
              DevSpace
            </Link>
          </div>

          {/* Sezione DESTRA: Link di Navigazione */}
          <div className=" md:block">
            <div className="ml-10 flex items-baseline space-x-4">
              <Link
                to="/"
                className="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium transition-all duration-300"
              >
                Home
              </Link>
              <Link
                to="/corsi"
                className="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium transition-all duration-300"
              >
                Corsi
              </Link>


              <Link
                to="/iscrizioni"
                className="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium transition-all duration-300"
              >
                Visualizza Iscrizioni
              </Link>
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
