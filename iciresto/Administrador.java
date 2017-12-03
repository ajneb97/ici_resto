package iciresto;

import java.util.ArrayList;

import archivos.ArchivoMesas;
/**
 * Clase destinada al usuario administrador, para manejar informacion relativa a las mesas.
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version December 2nd 2017
 */
public class Administrador {
	private ArrayList<Mesa> listaMesas;

	public Administrador(){
                this.listaMesas = llenarMesa();
	}
/**
 * 
 * @return ArrayList Lista de mesas
 */
	public ArrayList<Mesa> llenarMesa() {
		ArchivoMesas archivoMesas = new ArchivoMesas();
		ArrayList<Mesa> lista;
		if (archivoMesas.esPrimeraVez()) {
			lista = new ArrayList<Mesa>();
		} else {
			lista = archivoMesas.listarContenido();
		}
		return lista;
	}

	/**
	 * 
	 * @param numeroMesa Numero de la mesa
	 */
	public void agregarMesa(int numeroMesa) {
		Mesa miMesa=new Mesa(numeroMesa,0,"LIBRE",0);
		listaMesas.add(miMesa);
		guardarContenido();
	}
       
	/**
	 * 
	 * @param posicion Posicion de la mesa a eliminar del Array
	 */
        public void eliminarMesa(int posicion){
            listaMesas.remove(posicion);
            for(int i=0;i<listaMesas.size();i++){
                listaMesas.get(i).setNumero(i+1);
            }
            guardarContenido();
        }
        
        public void guardarContenido(){
        	ArchivoMesas archivoMesas = new ArchivoMesas();
            String contenido = "Mesas:\r\n";
            for (int i = 0; i < listaMesas.size(); i++) {	
                contenido = contenido + "-Mesa "+listaMesas.get(i).getNumero()+";"+listaMesas.get(i).getCapacidad()+";"+listaMesas.get(i).getEstado()+";"+listaMesas.get(i).getConsumo()+"\r\n";
            }
            archivoMesas.agregarTexto(contenido);
        }
		
	public void mostrarMesas(){
		System.out.println("Mesas:\n\t\tCAPACIDAD\tESTADO\t\t\tCONSUMO");
		for (int i = 0; i < listaMesas.size(); i++) {
                    if(listaMesas.get(i).getEstado().equals("LIBRE")){
                        System.out.println("-Mesa "+listaMesas.get(i).getNumero()+":\t\t"+listaMesas.get(i).getCapacidad()+"\t"+listaMesas.get(i).getEstado()+"\t\t\t"+listaMesas.get(i).getConsumo()+"\r");
                    }else{
                        System.out.println("-Mesa "+listaMesas.get(i).getNumero()+":\t\t"+listaMesas.get(i).getCapacidad()+"\t"+listaMesas.get(i).getEstado()+"\t\t"+listaMesas.get(i).getConsumo()+"\r");
                    }
			
		}
	}
	
	/**
	 * 
	 * @return Lista de mesas
	 */
	public ArrayList<Mesa> getListaMesas(){
		return this.listaMesas;
	}
	
	public int getNumeroMesas(){
		return listaMesas.size();
	}
	
	public void setListaMesas(ArrayList<Mesa> nuevaListaMesas){
		this.listaMesas=nuevaListaMesas;
	}
	
	public void setEstadoMesa(int numeroMesa, String estadoMesa){
            
		listaMesas.get(numeroMesa-1).setEstado(estadoMesa);
	}
	
	
	public void setCapacidadMesa(int numeroMesa, int capacidadMesa){
		listaMesas.get(numeroMesa-1).setCapacidad(capacidadMesa);
	}
	
	public void setConsumoMesa(int numeroMesa, int consumoMesa){
		listaMesas.get(numeroMesa-1).setConsumo(consumoMesa);
	}
}
