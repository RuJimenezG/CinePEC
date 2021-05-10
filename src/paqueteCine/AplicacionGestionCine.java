package paqueteCine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class AplicacionGestionCine {
	private String nombreCine;
	private String direccion;
	private Cartelera cartelera;
	private ArrayList sesiones;
	private int capacidad;
	
	public AplicacionGestionCine(String nombreCine, String direccion, int capacidad) {
		this.nombreCine = nombreCine;
		this.direccion = direccion;
		this.capacidad = capacidad;
		List sesiones = new ArrayList<Sesion>();
	}
	
	public boolean nuevaPelicula(Pelicula pelicula) {
		return cartelera.nuevaPelicula(pelicula);
	}
	
	public boolean nuevaPelicula(List<Pelicula> peliculas) {
		return cartelera.nuevaPelicula(peliculas);
	}
	
	public String visualizarCartelera () {
		return cartelera.mostrarCartelera();
	}
	
	public void nuevaSesion(Sesion sesion) {
		sesiones.add(sesion);
	}
	
	public void nuevaSesion(LocalDate fecha, LocalTime hora, Pelicula pelicula) {
		Sesion sesion = new Sesion(fecha, hora, pelicula);
		sesiones.add(sesion);
	}
	
	public String mostrarSesiones (String titulo) {
		
	}
	
}
