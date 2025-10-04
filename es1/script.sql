CREATE TABLE Corso (
    corso_id SERIAL PRIMARY KEY,
    titolo VARCHAR(50) NOT NUll,
    data_ora_inizio TIMESTAMP NOT NULL,
    luogo VARCHAR(100) NOT NULL,
    disponibilita INT NOT NULL,
);

CREATE TABLE Iscrizione (
    iscrizione_id SERIAL PRIMARY KEY,
    corso_id INT,
    partecipante_nome VARCHAR(50) NOT NULL,
    partecipante_cognome VARCHAR(50) NOT NULL,
    partecipante_email VARCHAR(50) NOT NULL,
    data_ora_iscrizione TIMESTAMP NOT NULL,
    FOREIGN KEY (corso_id) REFERENCES Corso(corso_id)
);
