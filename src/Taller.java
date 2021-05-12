
public class Taller extends Capacitacion {

private Integer horas;
private Double costoPorHora;
private Integer cupoMaximo;
private Integer cantInscriptos;


public Taller(boolean prioratria, String nombre, Tema tema, Integer horas, Double costoPorHora, Integer cupoMaximo,
		Integer cantInscriptos) {
	super(prioratria, nombre, tema);
	this.horas = horas;
	this.costoPorHora = costoPorHora;
	this.cupoMaximo = cupoMaximo;
	this.cantInscriptos = cantInscriptos;
}

@Override
public Integer calcularCreditos() {
	Integer retorno;
	retorno = (horas > 72)? 72: horas/6;
	retorno = (super.prioratria)? retorno++: retorno;
	return retorno;
}

@Override
public Double calcularCosto() {
	Double retorno;
	retorno = this.horas*this.costoPorHora;
	retorno = (super.prioratria)? retorno*1.20: retorno;
	return retorno;
}

@Override
public Docente getDocente() {
	return null;
}

@Override
public Integer getCreditosRequeridos() {
	return null;
}

@Override
public boolean Inscribir(Alumno a) throws TallerCompletoException {
	if(cantInscriptos < cupoMaximo) {
		this.cantInscriptos++;
		return true;
	} else {
	throw new TallerCompletoException("El cupo del taller está completo, por lo que no se puede inscribir.");	
	}
}

@Override
public void aprobar(Alumno a) {
	this.cantInscriptos--;
}


}
