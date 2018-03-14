package projects.project1.prenotazioniNew;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import projects.project1.prenotazioniNew.DAO.RisorsaDAO;
import projects.project1.prenotazioniNew.controller.GestionePrenotazioni;
import projects.project1.prenotazioniNew.controller.GestioneRisorse;
import projects.project1.prenotazioniNew.controller.GestioneUtenti;
import projects.project1.prenotazioniNew.model.Prenotazione;
import projects.project1.prenotazioniNew.model.Risorsa;
import projects.project1.prenotazioniNew.model.Utente;
import projects.project1.prenotazioniNew.model.risorse.Aula;
import projects.project1.prenotazioniNew.model.risorse.Auto;
import projects.project1.prenotazioniNew.model.risorse.PC;

public class PrenotazioniTest {

	Risorsa risorsa1 = new Auto(5);
	Risorsa risorsa2 = new Aula(250);
	Risorsa risorsa3 = new PC(4);
	Risorsa risorsa4 = new Auto(7);
	Risorsa risorsa5 = new PC(8);
	Risorsa risorsa6 = new PC(2);
	Risorsa risorsa7 = new PC(16);
	
	int numUsers;
	int numResources;
	int numPrenotations;
	
	@Before
	public void setUp() {
		GestioneUtenti.aggiungiUtente("gesu@gmail.it","333",1);
		GestioneUtenti.aggiungiUtente("giuseppe@gmail.it","444",0);
		GestioneUtenti.aggiungiUtente("maria@gmail.it","555",0);

		GestioneRisorse.aggiungiRisorsa(risorsa1);
		GestioneRisorse.aggiungiRisorsa(risorsa2);
		GestioneRisorse.aggiungiRisorsa(risorsa3);
		
		GestionePrenotazioni.aggiungiPrenotazione(1, "gesu@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
		GestionePrenotazioni.aggiungiPrenotazione(2, "giuseppe@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
		GestionePrenotazioni.aggiungiPrenotazione(3, "maria@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
	}

	@After
	public void tearDown() {
		GestioneUtenti.clear();
		GestioneRisorse.clear();
		GestionePrenotazioni.clear();
	}
	
	@Test
	public void shouldNotAddUsers() {
		
		GestioneUtenti.aggiungiUtente("gesu@gmail.it","333",1);
		
		numUsers = GestioneUtenti.getListaUtenti().size();
		Assert.assertTrue("Ho ancora tre utenti",numUsers == 3);
		
	}
	
	@Test
	public void shouldRemoveUsers() {
		
		GestioneUtenti.cancellaUtente("gesu@gmail.it");
		
		numUsers = GestioneUtenti.getListaUtenti().size();
		Assert.assertTrue("Ho eliminato un utente",numUsers == 2);
		
		GestioneUtenti.cancellaUtente("gesu@gmail.it");
		
		numUsers = GestioneUtenti.getListaUtenti().size();
		Assert.assertTrue("Non ho eliminato un utente",numUsers == 2);
		
	}
	
	@Test
	public void shoulSubsituteUsers() {
		
		GestioneUtenti.aggiornaUtente("gesu@gmail.it",new Utente("gesu@gmail.it","3678",1));
		
		Assert.assertTrue("L'utente è stato aggiornato", GestioneUtenti.getByMail("gesu@gmail.it").getPassword() == "3678");
		
	}
	
	@Test
	public void shouldAddResources() {
		
		numResources = GestioneRisorse.getListaRisorse().size();
		Assert.assertTrue("Ho tre risorse", numResources == 3);
		
	}
	
	@Test
	public void shouldDeleteResources() {
		
		GestioneRisorse.cancellaRisorsa(1);
		
		numResources = GestioneRisorse.getListaRisorse().size();
		Assert.assertTrue("Ho cancellato una risorsa", numResources == 2);
		
	}
	
	@Test
	public void shouldSubstituteResources() {
		
		GestioneRisorse.aggiornaRisorsa(1, risorsa4);
		
		Assert.assertTrue("Ho aggiornato la prima risorsa", GestioneRisorse.getById(1).equals(risorsa4));
		
	}

	@Test
	public void shouldControlPrenotationNumber() {
		
		numPrenotations = GestionePrenotazioni.getListaPrenotazioni().size();
		Assert.assertTrue("Ho tre prenotazioni", numPrenotations == 3);
		
	}
	
	@Test
	public void shouldDeletePrenotations() {
		
		GestionePrenotazioni.cancellaPrenotazione(2);
		
		numPrenotations = GestionePrenotazioni.getListaPrenotazioni().size();
		Assert.assertTrue("Ho cancellato una prenotazione", numPrenotations == 2);
		
	}
	
	@Test
	public void shouldNotAddPrenotation() {
		
		GestionePrenotazioni.aggiungiPrenotazione(4, "gesu@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
		GestionePrenotazioni.aggiungiPrenotazione(1, "gesoo@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
		GestionePrenotazioni.aggiungiPrenotazione(3, "giuseppe@gmail.it", new DateTime(2018, 1, 18, 10, 0), new DateTime(2018, 1, 19, 10, 0));
		GestionePrenotazioni.aggiungiPrenotazione(2, "giuseppe@gmail.it", new DateTime(2018, 2, 18, 10, 0), new DateTime(2018, 2, 17, 10, 0));
		
		numPrenotations = GestionePrenotazioni.getListaPrenotazioni().size();
		Assert.assertTrue("Non ho aggiunto prenotazioni", numPrenotations == 3);
		
	}
	
	@Test
	public void shouldFindResources() {
		
		GestioneUtenti.aggiungiUtente("abramo1000ac@yahoo.com","ilovegod",0);
		GestioneUtenti.aggiungiUtente("isacco970ac@gmail.com","ihatemyfather",0);
		
		GestioneRisorse.aggiungiRisorsa(risorsa5);
		GestioneRisorse.aggiungiRisorsa(risorsa6);
		GestioneRisorse.aggiungiRisorsa(risorsa7);
		
		GestionePrenotazioni.aggiungiPrenotazione(4, "abramo1000ac@yahoo.com", new DateTime(2016, 1, 12, 0, 0), new DateTime(2016, 1, 15, 0, 0));
		GestionePrenotazioni.aggiungiPrenotazione(5, "isacco970ac@gmail.com", new DateTime(2016, 1, 12, 0, 0), new DateTime(2016, 1, 15, 0, 0));
		GestionePrenotazioni.aggiungiPrenotazione(6, "abramo1000ac@yahoo.com", new DateTime(2016, 1, 12, 0, 0), new DateTime(2016, 1, 28, 0, 0));
		GestionePrenotazioni.aggiungiPrenotazione(4, "isacco970ac@gmail.com", new DateTime(2016, 1, 20, 0, 0), new DateTime(2016, 1, 28, 0, 0));
		GestionePrenotazioni.aggiungiPrenotazione(5, "abramo1000ac@yahoo.com", new DateTime(2016, 1, 15, 1, 0), new DateTime(2016, 1, 28, 0, 0));
		
		numResources = GestionePrenotazioni.getRisorsePerLimite("PC", 4).size();
		Assert.assertTrue("Ci sono 3 PC con 4 o più giga", numResources == 3);
		
		numResources = GestionePrenotazioni.getRisorsePerLimiteEData("PC", 4, new DateTime(2016, 1, 15, 1, 0), new DateTime(2016, 1, 28, 0, 0)).size();
		Assert.assertTrue("Ci sono 2 PC con 4 o più giga liberi", numResources == 2);
	}
	
	@Test
	public void shouldPrintSomething() {
		
		for (Risorsa r: GestioneRisorse.getListaRisorse())
			System.out.println(r);
		
		for (Prenotazione p: GestionePrenotazioni.getListaPrenotazioni())
			System.out.println(p);
		
		for (Utente u: GestioneUtenti.getListaUtenti())
			System.out.println(u);
		
	}
	
}
