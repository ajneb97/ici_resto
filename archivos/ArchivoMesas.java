package archivos;

import java.util.ArrayList;

import iciresto.Mesa;
/**
 * Clase destinada al manejo de archivos contenedores de la informacion de mesas
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version December 2nd 2017
 */
public class ArchivoMesas extends Archivo{

    public ArchivoMesas() {
        super("src/recursos/mesas.txt");
    }  
        
    @Override
    public ArrayList<Mesa> listarContenido(){
	ArrayList<Mesa> listaMesas = new ArrayList<>();
	String texto=leerContenido();
	String[] mesas = texto.split("-");
	for(int i=1;i<mesas.length;i++){
            String[] propiedades = mesas[i].split(";");
            String[]aux=propiedades[0].split(" ");
            propiedades[3]=propiedades[3].replaceAll("[\r\n]","");
            Mesa mesa=new Mesa(Integer.parseInt(aux[1]),Integer.parseInt(propiedades[1]),propiedades[2],Integer.parseInt(propiedades[3]));
            listaMesas.add(mesa);
        }
        return listaMesas;
}
}
