package iciresto;

public class Utilidades {
	/**
	 *  @deprecated Solo utilizada en version de consola.
	 * Clase auxiliar, para validar entradas por consola.
	 * @author H.Sepúlveda.
	 * @version November 8th 2017
	 */
	
	/**
	 * 
	 * @param opcion String Opcion numerica ingresada
	 * @param minimo int minimo aceptable
	 * @param maximo int maximo aceptable
	 * @param retornoDefecto int retorno por defecto
	 * @return int por defecto si falla, o (integer) opcion si es valido
	 */
	public int validarInt(String opcion, int minimo, int maximo, int retornoDefecto){
		try{
			int aux=Integer.parseInt(opcion);
			if(aux<minimo||aux>maximo){
				System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
				return retornoDefecto;
			}else{
				return aux;
			}
		}catch(Exception e){
			System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
			return retornoDefecto;
		}
	}
	
	/**
	* @param opcion String Opcion numerica ingresada
	 * @param minimo int minimo aceptable
	 * @param retornoDefecto int retorno por defecto
	 * @return int por defecto si falla, o (integer) opcion si es valido
	 */
	public int validarInt(String opcion, int minimo, int retornoDefecto){
		try{
			int aux=Integer.parseInt(opcion);
			if(aux<minimo){
				System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
				return retornoDefecto;
			}else{
				return aux;
			}
		}catch(Exception e){
			System.out.println("Ha ingresado un valor no valido. Intente nuevamente.\n");
			return retornoDefecto;
		}
	}
}
