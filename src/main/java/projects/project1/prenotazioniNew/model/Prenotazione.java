package projects.project1.prenotazioniNew.model;

import org.joda.time.DateTime;

public class Prenotazione {

	int id;
	int idRisorsa;
	String mail;
	DateTime dataInizio;
	DateTime dataFine;
	DateTime dataConsegna;
	
	public Prenotazione(int idRisorsa, String mail, DateTime dataInizio, DateTime dataFine) {
		this.id = id;
		this.idRisorsa = idRisorsa;
		this.mail = mail;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdRisorsa() {
		return idRisorsa;
	}

	public void setIdRisorsa(int idRisorsa) {
		this.idRisorsa = idRisorsa;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public DateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(DateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public DateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(DateTime dataFine) {
		this.dataFine = dataFine;
	}

	public DateTime getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(DateTime dataConsegna) {
		this.dataConsegna = dataConsegna;
	}
	
}
