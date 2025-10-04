import type { IIscrizione, IscrizioneRequest } from "../models/IIscrizioni";

const API_URL: string = "http://localhost:8080/api/";

export const IscrizioneService = {
  getIscrizioni: async (
    codice_id?: number,
    titolo?: string,
    email?: string,
    luogo?: string
  ): Promise<IIscrizione[]> => {
    const params = new URLSearchParams();

    if (codice_id) params.append("corso_id", codice_id.toString());
    if (titolo) params.append("titolo", titolo);
    if (email) params.append("email", email);
    if (luogo) params.append("luogo", luogo);

    const response = await fetch(`${API_URL}enrollments?${params.toString()}`);
    if (!response.ok) {
      throw new Error("Errore nel recupero delle iscrizioni");
    }
    return response.json();
  },

  addIscrizione: async (iscrizione: IscrizioneRequest): Promise<IscrizioneRequest> => {
    const response = await fetch(`${API_URL}enrollments`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(iscrizione),
    });
    if (!response.ok) {
      throw new Error("Errore nella creazione dell'iscrizione");
    }
    return response.json();
  },
};
