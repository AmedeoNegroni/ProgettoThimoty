package projects.project1.prenotazioniNew.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import projects.project1.prenotazioniNew.DAO.RisorsaDAO;
import projects.project1.prenotazioniNew.model.Risorsa;

public class GestioneRisorse {

	static RisorsaDAO<Risorsa> rd = new RisorsaDAO<>();
	
	public static void aggiungiRisorsa(Risorsa risorsa) {
		rd.insert(risorsa);
	}
	
	public static void cancellaRisorsa(int id) {
		rd.delete(id);
	}
	
	public static void aggiornaRisorsa(int id, Risorsa risorsa) {
		rd.update(id, risorsa);
	}
	
	public static Set<Integer> getListaId() {
		return rd.getKeys();
	}
	
	public static List<Risorsa> getListaRisorse() {
		return rd.getList();
	}
	
	public static Risorsa getById(int id) {
		return rd.getById(id);
	}
	
	public static void clear() {
		rd.clear();
	}
	
	public static List<Integer> trovaRisorse(String tipo, int limite) {
		List<Integer> risorseTrovate = new ArrayList<>();
		for (Risorsa r: getListaRisorse()) {
			System.out.println(r.getClass().getSimpleName());
			if (r.getClass().getSimpleName().equals(tipo) && r.getLimite() >= limite)
				risorseTrovate.add(r.getId());
		}
		return risorseTrovate;
	}
	
}
