package iciresto;

import java.util.ArrayList;

import archivos.ArchivoLog;

public class Login {
    private String username;
    private String password;
    
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
   public boolean usuarioExiste(){
        String usuario = this.username+";"+this.password;
     
        ArchivoLog archLog = new ArchivoLog();
        if(archLog.esPrimeraVez()) {
        	archLog.agregarTexto("admin;admin");
        }
        ArrayList<String> listaUsuarios = archLog.leer();
        for(int i=0; i<listaUsuarios.size(); i++){
          if(usuario.equals(listaUsuarios.get(i))){
            return true;                
      }
      }
        return false;
    }
}
