package projects.project1.prenotazioniNew.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

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
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		StringBuffer sb = new StringBuffer();
		sb.append("\nPrenotazione n." + this.id + "\n");
		sb.append("\trisorsa prenotata: " + this.idRisorsa + "\n");
		sb.append("\tutente: " + this.mail +"\n");
		sb.append("\tdata inizio: " + formatter.print(this.dataInizio) + "\n");
		sb.append("\tdata fine: " + formatter.print(this.dataFine) + "\n");
		return sb.toString();
	}
	
}
