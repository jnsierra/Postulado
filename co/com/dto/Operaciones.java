package co.com.dto;

public class Operaciones {
	
	private Informacion infoUsuario;
	private Informacion infoCalculada;
	private Boolean encuentraUno;
	
	
	public static Operaciones of(Informacion infoUsuario, Informacion infoCalculada, Boolean encuentraUno) {
		Operaciones aux = new Operaciones();
		aux.setInfoUsuario(infoUsuario);
		aux.setInfoCalculada(infoCalculada);
		aux.setEncuentraUno(encuentraUno);
		return aux;
	}


	public Informacion getInfoUsuario() {
		return infoUsuario;
	}


	public void setInfoUsuario(Informacion infoUsuario) {
		this.infoUsuario = infoUsuario;
	}


	public Informacion getInfoCalculada() {
		return infoCalculada;
	}


	public void setInfoCalculada(Informacion infoCalculada) {
		this.infoCalculada = infoCalculada;
	}
	
	
	
	public Boolean getEncuentraUno() {
		return encuentraUno;
	}


	public void setEncuentraUno(Boolean encuentraUno) {
		this.encuentraUno = encuentraUno;
	}


	public Boolean generaOperacion(Integer datoUno) {
		Boolean encontroCoincidencias = Boolean.FALSE;
		//Primera operacion
		getInfoUsuario().setDato1Mult(datoUno);
		getInfoUsuario().cambioDatoUno();
		//getInfoUsuario().muestroDatos();
		//Segunda operacion encuentro operacion que coincida
		for(int i = 0 ; i < 100 ; i++) {
			getInfoCalculada().setDato1Mult(i);
			getInfoCalculada().cambioDatoUno();
			//getInfoCalculada().muestroDatos();
			if( getInfoUsuario().getValido() && getInfoCalculada().getValido() ) {
				if(getInfoUsuario().getDatoSum().equals(getInfoCalculada().getDatoSum())) {
					encontroCoincidencias = Boolean.TRUE;
					System.out.println("*********************************************************************");
					System.out.println("Coinciden.....");
					System.out.println("Primera Operacion:".concat(getInfoUsuario().muestroDatos()).concat(" Segunda operacion: ").concat(getInfoCalculada().muestroDatos()) );
					System.out.println("*********************************************************************");
					if(encuentraUno) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return encontroCoincidencias;
	}

}
