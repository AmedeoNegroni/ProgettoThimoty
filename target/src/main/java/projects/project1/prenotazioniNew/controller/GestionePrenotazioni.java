package projects.project1.prenotazioniNew.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;

import projects.project1.prenotazioniNew.DAO.PrenotazioniDAO;
import projects.project1.prenotazioniNew.model.Prenotazione;
import projects.project1.prenotazioniNew.model.Risorsa;
import projects.project1.prenotazioniNew.model.Utente;

public class GestionePrenotazioni {

	static PrenotazioniDAO<Prenotazione> pd = new PrenotazioniDAO<>();
	
	public static boolean controllaRisorsa(int idRisorsa) {
		for (int id: GestioneRisorse.getListaId())
			if (id == idRisorsa)
				return true;
		return false;
	}
	
	public static boolean controllaUtente(String mail) {
		for (String id: GestioneUtenti.getListaMail())
			if (id == mail)
				return true;
		return false;
	}
	
	public static boolean controllaData(int idRisorsa, DateTime dataInizio, DateTime dataFine) {
		if (dataInizio.isAfter(dataFine) || dataInizio.isEqual(dataFine))
			return false;
		for (Prenotazione p: getListaPrenotazioni())
			if(p.getIdRisorsa() == idRisorsa)
				if(((dataFine.isAfter(p.getDataInizio()) || dataFine.isEqual(p.getDataInizio())) 
						&& (dataInizio.isBefore(p.getDataFine())) || dataInizio.isEqual(p.getDataFine())))
					return false;
		return true;
	}
	
	public static void aggiungiPrenotazione(int idRisorsa, String mail, DateTime dataInizio, DateTime dataFine) {
		if (controllaRisorsa(idRisorsa) && controllaUtente(mail) && controllaData(idRisorsa, dataInizio, dataFine))
			pd.insert(new Prenotazione(idRisorsa, mail, dataInizio, dataFine));
	}
	
	public static void cancellaPrenotazione(int id) {
		if (pd.compareId(id))
			pd.delete(id);
	}
	
	public static void aggiornaPrenotazione(int id, Prenotazione prenotazione) {
		if (pd.compareId(id))
			if (controllaRisorsa(prenotazione.getIdRisorsa()) && 
					controllaUtente(prenotazione.getMail()) && 
					controllaData(prenotazione.getIdRisorsa(), prenotazione.getDataInizio(), prenotazione.getDataFine()))
				pd.update(id, prenotazione);
	}
	
	public static Set<Integer> getListaId() {
		return pd.getKeys();
	}
	
	public static List<Prenotazione> getListaPrenotazioni() {
		return pd.getList();
	}
	
	public static Prenotazione getById(int id) {
		return pd.getById(id);
	}
	
	public static void clear() {
		pd.clear();
	}
	
	public static List<Risorsa> getRisorsePerLimite(String tipo, int limite) {
		List<Risorsa> risorse = GestioneRisorse.getListaRisorse();
		List<Risorsa> risorseTrovate = new ArrayList<>();
		for (int i: GestioneRisorse.trovaRisorse(tipo, limite)) {
			risorseTrovate.add(risorse.get(i));
		}
		return risorseTrovate;
	}
	
	public static List<Risorsa> getRisorsePerLimiteEData(String tipo, int limite, DateTime dataInizio, DateTime dataFine) {
		List<Risorsa> risorse = GestioneRisorse.getListaRisorse();
		List<Risorsa> risorseTrovate = new ArrayList<>();
		for (int i: GestioneRisorse.trovaRisorse(tipo, limite))
			if (controllaData(i, dataInizio, dataFine))
					risorseTrovate.add(risorse.get(i));
		return risorseTrovate;
	}
	
}
