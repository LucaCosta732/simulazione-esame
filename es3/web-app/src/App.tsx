import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import HomePage from "./pages/HomePage";
import ElencoIscrizioniPage from "./pages/ElencoIscrizioniPage";
import AggiungiIscrizionePage from "./pages/AggiungiIscrizionePage";
import PageNotFound from "./pages/PageNotFound";
import Navbar from "./components/Navbar";
import IscrizioniPage from "./pages/IscrizioniPage";

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <main style={{ padding: "1rem" }}>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/iscrizione/:corsoId" element={<ElencoIscrizioniPage />} />
            <Route
              path="/aggiungi-iscrizione/:corso_id"
              element={<AggiungiIscrizionePage />}
            />
            <Route path="/iscrizioni" element={<IscrizioniPage />} />
            <Route path="*" element={<PageNotFound />} />
          </Routes>
        </main>
      </BrowserRouter>
    </>
  );
}

export default App;
