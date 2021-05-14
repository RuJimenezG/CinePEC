package paqueteCine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase que permite realizar la gesti�n del cine. Puede contener una
 * cartelera y un listado de sesiones. Tiene una capacidad fija que se define al
 * crear la instancia.
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
	 * A�ade una pel�cula a la cartelera del cine.
	 * 
	 * @param pelicula - Es la instancia de la clase pel�cula que se quiere a�adir.
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
	 * @param lista Instancia del objeto lista que contiene las pel�culas a a�adir.
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
	 */
	public void visualizarCartelera() {
		System.out.println("\n########## CARTELERA C1 ##########\n\n" + cartelera.mostrarCartelera());
	}

	/**
	 * A�ade una sesi�n al listado de sesiones del cine asign�ndole la capacidad de
	 * la sala.
	 * 
	 * @param sesion - Nombre de la instancia de la clase sesi�n que se quiere
	 *               a�adir.
	 */
	public void nuevaSesion(Sesion sesion) {
		if (sesiones.contains(sesion)) {
			System.out.println("Esta sesi�n ya existe y no se ha podido crear.");
		} else if (cartelera.estaPelicula(sesion.getPelicula())) {
			sesion.setCapacidad(capacidad);
			sesiones.add(sesion);
			System.out.println("Se ha creado una nueva sesi�n con una capacidad de " + capacidad + " butacas.");
		} else {
			System.out.println("La pel�cula " + sesion.getPelicula().getTitulo() + " no se encuentra en la cartelera.");
			System.out.println("Por favor, a�ada la pel�cula a la cartelera y despu�s cree la sesi�n.");
		}
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
		if (sesiones.stream().map(sesion -> sesion.getFecha()).anyMatch(f -> f.equals(fecha))
				&& sesiones.stream().map(sesion -> sesion.getHora()).anyMatch(f -> f.equals(hora))) {
			System.out.println("No se puede cear la sesi�n. Ya existe una proyecci�n programada el d�a " + fecha
					+ " a las " + hora + ".\n");
		} else if (cartelera.estaPelicula(pelicula)) {
			Sesion sesion = new Sesion(fecha, hora, pelicula);
			sesion.setCapacidad(capacidad);
			sesiones.add(sesion);
			System.out.println("Se ha creado la siguiente sesi�n:\n");
			System.out.println(sesion.mostrarSesion());
		} else {
			System.out.println("No se ha podido crear la sesi�n.");
			System.out.println("La pel�cula " + pelicula.getTitulo() + " no se encuentra en la cartelera.");
			System.out.println("Por favor, a�ada la pel�cula a la cartelera y despu�s cree la sesi�n.");
		}
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

	/**
	 * Elimina una sesi�n a una fecha y hora determinadas de una pel�cula seg�n su
	 * t�tulo.
	 * 
	 * @param titulo - Nombre que identifica a la pel�cula.
	 * @param fecha  - Fecha a la que est� programada la sesi�n que se quiere
	 *               elminar.
	 * @param hora   - Hora a la que est� programada la sesi�n que se quiere
	 *               eliminar.
	 * @return Devuelve verdadero si se ha podido eliminar la sesi�n y falso en caso
	 *         contrario.
	 */
	public boolean quitarSesion(String titulo, LocalDate fecha, LocalTime hora) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo)
				&& sesion.getFecha().equals(fecha) && sesion.getHora().equals(hora))) {
			System.out.println("Se ha eliminado la sesi�n de la pel�cula " + titulo + " el d�a " + fecha + " a las "
					+ hora + "\n");
			return true;
		} else {
			System.out.println("No existe ninguna proyecci�n de la pel�cula " + titulo + " el d�a " + fecha + " a las "
					+ hora + "\n");
			return false;
		}
	}

	/**
	 * Elimina todas las sesiones de una pel�cula determinada.
	 * 
	 * @param titulo - Nombre de la pel�cula de la que se desean eliminar las
	 *               sesiones.
	 * @return Devuelve verdadero si se eliminan las sesiones y falso en caso
	 *         contrario.
	 */
	public boolean quitarSesiones(String titulo) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo))) {
			System.out.println("Se han eliminado todas las sesiones de la pel�cula " + titulo + ".\n");
			return true;
		} else {
			System.out.println("No existe ninguna sesi�n de la pel�cula " + titulo + ".\n");
			return false;
		}
	};

	/**
	 * Elimina una pel�cula de la cartelera del cine. Adem�s elimina todas las
	 * sesiones de esta pel�cula.
	 * 
	 * @param titulo - Nombre de la pel�cula que se quiere eliminar.
	 * @return Devuelve verdadero si se elimina la pel�cula y falso en caso
	 *         contrario.
	 */
	public boolean eliminarPelicula(String titulo) {
		if (cartelera.estaPelicula(titulo)) {
			cartelera.eliminarPelicula(titulo);
			System.out.println("Se ha eliminado de la cartelera la pel�cula " + titulo + ".");
			quitarSesiones(titulo);
			return (cartelera.eliminarPelicula(titulo));
		} else {
			System.out.println("No existe en la cartelera la pel�cula " + titulo + ".\n");
			return cartelera.eliminarPelicula(titulo);
		}
	}

	/**
	 * Permite descontar un n�mero de entradas de la sesi�n elegida.
	 * @param cantidad - N�mero de entradas que se descuentan.
	 * @param titulo - T�tulo de la pel�cula a la que pertenece la sesi�n de la que se quieren comprar entradas.
	 * @param fecha - Fecha a la que est� programada la sesi�n de la que se quieren comprar entradas.
	 * @param hora - Hora a la que est� programada la sesi�n de la que se quieren comprar entradas.
	 */
	public void comprarEntradas(int cantidad, String titulo, LocalDate fecha, LocalTime hora) {
		boolean _encontrada = false;
		for (Sesion sesion : sesiones) {
			if (sesion.getPelicula().getTitulo().equals(titulo) && sesion.getFecha().equals(fecha)
					&& sesion.getHora().equals(hora)) {
				_encontrada = true;
				if (sesion.reducirDisponibilidad(cantidad)) {
					System.out.println("Se han vendido " + cantidad + " entradas de la sesi�n:\n");
					System.out.println("Pelicula: " + titulo + "\n\tFecha: " + fecha + "\tHora: " + hora);
				}
			}
		}
		if (!_encontrada) {
			System.out.println(
					"No existe una sesi�n de la pel�cula " + titulo + " el d�a " + fecha + " a las " + hora + "\n");
		}
	}
}
