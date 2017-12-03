package archivos;

import java.util.ArrayList;
/**
 * Clase destinada al manejo de archivos asociados al manejo de usuarios y login.
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version December 3th 2017
 */

public class ArchivoLog extends Archivo{

    public ArchivoLog() {
        super("src/recursos/login.txt");
    }
    
   
    @Override   
  
    public ArrayList<String> listarContenido() {
        ArrayList<String> listaUsuarios = new ArrayList<>();
        String texto=leerContenido();
	String[] usuarios = texto.split("-");
	for(int i=0;i<usuarios.length;i++){
            listaUsuarios.add(usuarios[i]);
             }
        return listaUsuarios;
    }
}
    

