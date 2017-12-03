package archivos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * Clase destinada al manejo de archivos asociados al funcionamiento del programa
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version December 2nd 2017
 */



public abstract class Archivo {
	private Path path;
	protected File directorio;

	/**
	 * @param path String Ruta del archivo manejado.
	 */
   protected Archivo(String path){
	  directorio = new File("src/recursos");
	  directorio.mkdir();
	       this.path = Paths.get(path);
    }
     /**
      * @return ruta del archivo manejado.  
      */
  
	protected Path getRuta() {
            return this.path;
	}
	
	
	/**
	 * @return String con contenido del archivo leído
	 */	
	protected String leerContenido() {
		String texto;
		try {
			texto = new String(Files.readAllBytes(getRuta()));
		} catch (IOException e) {
			//System.err.println("Ha ocurrido un error al intentar leer el archivo.");
			return null;
		}
		return texto;
	}
	
	
	/**
	 * @return boolean Existencia del archivo
	 */
	public boolean esPrimeraVez() {

		return Files.notExists(getRuta());
	}
	
	/**
	 * 
	 * @param texto String Contenido a agregar en archivo.
	 */
	public void agregarTexto(String texto){
		try {
			Files.write(getRuta(), texto.getBytes());
                         
			//System.out.println("Archivo guardado correctamente");
		} catch (IOException e) {
			//System.out.println("Error al intentar crear el archivo");
		}
	}
	/** 
	 * @return ArrayList Contenidos listados del archivo.
	 */
	
	protected abstract ArrayList listarContenido();
}
