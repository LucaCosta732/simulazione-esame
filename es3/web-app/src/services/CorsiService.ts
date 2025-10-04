import type { ICorso } from "../models/ICorsi";

const API_URL: string = "http://localhost:8080/api/";

export const CorsoService = {

  getCorsi: async (titolo : string | null) : Promise<ICorso[]> => {
    const response = await fetch(`${API_URL}courses?name=${titolo}`);
    if (!response.ok) {
      throw new Error("Errore nel recupero dei corsi");
    }
    return response.json();
  },


} 
