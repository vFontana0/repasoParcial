
public class Curso extends Capacitacion {

	private Docente docente;
	private Integer cantClases;
	private Integer durClases;
	private Integer credRequeridos;
	
	public Curso(boolean prioratria, String nombre, Tema tema, Docente docente, Integer cantClases, Integer durClases, Integer credRequeridos, Integer credPorClase) {
		super(prioratria, nombre, tema);
		this.cantClases = cantClases;
		this.durClases = durClases;
		this.credRequeridos = credRequeridos;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer calcularCreditos() {
		// TODO Auto-generated method stub
		Integer retorno;
		retorno = (cantClases > 5)? 10: cantClases*2;
		if(docente.getAntiguedad() < 5) {
			retorno++;
		} else if(docente.getAntiguedad() >= 5 && docente.getAntiguedad() < 15) {
			retorno+=3;
		} else if(docente.getAntiguedad() >= 15) {
			retorno+=5;
		}
		retorno = (super.prioratria)? retorno+=2: retorno;
		return retorno;
	}

	@Override
	public Double calcularCosto() {
		Double retorno;
		Double costoDocente = (super.prioratria)? this.docente.getCostoPorHora()*1.10:this.docente.getCostoPorHora();
		retorno = costoDocente*this.cantClases*this.durClases;
		return retorno;
	}

	@Override
	public Docente getDocente() {
		return this.docente;
	}

	@Override
	public Integer getCreditosRequeridos() {
		return this.credRequeridos;
	}

	@Override
	public boolean Inscribir(Alumno a) throws CreditosInsuficientesException {
		if(a.obtenerCreditos() >= this.credRequeridos) {
			return true;
		} else {
			throw new CreditosInsuficientesException("No posee creditos suficientes para inscribirse a este curso");
		}
	}

	@Override
	public void aprobar(Alumno a) {
		// TODO Auto-generated method stub
		
	}
	
	


}
