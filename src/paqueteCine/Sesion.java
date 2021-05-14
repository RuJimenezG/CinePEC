package paqueteCine;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase para representar una sesión de proyección de una película en una
 * fecha y hora determinadas.
 * 
 * @version 09/05/2021
 * @author Rubén Jiménez Gutiérrez
 */
public class Sesion {
	private LocalDate fecha;
	private LocalTime hora;
	private Pelicula pelicula;
	private int capacidad;
	private int butacasDisponibles;
	private int butacasVendidas;

	/**
	 * Crea una sesión indicando la capacidad máxima de la sala.
	 * 
	 * @param capacidad - Número máximo de butacas que se pueden ocupar en la sala.
	 */
	public Sesion(int capacidad) {
		this.capacidad = capacidad;
		this.butacasDisponibles = capacidad;
	}

	/**
	 * Crea una sesión indicando fecha, hora y película proyectada en la misma.
	 * 
	 * @param fecha    - Fecha en la que se programa la sesión.
	 * @param hora     - Hora en la que se programa la sesión.
	 * @param pelicula - Película que se proyecta.
	 */
	public Sesion(LocalDate fecha, LocalTime hora, Pelicula pelicula) {
		this.fecha = fecha;
		this.hora = hora;
		this.pelicula = pelicula;
	}

	/**
	 * @return Devuelve la fecha a la que está programada la sesión como un objeto
	 *         LocalDate.
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @return Devuelve la hora a la que está programada la sesión como un objeto
	 *         LocalTime.
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @return Devuelve el número de butacas aún disponibles para la sesión.
	 */
	public int getButacasDisponibles() {
		return butacasDisponibles;
	}

	/**
	 * @return Devuelve el número de butacas vendidas como un int.
	 */
	public int getButacasVendidas() {
		return butacasVendidas;
	}

	/**
	 * @return Devuelve la película que está programada en la sesión como un objeto
	 *         de la clase Pelicula.
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * Cambia la fecha en la que está programada la sesión.
	 * 
	 * @param fecha - Fecha en la que está programada la película.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Cambia la hora a la que está programada la película.
	 * 
	 * @param hora - Hora a la que está programada la película.
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * Cambia la película que se proyecta en la sesión.
	 * 
	 * @param pelicula - Instancia de la clase película que se proyecta.
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Modifica la capacidad de la sesión.
	 * 
	 * @param capacidad - Nueva capacidad que se quiere dar a la sesión.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
		butacasDisponibles = capacidad - butacasVendidas;
	}

	/**
	 * Devuelve una cadena de caracteres que contiene los datos de la sesión y de la
	 * película agendada con el siguiente formato: Sesión: Fecha: Hora: Butacas
	 * disponibles: Película: Año: Género: Director: Actores: Sinopsis:
	 * 
	 * @return Devuelve un String con las características descritas anteriormente.
	 */
	public String mostrarSesion() {
		return "Sesión:\n" + "\tFecha: " + fecha + "\tHora: " + hora + "\tButacas disponibles: " + butacasDisponibles
				+ "\n" + "Pelicula: " + pelicula.mostrarPelicula();
	}

	/**
	 * Reduce la disponibilidad de butacas en la sesión tras vender un determinado
	 * número de entradas.
	 * 
	 * @param butacasVendidas - Número de entradas o butacas que se venden.
	 * @return Devuelve true si se venden las butacas y false en caso contrario.
	 */
	public boolean reducirDisponibilidad(int butacasVendidas) {
		if (butacasVendidas <= butacasDisponibles) {
			this.butacasVendidas += butacasVendidas;
			butacasDisponibles -= butacasVendidas;
			return true;
		} else {
			System.out.println("No se pueden vender " + butacasVendidas + "butacas.");
			System.out.println("En esta sesión solo quedan " + butacasDisponibles + " butacas disponibles.\n");
			System.out.println(mostrarSesion());
			return false;
		}
	}
}
