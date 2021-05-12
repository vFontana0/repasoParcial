import java.util.ArrayList;

public class Alumno {
	private Integer nroMatricula;
	private String nombre;
	private ArrayList<Capacitacion> listaCapacitaciones = new ArrayList<Capacitacion>();
	private ArrayList<Capacitacion> listaCapacitacionesCurso = new ArrayList<Capacitacion>();
	
	public Integer obtenerCreditos() {
		return listaCapacitaciones.stream().mapToInt(s -> s.calcularCreditos()).sum();
	}
	
	public boolean inscribir(Capacitacion c) {
		try {
			if(c.Inscribir(this)) {
				listaCapacitacionesCurso.add(c);
				return true;
			} 
		} catch (TallerCompletoException | CreditosInsuficientesException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void aprobar(Capacitacion c) {
		listaCapacitacionesCurso.remove(c);
		listaCapacitaciones.add(c);
	}
}
