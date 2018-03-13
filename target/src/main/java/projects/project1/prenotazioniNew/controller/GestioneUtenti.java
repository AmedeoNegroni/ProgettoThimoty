package projects.project1.prenotazioniNew.controller;

import java.util.List;
import java.util.Set;

import projects.project1.prenotazioniNew.DAO.UtenteDAO;
import projects.project1.prenotazioniNew.model.Utente;

public class GestioneUtenti {

	static UtenteDAO<Utente> ud = new UtenteDAO<>();
	
	public static void aggiungiUtente(String mail, String password, int ruolo) {
		if (mail.matches("[a-zA-Z_0-9]+@[a-zA-Z_0-9]+\\.[a-z]+"))
			ud.insert(new Utente(mail, password, ruolo));
	}
	
	public static void cancellaUtente(String mail) {
		if (ud.compareId(mail))
			ud.delete(mail);
	}
	
	public static void aggiornaUtente(String mail, Utente utente) {
		if (ud.compareId(mail) && utente.getMail() == mail)
			ud.update(mail, utente);
	}
	
	public static Set<String> getListaMail() {
		return ud.getKeys();
	}
	
	public static List<Utente> getListaUtenti() {
		return ud.getList();
	}
	
	public static Utente getByMail(String mail) {
		return ud.getById(mail);
	}
	
	public static void clear() {
		ud.clear();
	}
	
}
