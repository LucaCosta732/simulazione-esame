// src/pages/HomePage.tsx

import React, { useEffect, useState } from "react";
import CardCorso from "../components/CardCorso";
import type { ICorso } from "../models/ICorsi";
import { CorsoService } from "../services/CorsiService";

const HomePage = () => {
  const [corsi, setCorsi] = useState<ICorso[]>([]);
  const [titolo, setTitolo] = useState<string>("");
  const [isLoading, setIsLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  const fetchCorsi = async () => {
    setIsLoading(true);
    setError(null);
    try {
      const data: ICorso[] = await CorsoService.getCorsi(titolo);
      setCorsi(data);
      console.log(data);
      setIsLoading(false);
    } catch (err) {
      setError("Impossibile caricare i corsi. Riprova più tardi.");
      console.error("Error fetching corsi:", err);
    }
  };

  useEffect(() => {
    fetchCorsi();
  }, []);

  const handleClickButtonRefresh = () => {
    fetchCorsi();
  };

  return (
    // Sfondo grigio chiaro e padding per l'intera pagina
    <div className="min-h-screen bg-gray-50 p-4 md:p-8">
      {/* Contenitore principale per centrare il contenuto */}
      <div className="max-w-7xl mx-auto">
        {/* Intestazione della pagina */}
        <header className="text-center mb-10">
          <h1 className="text-4xl md:text-5xl font-extrabold text-gray-900">
            Scopri i Nostri Corsi
          </h1>
          <p className="mt-4 text-lg text-gray-600">
            Trova il percorso perfetto per il tuo futuro
          </p>
        </header>

        {/* Sezione di ricerca */}
        <section className="mb-12">
          <div className="max-w-2xl mx-auto">
            <label htmlFor="search" className="sr-only">
              Cerca corso
            </label>
            <div className="relative">
              <div className="flex flex-row">
                <input
                  id="search"
                  type="text"
                  placeholder="Cerca per titolo..."
                  className="block w-full pl-3 pr-3 py-3 border border-gray-300 rounded-lg leading-5 bg-white placeholder-gray-500 focus:outline-none focus:placeholder-gray-400 focus:ring-2 focus:ring-indigo-500 focus:border-transparent text-gray-900 text-lg shadow-sm"
                  value={titolo}
                  onChange={(e) => setTitolo(e.target.value)}
                />

                <button
                  className="ml-3 inline-flex items-center px-4 py-2 border border-transparent text-sm leading-5 font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700 transition duration-150 ease-in-out"
                  onClick={handleClickButtonRefresh}
                >
                  <svg
                    className="-ml-1 mr-2 h-5 w-5"
                    fill="currentColor"
                    viewBox="0 0 20 20"
                  >
                    <path
                      fillRule="evenodd"
                      d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
                      clipRule="evenodd"
                    />
                  </svg>
                  Cerca
                </button>
              </div>
            </div>
          </div>
        </section>

        {/* Contenuto principale: stato di caricamento, errore o griglia di card */}
        <main>
          {isLoading && (
            <div className="text-center py-10">
              <p className="text-gray-500 text-lg">Caricamento corsi...</p>
            </div>
          )}

          {error && (
            <div className="text-center py-10">
              <p className="text-red-500 text-lg font-semibold">{error}</p>
            </div>
          )}

          {!isLoading && !error && (
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
              {corsi.map((corsoItem) => (
                <CardCorso key={corsoItem.corso_id} corso={corsoItem} />
              ))}
            </div>
          )}

          {!isLoading && !error && corsi.length === 0 && (
            <div className="text-center py-10">
              <p className="text-gray-500 text-lg">
                Nessun corso trovato per "{titolo}".
              </p>
            </div>
          )}
        </main>
      </div>
    </div>
  );
};

export default HomePage;
