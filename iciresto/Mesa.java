package iciresto;

public class Mesa {
	/**
	 * Clase que define un objeto Mesa.
	 * @author C.Garay,H.sepúlveda,B.Lebrecht
	 * @version November 8th 2017
	 */
	private String estado;
	private int capacidad;
	private int consumo;
	private int numero;

	/**
	 * 
	 * @param numero int Numero de la mesa
	 * @param capacidad int Capacidad de personas que tiene la mesa
	 * @param estado String Estado de la mesa "LIBRE","ASIGNADA","ATENDIDA","RESERVADA","NO HABILITADA"
	 * @param consumo int consumo total de la mesa
	 */
	public Mesa(int numero, int capacidad, String estado, int consumo) {
		this.numero=numero;
		this.capacidad = capacidad;
		this.estado = estado;
		this.consumo = consumo;
	}

	public int getNumero(){
		return this.numero;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public int getConsumo() {
		return this.consumo;
	}
	
	public void setNumero(int num){
		this.numero=num;
	}

	public void setEstado(String est) {
		this.estado = est;
	}

	public void setCapacidad(int cap) {
		this.capacidad = cap;
	}

	public void setConsumo(int cons) {
		this.consumo = cons;
	}

}
