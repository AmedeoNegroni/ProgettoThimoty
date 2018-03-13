package projects.project1.prenotazioniNew.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import projects.project1.prenotazioniNew.model.Risorsa;

public class RisorsaDAO<T extends Risorsa> implements InterfacciaDAO <Integer, T>{
	
	private static int incrementalId = 0;
	private static TreeMap<Integer, Risorsa> listaRisorse;
	
	public RisorsaDAO() {
		listaRisorse = Database.<Integer, Risorsa>createMap("Risorse");
	}
	
	@Override
	public void insert(T t) {
		incrementalId++;
		t.setId(incrementalId);
		listaRisorse.put(incrementalId, t);
	}

	@Override
	public void delete(Integer id) {
		listaRisorse.remove(id);
	}

	@Override
	public void update(Integer id, T t) {
		listaRisorse.put(id, t);
	}

	@Override
	public TreeMap<Integer, T> getMap() {
		return (TreeMap<Integer, T>) listaRisorse;
	}
	
	@Override
	public List<T> getList() {
		List<T> arrayRisorse = new ArrayList(listaRisorse.values());
		return arrayRisorse;
	}

	@Override
	public Set<Integer> getKeys() {
		return listaRisorse.keySet();
	}
	
	@Override
	public T getById(Integer id) {
		return (T) listaRisorse.get(id);
	}
	
	@Override
	public void clear() {
		listaRisorse.clear();
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
