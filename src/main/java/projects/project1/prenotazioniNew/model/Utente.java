package projects.project1.prenotazioniNew.model;

public class Utente {

	private String mail;
	private String password;
	private int ruolo;
	
	public Utente(String mail, String password, int ruolo) {
		this.mail = mail;
		this.password = password;
		this.ruolo = ruolo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
