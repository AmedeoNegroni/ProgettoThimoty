package projects.project1.prenotazioniNew.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import projects.project1.prenotazioniNew.model.Utente;

public class UtenteDAO<T extends Utente> implements InterfacciaDAO<String, T> {
	
	private static TreeMap<String, Utente> listaUtenti;
	
	public UtenteDAO() {
		listaUtenti = Database.<String, Utente>createMap("Utenti");
	}
	
	@Override
	public void insert(T t) {
		listaUtenti.put(t.getMail(),t);
	}

	@Override
	public void delete(String mail) {
		listaUtenti.remove(mail);
	}

	@Override
	public void update(String mail, T t) {
		listaUtenti.put(mail, t);
	}

	@Override
	public TreeMap<String, T> getMap() {
		return (TreeMap<String, T>) listaUtenti;
	}
	
	@Override
	public Set<String> getKeys() {
		return listaUtenti.keySet();
	}
	
	@Override
	public List<T> getList() {
		List<T> arrayUtenti = new ArrayList(listaUtenti.values());
		return arrayUtenti;
	}

	@Override
	public T getById(String mail) {
		return (T) listaUtenti.get(mail);
	}
	
	@Override
	public void clear() {
		listaUtenti.clear();
	}
	
	@Override
	public boolean compareId(String mail) {
		for (String s: getKeys())
			if (mail == s)
				return true;
		return false;
	}

}
