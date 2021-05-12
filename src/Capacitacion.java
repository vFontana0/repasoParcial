
public abstract class Capacitacion {
protected boolean prioratria;
protected String nombre;
protected Tema tema;

public Capacitacion(boolean prioratria, String nombre, Tema tema) {
	super();
	this.prioratria = prioratria;
	this.nombre = nombre;
	this.tema = tema;
}

public abstract Integer calcularCreditos();
public abstract boolean Inscribir(Alumno a) throws TallerCompletoException, CreditosInsuficientesException;
public abstract Double calcularCosto();
public abstract void aprobar(Alumno a);
public abstract Docente getDocente();

public abstract Integer getCreditosRequeridos();

public boolean isPrioratria() {
	return prioratria;
}

public String getNombre() {
	return nombre;
}

public Tema getTema() {
	return tema;
}
}