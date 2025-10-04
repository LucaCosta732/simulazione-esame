import React, { useEffect, useState } from "react";
import type { IIscrizione } from "../models/IIscrizioni";
import { IscrizioneService } from "../services/IscrizioneService";
import { useParams } from "react-router-dom";

const ElencoIscrizioniPage = () => {
  const [iscrizione, setIscrizione] = useState<IIscrizione[]>([]);
  const { corsoId } = useParams<{ corsoId: string }>();
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchIscrizioni = async () => {
      try {
        setError(null);
        if (corsoId === undefined) {
          setError("Il parametro corsoId non è stato passato");
          throw new Error("Il parametro corsoId non è stato passato");
        }

        const data: IIscrizione[] = await IscrizioneService.getIscrizioni(
          parseInt(corsoId)
        );
        setIscrizione(data);
        console.log(data);
      } catch (error) {
        setError("Errore nel recupero delle iscrizioni");
        console.error("Error fetching iscrizioni:", error);
      }
    };
    fetchIscrizioni();
  }, []);



  return (
    <>
      {/* Sezione di titolo */}
      <div className="text-center mb-10">
        <h1 className="text-4xl md:text-5xl font-extrabold text-gray-900">
          Elenco Iscrizioni
        </h1>
        {iscrizione.length > 0 && (
          <p className="text-gray-600 mt-2">
            Corso: <span className="font-semibold">{iscrizione[0].corso.titolo}</span>
          </p>
        )}
      </div>

      {/* Sezione di elenco */}
      {!error && iscrizione.length > 0 && (
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {iscrizione.map((iscrizioneItem) => (
            <div
              key={iscrizioneItem.iscrizione_id}
              className="bg-white rounded-xl shadow-lg border border-gray-100 hover:shadow-xl transition-all duration-300 hover:-translate-y-1"
            >
              {/* Header con ID e Data */}
              <div className="bg-gradient-to-r from-indigo-500 to-purple-600 rounded-t-xl p-2">
                <div className="flex justify-between items-center text-white">
                  <span className="text-sm font-medium bg-white/20 px-2 py-1 rounded">
                    ID: #{iscrizioneItem.iscrizione_id}
                  </span>
                  <span className="text-xs opacity-90">
                    {iscrizioneItem.data_ora_iscrizione.toString()}
                  </span>
                </div>
              </div>

              {/* Corpo della card */}
              <div className="p-3">
                {/* Nome e Cognome */}
                <div className="mb-4">
                  <h2 className="text-xl font-bold text-gray-900">
                    {iscrizioneItem.partecipante_nome} {iscrizioneItem.partecipante_cognome}
                  </h2>
                </div>

                {/* Email */}
                <div className="mb-4">
                  <div className="flex items-center text-gray-600">
                    <svg className="w-4 h-4 mr-2" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                      <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
                    </svg>
                    <span className="text-sm break-all">{iscrizioneItem.partecipante_email}</span>
                  </div>
                </div>


              </div>
            </div>
          ))}
        </div>
      )}

      {/* Messaggio quando non ci sono iscrizioni */}
      {!error && iscrizione.length === 0 && (
        <div className="text-center py-16 bg-gray-50 rounded-2xl">
          <div className="max-w-md mx-auto">
            <svg className="w-16 h-16 text-gray-400 mx-auto mb-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={1} d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197m13.5-9a2.5 2.5 0 11-5 0 2.5 2.5 0 015 0z" />
            </svg>
            <h3 className="text-xl font-semibold text-gray-900 mb-2">Nessuna iscrizione trovata</h3>
            <p className="text-gray-600">Non ci sono ancora iscrizioni per questo corso.</p>
          </div>
        </div>
      )}

      {/* Sezione di errore */}
      {error && (
        <div className="text-center py-10">
          <div className="max-w-md mx-auto bg-red-50 border border-red-200 rounded-2xl p-6">
            <svg className="w-12 h-12 text-red-500 mx-auto mb-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 8v4m0 4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
            <p className="text-red-700 text-lg font-semibold mb-2">{error}</p>
            <p className="text-red-600 text-sm">Riprova più tardi o contatta l'assistenza.</p>
          </div>
        </div>
      )}
    </>
  );
};

export default ElencoIscrizioniPage;