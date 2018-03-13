package projects.project1.prenotazioniNew.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import projects.project1.prenotazioniNew.model.Prenotazione;

public class PrenotazioniDAO<T extends Prenotazione> implements InterfacciaDAO<Integer, T> {

	private static int incrementalId = 0;
	private static TreeMap<Integer, Prenotazione> listaPrenotazioni;
	
	public PrenotazioniDAO() {
		listaPrenotazioni = Database.<Integer, Prenotazione>createMap("Prenotazioni");
	}
	
	@Override
	public void insert(T t) {
		incrementalId++;
		t.setId(incrementalId);
		listaPrenotazioni.put(incrementalId, t);
	}

	@Override
	public void delete(Integer id) {
		listaPrenotazioni.remove(id);
	}

	@Override
	public void update(Integer id, T t) {
		listaPrenotazioni.put(id, t);
	}

	@Override
	public TreeMap<Integer, T> getMap() {
		return (TreeMap<Integer, T>) listaPrenotazioni;
	}
	
	@Override
	public List<T> getList() {
		List<T> arrayPrenotazioni = new ArrayList(listaPrenotazioni.values());
		return arrayPrenotazioni;
	}
	
	@Override
	public Set<Integer> getKeys() {
		return listaPrenotazioni.keySet();
	}

	@Override
	public T getById(Integer id) {
		return (T) listaPrenotazioni.get(id);
	}
	
	@Override
	public void clear() {
		listaPrenotazioni.clear();
		incrementalId = 0;
	}
	
	@Override
	public boolean compareId(Integer id) {
		for (Integer i: getKeys())
			if (i == id)
				return true;
		return false;
	}

}
