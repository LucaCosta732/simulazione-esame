// src/components/CardCorso.tsx

import React from "react";
import type { ICorso } from "../models/ICorsi";
import { Link } from "react-router-dom";

interface CardCorsoProps {
  corso: ICorso;
}

// Funzione di utilità per formattare la data
const formattaData = (dataString: string) => {
  if (!dataString) return "Data da definire";
  const data = new Date(dataString);
  // Formato: "Giovedì, 25 Dicembre 2024, 15:30"
  return data.toLocaleString("it-IT", {
    weekday: "long",
    year: "numeric",
    month: "long",
    day: "numeric",
    hour: "2-digit",
    minute: "2-digit",
  });
};

const CardCorso: React.FC<CardCorsoProps> = ({ corso }) => {
  return (
    // Container con bordi arrotondati, ombra colorata e transizioni per l'hover
    <div className="group bg-white rounded-2xl shadow-xl overflow-hidden transform transition-all duration-500 ease-out hover:scale-105 hover:shadow-2xl hover:shadow-indigo-500/50">
      {/* Sezione Contenuto Testuale */}
      <div className="p-6">
        {/* Luogo e Data in alto */}
        <div className="flex items-center justify-between mb-3">
          <span className="text-sm text-indigo-600 font-semibold">
            📍 {corso.luogo}
          </span>
          <span className="text-xs text-gray-500 flex items-center">
            🗓️ {new Date(corso.data_ora_inizio).toLocaleDateString("it-IT")}
          </span>
        </div>

        {/* Titolo del Corso */}
        <h3 className="text-xl font-bold text-gray-900 leading-tight mb-3">
          {corso.titolo}
        </h3>

        {/* Dettagli: Data completa e Disponibilità */}
        <div className="space-y-2 mb-4">
          <p className="text-xs text-gray-600 flex items-center">
            <span className="mr-2">⏰</span>
            {formattaData(corso.data_ora_inizio)}
          </p>

          {/* Badge di disponibilità */}
          <div className="flex items-center justify-between">
            <span className="text-xs text-gray-600">Posti disponibili:</span>
            <span
              className={`text-xs font-bold px-2 py-1 rounded-full ${
                corso.disponibilita > 10
                  ? "bg-green-100 text-green-800"
                  : corso.disponibilita > 0
                  ? "bg-yellow-100 text-yellow-800"
                  : "bg-red-100 text-red-800"
              }`}
            >
              {corso.disponibilita > 0
                ? `${corso.disponibilita} posti`
                : "Esaurito"}
            </span>
          </div>
        </div>

        {/* ID del Corso - in basso, meno prominente */}
        <p className="text-xs text-gray-400 self-end mb-4">
          ID: {corso.corso_id}
        </p>

        <div className="flex flex-row w-full gap-3">
          <Link to={`/iscrizione/${corso.corso_id}`} className="flex-1">
            <button className="w-full text-sm text-indigo-600 font-medium px-3 py-2 rounded-lg transition-colors duration-200 border border-indigo-300 hover:bg-indigo-50 hover:border-indigo-400">
              Elenco Iscrizioni
            </button>
          </Link>
          <Link
            to={`/aggiungi-iscrizione/${corso.corso_id}`}
            className="flex-1"
          >
            <button className="w-full text-sm text-white font-medium px-3 py-2 rounded-lg transition-colors duration-200 bg-green-500 hover:bg-green-600 shadow-sm">
              + Iscriviti
            </button>
          </Link>
        </div>
      </div>
    </div>
  );
};

export default CardCorso;
