import { useEffect, useState } from "react";
import type { IIscrizione } from "../models/IIscrizioni";
import { IscrizioneService } from "../services/IscrizioneService";

const IscrizioniPage = () => {
    const [iscrizioni, setIscrizioni] = useState<IIscrizione[]>([]);
    const [error, setError] = useState<string | null>(null);
    const [input, setInput] = useState<string>("");
    const [filterType, setFilterType] = useState<string>(""); 


    useEffect(() => {
        fetchIscrizioni();
    }, []);


    useEffect(() => {
        fetchIscrizioni();
    }, []);

    const handleSearch = () => {
        fetchIscrizioni();
    };


    const fetchIscrizioni = async () => {
        try {
            setError(null);

            // In base al tipo di filtro selezionato, passa i parametri corretti
            let titolo = "";
            let email = "";
            let luogo = "";

            switch (filterType) {
                case "titolo":
                    titolo = input;
                    break;
                case "email":
                    email = input;
                    break;
                case "luogo":
                    luogo = input;
                    break;
                // Se nessun filtro è selezionato, non passare parametri (carica tutto)
            }

            const data: IIscrizione[] = await IscrizioneService.getIscrizioni(
                undefined,
                titolo,
                email,
                luogo
            );
            setIscrizioni(data);
        } catch (error) {
            setError("Errore nel recupero delle iscrizioni");
            console.error("Error fetching iscrizioni:", error);
        }
    };



    return (
        <div className="bg-gray-100 p-5 rounded-lg">
            <h1 className="text-2xl font-bold mb-4 text-center">Iscrizioni</h1>
            <p className="text-gray-600 text-center">
                Qui potrai vedere tutte le tue iscrizioni
            </p>

            {/* Barra ricerca */}
            <div className="flex flex-row gap-4 mb-6 mt-3">
                <input
                    type="text"
                    placeholder="Effettua una ricerca..."
                    className="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                    value={input}
                    onChange={(e) => setInput(e.target.value)}
                />

                <select
                    className="block px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
                    value={filterType}
                    onChange={(e) => setFilterType(e.target.value)}
                >
                    <option value="">Filtra per...</option>
                    <option value="titolo">Titolo Corso</option>
                    <option value="email">Email</option>
                    <option value="luogo">Luogo</option>
                </select>

                <button
                    type="button"
                    onClick={handleSearch}
                    className="px-3 py-2 text-sm font-medium text-white bg-indigo-600 rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 "
                >
                    Cerca
                </button>
            </div>

            {/* Lista iscrizioni */}
            {error && (
                <p className="text-red-500 text-center mb-4">{error}</p>
            )}

            {iscrizioni.length > 0 ? (
                <ul className="space-y-4">
                    {iscrizioni.map((iscrizione) => (
                        <li
                            key={iscrizione.iscrizione_id}
                            className="bg-white p-4 rounded-lg shadow border"
                        >
                            <h2 className="font-semibold text-lg">
                                Corso: {iscrizione.corso ? iscrizione.corso.titolo : "N/D"}
                            </h2>
                            <p>
                                Partecipante: {iscrizione.partecipante_nome}{" "}
                                {iscrizione.partecipante_cognome}
                            </p>
                            <p>Email: {iscrizione.partecipante_email}</p>
                            <p>
                                Data iscrizione:{" "}
                                {new Date(iscrizione.data_ora_iscrizione).toLocaleString()}
                            </p>
                        </li>
                    ))}
                </ul>
            ) : (
                <p className="text-gray-500 text-center">Nessuna iscrizione trovata</p>
            )}
        </div>
    );
};

export default IscrizioniPage;
