import type { ICorso } from "./ICorsi";

export interface IIscrizione{
    iscrizione_id: number,
    corso: ICorso,
    partecipante_nome: string,
    partecipante_cognome: string,
    partecipante_email: string,
    data_ora_iscrizione: Date
}


export interface IscrizioneRequest{
    corso_id: number,
    partecipante_nome: string,
    partecipante_cognome: string,
    partecipante_email: string,
}