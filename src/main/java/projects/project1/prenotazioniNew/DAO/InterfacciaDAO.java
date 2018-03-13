package projects.project1.prenotazioniNew.DAO;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public interface InterfacciaDAO<K,T> {

	public void insert(T t);
	public void delete(K k);
	public void update(K k, T t);
	public Set<K> getKeys();
	public List<T> getList();
	public TreeMap<K,T> getMap();
	public T getById(K k);
	public boolean compareId(K k);
	public void clear();
	
}
