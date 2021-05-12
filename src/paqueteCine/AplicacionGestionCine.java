package paqueteCine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase que permite realizar la gesti�n del cine.
 * 
 * @version 11/05/2021
 * @author Rub�n Jim�nez Guti�rrez
 */
public class AplicacionGestionCine {
	private String nombreCine;
	private String direccion;
	private Cartelera cartelera;
	private ArrayList<Sesion> sesiones;
	private int capacidad;

	/**
	 * Crea una instancia de la aplicaci�n que gestiona el cine.
	 * 
	 * @param nombreCine - Nombre del cine.
	 * @param direccion  - Direcci�n del cine.
	 * @param capacidad  - N�mero m�ximo de butacas de las que dispone la sala de
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
	 * @return Devuelve la capacidad de la sala, es decir el n�mero de butacas de
	 *         que dispone.
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * A�ade una pel�cula a la cartelera del cine.
	 * 
	 * @param pelicula - Es el nombre de la instancia de la clase pel�cula que se
	 *                 quiere a�adir.
	 * @return Devuelve true cuando se ha a�adido la pel�cula a la cartelera.
	 */
	public boolean nuevaPelicula(Pelicula pelicula) {
		return cartelera.nuevaPelicula(pelicula);
	}

	/**
	 * A�ade nuevas pel�culas a la cartelera del cine a partir de un listado
	 * preexistente. Para cada pel�cula del listado se comprueba primero si dicha
	 * pel�cula no est� ya en el listado. De ser as� se a�ade.
	 * 
	 * @param lista Nombre de la instancia del objeto lista que contiene las
	 *              pel�culas a a�adir.
	 * @return Devuelve true cuando se ha a�adido alguna pel�cula.
	 */
	public boolean nuevaPelicula(List<Pelicula> lista) {
		return cartelera.nuevaPelicula(lista);
	}

	/**
	 * Devuelve una cadena de caracteres que contiene todos los datos de todas las
	 * pel�culas con el siguiente formato: T�tulo de la pel�cula A�o: Genero:
	 * Director: Actores: Sinopsis:
	 * 
	 * @return Devuelve un String con las caracter�sticas descritas anteriormente.
	 */
	public void visualizarCartelera() {
		System.out.println("\n########## CARTELERA C1 ##########\n" + cartelera.mostrarCartelera());
	}

	/**
	 * A�ade una sesi�n al listado de sesiones del cine asign�ndole la capacidad de
	 * la sala.
	 * 
	 * @param sesion - Nombre de la instancia de la clase sesi�n que se quiere
	 *               a�adir.
	 */
	public void nuevaSesion(Sesion sesion) {
		sesion.setCapacidad(capacidad);
		sesiones.add(sesion);
	}

	/**
	 * Crea una nueva sesi�n y la a�ade al listado de sesiones del cine asignando la
	 * capacidad de la sala.
	 * 
	 * @param fecha    - Fecha en la que se programa la sesi�n.
	 * @param hora     - Hora en la que se programa la sesi�n.
	 * @param pelicula - Pel�cula que se proyecta.
	 */
	public void nuevaSesion(LocalDate fecha, LocalTime hora, Pelicula pelicula) {
		Sesion sesion = new Sesion(fecha, hora, pelicula);
		sesion.setCapacidad(capacidad);
		sesiones.add(sesion);
	}

	/**
	 * Muestra todas las sesiones programadas de una determinada pel�cula.
	 * 
	 * @param tituloBuscado - Es el t�tulo de la pel�cula de la que se quieren
	 *                      conocer las sesiones.
	 */
	public void mostrarSesiones(String tituloBuscado) {
		boolean _peliEncontrada = false;
		System.out.println("\nEstas son las sesiones programadas para la pel�cula " + tituloBuscado + ":\n");
		for (Sesion sesion : sesiones) {
			if (sesion.getPelicula().getTitulo().equals(tituloBuscado)) {
				System.out.println(sesion.mostrarSesion());
				_peliEncontrada = true;
			}
		}
		if (!_peliEncontrada) {
			System.out.println("No hay ninguna sesi�n programada.\n");
		}
	}

	/*
	 * { boolean _peliEncontrada =false; sesiones.forEach(sesion -> { if
	 * (sesion.getPelicula().getTitulo().equals(tituloBuscado)) {
	 * System.out.println(sesion.mostrarSesion()); _peliEncontrada = true; } else if
	 * (!_peliEncontrada) {
	 * System.out.println("No hay ninguna sesi�n programada para la pel�cula " +
	 * tituloBuscado); } }); }
	 */

	public void quitarSesion(String titulo, LocalDate fecha, LocalTime hora) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo)
				&& sesion.getFecha().equals(fecha) && sesion.getHora().equals(hora))) {
			System.out.println("Se ha eliminado la sesi�n de la pel�cula " + titulo + " el d�a " + fecha + " a las " + hora + "\n");
		} else {
			System.out.println(
					"No existe ninguna proyecci�n de la pel�cula " + titulo + " el d�a " + fecha + " a las " + hora + "\n");
		};
	}
	
	public void quitarSesiones(String titulo) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo))) {
			System.out.println("Se han eliminado todas las sesiones de la pel�cula " + titulo + "\n");
		} else {
			System.out.println("No existe ninguna sesi�n de la pel�cula " + titulo + "\n");
		}
	};

}
