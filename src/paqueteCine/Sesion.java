package paqueteCine;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase para representar una sesi�n de proyecci�n de una pel�cula en una
 * fecha y hora determinadas.
 * 
 * @version 09/05/2021
 * @author Rub�n Jim�nez Guti�rrez
 */
public class Sesion {
	private LocalDate fecha;
	private LocalTime hora;
	private Pelicula pelicula;
	private int capacidad;
	private int butacasDisponibles;
	private int butacasVendidas;

	/**
	 * Crea una sesi�n indicando la capacidad m�xima de la sala.
	 * 
	 * @param capacidad - N�mero m�ximo de butacas que se pueden ocupar en la sala.
	 */
	public Sesion(int capacidad) {
		this.capacidad = capacidad;
		this.butacasDisponibles = capacidad;
	}

	/**
	 * Crea una sesi�n indicando fecha, hora y pel�cula proyectada en la misma.
	 * 
	 * @param fecha    - Fecha en la que se programa la sesi�n.
	 * @param hora     - Hora en la que se programa la sesi�n.
	 * @param pelicula - Pel�cula que se proyecta.
	 */
	public Sesion(LocalDate fecha, LocalTime hora, Pelicula pelicula) {
		this.fecha = fecha;
		this.hora = hora;
		this.pelicula = pelicula;
	}

	/**
	 * @return Devuelve la fecha a la que est� programada la sesi�n como un objeto
	 *         LocalDate.
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @return Devuelve la hora a la que est� programada la sesi�n como un objeto
	 *         LocalTime.
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @return Devuelve el n�mero de butacas a�n disponibles para la sesi�n.
	 */
	public int getButacasDisponibles() {
		return butacasDisponibles;
	}

	/**
	 * @return Devuelve el n�mero de butacas vendidas como un int.
	 */
	public int getButacasVendidas() {
		return butacasVendidas;
	}

	/**
	 * @return Devuelve la pel�cula que est� programada en la sesi�n como un objeto
	 *         de la clase Pelicula.
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * Cambia la fecha en la que est� programada la sesi�n.
	 * 
	 * @param fecha - Fecha en la que est� programada la pel�cula.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Cambia la hora a la que est� programada la pel�cula.
	 * 
	 * @param hora - Hora a la que est� programada la pel�cula.
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * Cambia la pel�cula que se proyecta en la sesi�n.
	 * 
	 * @param pelicula - Instancia de la clase pel�cula que se proyecta.
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * Modifica la capacidad de la sesi�n.
	 * 
	 * @param capacidad - Nueva capacidad que se quiere dar a la sesi�n.
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
		butacasDisponibles = capacidad - butacasVendidas;
	}

	/**
	 * Devuelve una cadena de caracteres que contiene los datos de la sesi�n y de la
	 * pel�cula agendada con el siguiente formato: Sesi�n: Fecha: Hora: Butacas
	 * disponibles: Pel�cula: A�o: G�nero: Director: Actores: Sinopsis:
	 * 
	 * @return Devuelve un String con las caracter�sticas descritas anteriormente.
	 */
	public String mostrarSesion() {
		return "Sesi�n:\n" + "\tFecha: " + fecha + "\tHora: " + hora + "\tButacas disponibles: " + butacasDisponibles
				+ "\n" + "Pelicula: " + pelicula.mostrarPelicula();
	}

	/**
	 * Reduce la disponibilidad de butacas en la sesi�n tras vender un determinado
	 * n�mero de entradas.
	 * 
	 * @param butacasVendidas - N�mero de entradas o butacas que se venden.
	 * @return Devuelve true si se venden las butacas y false en caso contrario.
	 */
	public boolean reducirDisponibilidad(int butacasVendidas) {
		if (butacasVendidas <= butacasDisponibles) {
			this.butacasVendidas += butacasVendidas;
			butacasDisponibles -= butacasVendidas;
			return true;
		} else {
			System.out.println("No se pueden vender " + butacasVendidas + "butacas.");
			System.out.println("En esta sesi�n solo quedan " + butacasDisponibles + " butacas disponibles.\n");
			System.out.println(mostrarSesion());
			return false;
		}
	}
}
