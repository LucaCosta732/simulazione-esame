import { useState } from "react";
import type { IscrizioneRequest } from "../models/IIscrizioni";
import { useParams } from "react-router-dom";
import { IscrizioneService } from "../services/IscrizioneService";

const AggiungiIscrizionePage = () => {
  const { corso_id } = useParams<{ corso_id: string }>();
  const [formData, setFormData] = useState<IscrizioneRequest>({
    corso_id: corso_id ? parseInt(corso_id) : 0,
    partecipante_nome: "",
    partecipante_cognome: "",
    partecipante_email: "",
  });
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState<string | null>(null);


  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { id, value } = e.target;
    setFormData((prev) => ({
      ...prev,
      [id]: value,
    }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setSuccess(null);

    try {
      await IscrizioneService.addIscrizione(formData);

      setFormData({
        corso_id: corso_id ? parseInt(corso_id) : 0,
        partecipante_nome: "",
        partecipante_cognome: "",
        partecipante_email: "",
      });
      setSuccess("Iscrizione aggiunta con successo!"); 
    } catch (err) {
      console.error("Errore nella creazione dell'iscrizione:", err);
      setError("Errore nella creazione dell'iscrizione");
    }
  };

  return (
    <>
      <div className="shadow-lg bg-gray-100 p-5 rounded-lg">
        <h1 className="text-2xl font-bold mb-4 text-center">
          Aggiunta Iscrizione
        </h1>

        <form className="space-y-4">
          <div className="flex flex-col space-y-2">
            <label htmlFor="partecipante_nome" className="text-sm font-medium">
              Nome
            </label>
            <input
              type="text"
              required
              id="partecipante_nome"
              value={formData.partecipante_nome}
              onChange={handleChange}
              className="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
            />
          </div>

          {/* Campo Cognome */}
          <div className="flex flex-col space-y-2">
            <label
              htmlFor="partecipante_cognome"
              className="text-sm font-medium"
            >
              Cognome
            </label>
            <input
              type="text"
              required
              id="partecipante_cognome"
              value={formData.partecipante_cognome}
              onChange={handleChange}
              className="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
            />
          </div>

          {/* Campo Email */}
          <div className="flex flex-col space-y-2">
            <label htmlFor="partecipante_email" className="text-sm font-medium">
              Email
            </label>
            <input
              type="email"
              required
              id="partecipante_email"
              value={formData.partecipante_email}
              onChange={handleChange}
              className="block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm"
            />
          </div>

          <button
            type="submit"
            onClick={handleSubmit}
            disabled={
              formData.partecipante_cognome === "" ||
              formData.partecipante_nome === "" ||
              formData.partecipante_email === ""
            }
            className="w-full px-3 py-2 text-sm font-medium text-white bg-indigo-600 rounded-md shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 disabled:bg-gray-400 disabled:cursor-not-allowed"
          >
            Aggiungi Iscrizione
          </button>
        </form>

        {error && (
          <div className="text-center py-10">
            <p className="text-red-500 text-lg font-semibold">{error}</p>
          </div>
        )}

        {success && (
          <div className="text-center py-10">
            <p className="text-green-500 text-lg font-semibold">{success}</p>
          </div>
        )}

      </div>
    </>
  );
};

export default AggiungiIscrizionePage;
