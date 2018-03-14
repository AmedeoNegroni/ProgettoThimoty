package projects.project1.prenotazioniNew.model;

public abstract class Risorsa {

	protected int limite;
	protected String caratteristica;
	protected int id;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nRisorsa n." + id + "\n");
		sb.append("\ttipo: " + this.getClass().getSimpleName() + "\n");
		sb.append("\t" + this.caratteristica + ": " + this.limite +"\n");
		return sb.toString();
	}
	
}
