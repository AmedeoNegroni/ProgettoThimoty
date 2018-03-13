package projects.project1.prenotazioniNew.DAO;

import java.util.TreeMap;

class Database {
	
	static TreeMap<String,TreeMap<?, ?>> lista = new TreeMap<>();;
	
	public static <K, T> TreeMap<K, T> createMap(String nome) {
		TreeMap<K ,T> nuovaMappa = new TreeMap<K, T>();
		lista.put(nome,nuovaMappa);
		return nuovaMappa;
	}
		
}
