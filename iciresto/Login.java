package iciresto;

import java.util.ArrayList;

import archivos.ArchivoLog;
/*
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version November 8th 2017
 */
public class Login {
    private String username;
    private String password;
    
   /**
    *  
    * @param username String Nombre de usuario ingresado
    * @param password String Contraseña de usuario ingresado
    */
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    /**
     * Clase destinada a cada login, con username y password.
     * @return boolean True si el usuario existe en el archivo de registro de usuario, False de lo contrario
     */
   public boolean usuarioExiste(){
        String usuario = this.username+";"+this.password;
     
        ArchivoLog archLog = new ArchivoLog();
        if(archLog.esPrimeraVez()) {
        	archLog.agregarTexto("admin;admin");
        }
        ArrayList<String> listaUsuarios = archLog.listarContenido();
        for(int i=0; i<listaUsuarios.size(); i++){
          if(usuario.equals(listaUsuarios.get(i))){
            return true;                
      }
      }
        return false;
    }
}
