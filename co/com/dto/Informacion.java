package co.com.dto;

public class Informacion {

	private Integer dato1Mult;
	private Integer dato2Mult;
	private Integer datoSum;
	private Integer resultado;
	private Boolean valido;

	public static Informacion of(int dato1Mult, int dato2Mult, int datoSum, int resultado) {
		return new Informacion(dato1Mult, dato2Mult, datoSum, resultado);
	}

	private Informacion(int dato1Mult, int dato2Mult, int datoSum, int resultado) {
		super();
		this.dato1Mult = dato1Mult;
		this.dato2Mult = dato2Mult;
		this.datoSum = datoSum;
		this.resultado = resultado;
	}

	public Integer getDato1Mult() {
		return dato1Mult;
	}

	public void setDato1Mult(Integer dato1Mult) {
		this.dato1Mult = dato1Mult;
	}

	public Integer getDato2Mult() {
		return dato2Mult;
	}

	public void setDato2Mult(Integer dato2Mult) {
		this.dato2Mult = dato2Mult;
	}

	public Integer getDatoSum() {
		return datoSum;
	}

	public void setDatoSum(Integer datoSum) {
		this.datoSum = datoSum;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	
	public void cambioDatoUno() {
		try {
			//Encuentro el dato suma 
			//Con la siguiente ecuacion : suma = (resultado)/(dato1Mult*dato2Mult)
			setDatoSum( getResultado() -  (getDato1Mult()*getDato2Mult()) );
			setValido(Boolean.TRUE);
		} catch (Exception e) {
			e.printStackTrace();
			setValido(Boolean.FALSE);
		}
	}
	
	public String muestroDatos() {
		return (getValido() ? resultado.toString().concat(" = ").concat(getDato1Mult().toString()).concat(" X ").concat(getDato2Mult().toString()).concat(" + ").concat(getDatoSum().toString()) : resultado.toString().concat(" = ").concat(getDato1Mult().toString()).concat(" X ").concat(getDato2Mult().toString()).concat(" + ").concat(getDatoSum().toString())  );
//		if(getValido()) {
//			System.out.println("**********************************************");
//			System.out.println(resultado.toString().concat(" = ").concat(getDato1Mult().toString()).concat(" X ").concat(getDato2Mult().toString()).concat(" + ").concat(getDatoSum().toString()) );
//			System.out.println("**********************************************");
//		}else {
//			System.out.println("**********************************************");
//			System.out.println("Operaciones no validas ");
//			System.out.println(resultado.toString().concat(" = ").concat(getDato1Mult().toString()).concat(" X ").concat(getDato2Mult().toString()).concat(" + ").concat(getDatoSum().toString()) );
//			System.out.println("**********************************************");
//		}
		
	}

	public Boolean getValido() {
		return valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}

}
