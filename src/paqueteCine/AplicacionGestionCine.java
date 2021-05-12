package paqueteCine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase que permite realizar la gestión del cine.
 * 
 * @version 11/05/2021
 * @author Rubén Jiménez Gutiérrez
 */
public class AplicacionGestionCine {
	private String nombreCine;
	private String direccion;
	private Cartelera cartelera;
	private ArrayList<Sesion> sesiones;
	private int capacidad;

	/**
	 * Crea una instancia de la aplicación que gestiona el cine.
	 * 
	 * @param nombreCine - Nombre del cine.
	 * @param direccion  - Dirección del cine.
	 * @param capacidad  - Número máximo de butacas de las que dispone la sala de
	 *                   cine.
	 */
	public AplicacionGestionCine(String nombreCine, String direccion, int capacidad) {
		this.nombreCine = nombreCine;
		this.direccion = direccion;
		this.capacidad = capacidad;
		this.cartelera = new Cartelera();
		this.sesiones = new ArrayList<Sesion>();
	}

	/**
	 * @return Devuelve la capacidad de la sala, es decir el número de butacas de
	 *         que dispone.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * Añade una película a la cartelera del cine.
	 * 
	 * @param pelicula - Es el nombre de la instancia de la clase película que se
	 *                 quiere añadir.
	 * @return Devuelve true cuando se ha añadido la película a la cartelera.
	 */
	public boolean nuevaPelicula(Pelicula pelicula) {
		return cartelera.nuevaPelicula(pelicula);
	}

	/**
	 * Añade nuevas películas a la cartelera del cine a partir de un listado
	 * preexistente. Para cada película del listado se comprueba primero si dicha
	 * película no está ya en el listado. De ser así se añade.
	 * 
	 * @param lista Nombre de la instancia del objeto lista que contiene las
	 *              películas a añadir.
	 * @return Devuelve true cuando se ha añadido alguna película.
	 */
	public boolean nuevaPelicula(List<Pelicula> lista) {
		return cartelera.nuevaPelicula(lista);
	}

	/**
	 * Devuelve una cadena de caracteres que contiene todos los datos de todas las
	 * películas con el siguiente formato: Título de la película Año: Genero:
	 * Director: Actores: Sinopsis:
	 * 
	 * @return Devuelve un String con las características descritas anteriormente.
	 */
	public void visualizarCartelera() {
		System.out.println("\n########## CARTELERA C1 ##########\n" + cartelera.mostrarCartelera());
	}

	/**
	 * Añade una sesión al listado de sesiones del cine asignándole la capacidad de
	 * la sala.
	 * 
	 * @param sesion - Nombre de la instancia de la clase sesión que se quiere
	 *               añadir.
	 */
	public void nuevaSesion(Sesion sesion) {
		sesion.setCapacidad(capacidad);
		sesiones.add(sesion);
	}

	/**
	 * Crea una nueva sesión y la añade al listado de sesiones del cine asignando la
	 * capacidad de la sala.
	 * 
	 * @param fecha    - Fecha en la que se programa la sesión.
	 * @param hora     - Hora en la que se programa la sesión.
	 * @param pelicula - Película que se proyecta.
	 */
	public void nuevaSesion(LocalDate fecha, LocalTime hora, Pelicula pelicula) {
		Sesion sesion = new Sesion(fecha, hora, pelicula);
		sesion.setCapacidad(capacidad);
		sesiones.add(sesion);
	}

	/**
	 * Muestra todas las sesiones programadas de una determinada película.
	 * 
	 * @param tituloBuscado - Es el título de la película de la que se quieren
	 *                      conocer las sesiones.
	 */
	public void mostrarSesiones(String tituloBuscado) {
		boolean _peliEncontrada = false;
		System.out.println("\nEstas son las sesiones programadas para la película " + tituloBuscado + ":\n");
		for (Sesion sesion : sesiones) {
			if (sesion.getPelicula().getTitulo().equals(tituloBuscado)) {
				System.out.println(sesion.mostrarSesion());
				_peliEncontrada = true;
			}
		}
		if (!_peliEncontrada) {
			System.out.println("No hay ninguna sesión programada.\n");
		}
	}

	/*
	 * { boolean _peliEncontrada =false; sesiones.forEach(sesion -> { if
	 * (sesion.getPelicula().getTitulo().equals(tituloBuscado)) {
	 * System.out.println(sesion.mostrarSesion()); _peliEncontrada = true; } else if
	 * (!_peliEncontrada) {
	 * System.out.println("No hay ninguna sesión programada para la película " +
	 * tituloBuscado); } }); }
	 */

	public void quitarSesion(String titulo, LocalDate fecha, LocalTime hora) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo)
				&& sesion.getFecha().equals(fecha) && sesion.getHora().equals(hora))) {
			System.out.println("Se ha eliminado la sesión de la película " + titulo + " el día " + fecha + " a las " + hora + "\n");
		} else {
			System.out.println(
					"No existe ninguna proyección de la película " + titulo + " el día " + fecha + " a las " + hora + "\n");
		};
	}
	
	public void quitarSesiones(String titulo) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo))) {
			System.out.println("Se han eliminado todas las sesiones de la película " + titulo + "\n");
		} else {
			System.out.println("No existe ninguna sesión de la película " + titulo + "\n");
		}
	};

}
