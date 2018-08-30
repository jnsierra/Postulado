package co.com.ud;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import co.com.dto.Informacion;
import co.com.dto.Operaciones;

public class Aplication {
	
	public static Logger log = Logger.getLogger(Aplication.class.getName());
	
	public static void main(String ... args) {
		Aplication app = new Aplication();
		try {
			Integer datoIni = app.capturaDato();
			//System.out.println( "Este fue el dato que tomo: ".concat(datoIni.toString()) );
			//Objeto con el que haré el procesamiento de información
			Operaciones primerPostulado = app.ordenaInformacionPrimerPostulado(datoIni);
			System.out.println("Procesamiento primer postulado");
			if(!app.procesaInformacion(primerPostulado)) {
				System.out.println("Procesamiento segundo postulado, se comprueba en este ya que no se encontro informacion en el primero:...");
				Operaciones segundoPostulado = app.ordenaInformacionSegundoPostulado(datoIni);
				app.procesaInformacion(segundoPostulado);
			}
			
			System.out.println("Fin de operaciones");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Boolean procesaInformacion(Operaciones op) {
		Boolean valida = Boolean.FALSE;
		try {
			for(int i = 0 ; i < 100 && !valida ; i++) {
				Boolean encontro = op.generaOperacion(i);
				if(encontro && op.getEncuentraUno() ) {
					return Boolean.TRUE;
				}else if(encontro) {
					valida = Boolean.TRUE;
				}
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error " , e );
		}
		return valida;
	}
	
	public Operaciones ordenaInformacionPrimerPostulado(int dato) {
		return Operaciones.of(
				Informacion.of(Integer.valueOf("0"), Integer.valueOf("6") , Integer.valueOf("0"), dato), 
				Informacion.of(Integer.valueOf("0"), Integer.valueOf("6") , Integer.valueOf("0"), Integer.valueOf("1")),
				Boolean.FALSE
				);
	}
	
	public Operaciones ordenaInformacionSegundoPostulado(int dato) {
		return Operaciones.of(
				Informacion.of(Integer.valueOf("0"), Integer.valueOf("6") , Integer.valueOf("0"), dato), 
				Informacion.of(Integer.valueOf("0"), Integer.valueOf("6") , Integer.valueOf("0"), Integer.valueOf("5")),
				Boolean.FALSE
				);
	}
	
	public int capturaDato() {
		int dato = 0;
		Boolean bandera = Boolean.FALSE;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Por favor digite un numero primo mayor o igual a 5: ");
			dato = sc.nextInt();
			do {
				if(dato<5) {
					System.out.println("El numero es menor a 5...");
					dato=0;
					sc = new Scanner(System.in);
					System.out.println("Por favor digite un numero primo mayor o igual a 5: ");
					dato = sc.nextInt();
				}else if(!validaPrimo(dato) ) {
					System.out.println("El numero no es primo...");
					dato=0;
					sc = new Scanner(System.in);
					System.out.println("Por favor digite un numero primo mayor o igual a 5: ");
					dato = sc.nextInt();
				}
				else if(validaPrimo(dato) ) {
					bandera = Boolean.TRUE;
				}
			} while (Boolean.FALSE.equals(bandera));


		} catch (Exception e) {
			log.log(Level.SEVERE, "Error: ", e);

		}
		return dato;
	} 
	
	/**
	 * Funcion con la cual valido si un entero es primo
	 * @param dato
	 * @return
	 */
	public Boolean validaPrimo(int dato) {
		try {
			for(int i = 2 ; i * i <= dato ; i++) {

				if(dato%i == 0) {
					return Boolean.FALSE;
				}
			}
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error: " , e);
		}
		return Boolean.TRUE;
	}


	

}
