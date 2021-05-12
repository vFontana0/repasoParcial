import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Empleado {

	private ArrayList<Capacitacion> listaCapacitaciones = new ArrayList<Capacitacion>();
	private String nombre;
	
	public Empleado(String nombre) {
		this.nombre= nombre;
	}
	
	public Integer obtenerCreditos() {
		return listaCapacitaciones.stream().mapToInt(s -> s.calcularCreditos()).sum();
	}
	
	public Double obtenerCosto() {
		return listaCapacitaciones.stream().mapToDouble(s-> s.calcularCosto()).sum();
	}
	public Double obtenerCostoPromedio() {
		return listaCapacitaciones.stream().mapToDouble(null).average().orElse(0);
	}
	
	public ArrayList<Capacitacion> capacitacionesPorTema(Tema tema) {
		ArrayList<Capacitacion> r1 = new ArrayList<Capacitacion>(listaCapacitaciones.stream().filter(s->s.getTema().equals(tema)).sorted((t1, t2) -> t2.calcularCosto().compareTo(t1.calcularCosto())).collect(Collectors.toList()));
		return r1;
	}
	
	public Docente docenteCursoMayorCantidadCredRequeridos() {
		return listaCapacitaciones.stream().filter(s -> s instanceof Curso).sorted((s1, s2) -> s2.getCreditosRequeridos().compareTo(s1.getCreditosRequeridos())).map(s->s.getDocente()).findFirst().orElse(null);
	}
	
	public ArrayList<Capacitacion> capacitacionesEstrategicas(){
		ArrayList<Capacitacion> r1 = new ArrayList<Capacitacion>(listaCapacitaciones.stream().filter(s->s.isPrioratria()).collect(Collectors.toList()));
		return r1;
	}
	
	public ArrayList<Capacitacion> capacitacionesOrdenadasCredOtorgan(){
		ArrayList<Capacitacion> r1 = new ArrayList<Capacitacion>(listaCapacitaciones.stream().sorted((s1, s2)-> s2.calcularCreditos().compareTo(s1.calcularCreditos())).collect(Collectors.toList()));
		return r1;
	}
}
