package iciresto;

import java.util.Scanner;
/**
 * @deprecated Solo utilizada en version de consola.
 * @author C.Garay,H.Sepúlveda,B.Lebrecht
 * @version November 8th 2017
 */
public class Menu {
	private Administrador adm;
        private Login lg;
	Menu(){
		adm=new Administrador();
		
        }

	private void opciones() {

		System.out.println("Seleccione una opcion");

		System.out.println("1. Ver Mesas");
		System.out.println("2. Editar Mesas");
		System.out.println("3. Agregar Mesas");
		System.out.println("4. Salir");
	}
        
        public void login(){
            Scanner sc = new Scanner(System.in);
            String username;
            String password;
             do{
                System.out.println("Ingrese su nombre de usuario:");
                username = sc.next();
                System.out.println("Ingrese su contraseÃ±a:");
                 password = sc.next();
                lg = new Login(username, password);
            }while(lg.usuarioExiste()== false);
            ejecutarMenu();
        }

	private void ejecutarMenu() {
		int opcion;
		Utilidades misUtilidades = new Utilidades();
		do {
			opciones();
			do{
				Scanner entrada = new Scanner(System.in);
				opcion=misUtilidades.validarInt(entrada.nextLine(), 1, 4, -1);
			}while(opcion==-1);
			if (opcion>=1 && opcion<=4) {
				switch (opcion) {
					case 1:
						adm.mostrarMesas();
						break;
					case 2:
						editarMesas();
						break;
					case 3:
						adm.agregarMesa(adm.getNumeroMesas()+1);
						break;
					case 4:
						System.exit(0);
						break;
					}
			}
		}while(opcion!=4);
	}
	
	private void editarMesas(){
		Utilidades misUtilidades = new Utilidades();
		preguntarNumeroMesa();
		int numero;
		do{
			Scanner entrada = new Scanner(System.in);
			numero = misUtilidades.validarInt(entrada.nextLine(), 1, adm.getNumeroMesas(),-1);
		}while(numero==-1);
		preguntarAtributo();
		int atributo;
		do{
			Scanner entrada = new Scanner(System.in);
			atributo = misUtilidades.validarInt(entrada.nextLine(), 1, 3,-1);
		}while(atributo==-1);
		if(atributo==1){
			preguntarCapacidad();
			int capacidad;
			do{
				Scanner entrada = new Scanner(System.in);
				capacidad = misUtilidades.validarInt(entrada.nextLine(), 1, -1);
			}while(capacidad==-1);
			adm.setCapacidadMesa(numero, capacidad);
		}else if(atributo==2){
			preguntarEstado();
			int estado;
			do{
				Scanner entrada = new Scanner(System.in);
				estado = misUtilidades.validarInt(entrada.nextLine(), 1, 5, -1);
			}while(estado==-1);
			if(estado==1){adm.setEstadoMesa(numero, "NO HABILITADA");}
			else if(estado==2){adm.setEstadoMesa(numero, "LIBRE");}
			else if(estado==3){adm.setEstadoMesa(numero, "ASIGNADA");}
			else if(estado==4){adm.setEstadoMesa(numero, "ATENDIDA");}
			else{adm.setEstadoMesa(numero, "RESERVADA");}
		}else{
			preguntarConsumo();
			int consumo;
			do{
				Scanner entrada = new Scanner(System.in);
				consumo = misUtilidades.validarInt(entrada.nextLine(), 0, -1);
			}while(consumo==-1);
			adm.setConsumoMesa(numero, consumo);
		}
		adm.guardarContenido();
	}
	
	
	
	//PREGUNTAS (Solo por orden y para entender mejor el codigo de arriba)
	
	private void preguntarNumeroMesa(){
		System.out.println("Â¿Que mesa desea editar?");
	}
	
	private void preguntarAtributo(){
		System.out.println("Â¿Que atributo desea cambiar? (1.- Capacidad / 2.- Estado / 3.- Consumo");
	}
	
	private void preguntarEstado(){
		System.out.println("Â¿A que estado desea cambiar la mesa? (1.- NO HABILITADA / 2.- LIBRE / 3.- ASIGNADA / 4.- ATENDIDA / 5.- RESERVADA");
	}
	
	private void preguntarCapacidad(){
		System.out.println("Ingrese la nueva capacidad.");
	}
	
	private void preguntarConsumo(){
		System.out.println("Ingrese el nuevo total de consumo para la mesa seleccionada.");
	}	
}
