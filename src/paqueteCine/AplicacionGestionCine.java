package paqueteCine;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Una clase que permite realizar la gestión del cine. Puede contener una
 * cartelera y un listado de sesiones. Tiene una capacidad fija que se define al
 * crear la instancia.
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
	 * Añade una película a la cartelera del cine.
	 * 
	 * @param pelicula - Es la instancia de la clase película que se quiere añadir.
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
	 * @param lista Instancia del objeto lista que contiene las películas a añadir.
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
	 */
	public void visualizarCartelera() {
		System.out.println("\n########## CARTELERA C1 ##########\n\n" + cartelera.mostrarCartelera());
	}

	/**
	 * Añade una sesión al listado de sesiones del cine asignándole la capacidad de
	 * la sala.
	 * 
	 * @param sesion - Nombre de la instancia de la clase sesión que se quiere
	 *               añadir.
	 */
	public void nuevaSesion(Sesion sesion) {
		if (sesiones.contains(sesion)) {
			System.out.println("Esta sesión ya existe y no se ha podido crear.");
		} else if (cartelera.estaPelicula(sesion.getPelicula())) {
			sesion.setCapacidad(capacidad);
			sesiones.add(sesion);
			System.out.println("Se ha creado una nueva sesión con una capacidad de " + capacidad + " butacas.");
		} else {
			System.out.println("La película " + sesion.getPelicula().getTitulo() + " no se encuentra en la cartelera.");
			System.out.println("Por favor, añada la película a la cartelera y después cree la sesión.");
		}
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
		if (sesiones.stream().map(sesion -> sesion.getFecha()).anyMatch(f -> f.equals(fecha))
				&& sesiones.stream().map(sesion -> sesion.getHora()).anyMatch(f -> f.equals(hora))) {
			System.out.println("No se puede cear la sesión. Ya existe una proyección programada el día " + fecha
					+ " a las " + hora + ".\n");
		} else if (cartelera.estaPelicula(pelicula)) {
			Sesion sesion = new Sesion(fecha, hora, pelicula);
			sesion.setCapacidad(capacidad);
			sesiones.add(sesion);
			System.out.println("Se ha creado la siguiente sesión:\n");
			System.out.println(sesion.mostrarSesion());
		} else {
			System.out.println("No se ha podido crear la sesión.");
			System.out.println("La película " + pelicula.getTitulo() + " no se encuentra en la cartelera.");
			System.out.println("Por favor, añada la película a la cartelera y después cree la sesión.");
		}
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

	/**
	 * Elimina una sesión a una fecha y hora determinadas de una película según su
	 * título.
	 * 
	 * @param titulo - Nombre que identifica a la película.
	 * @param fecha  - Fecha a la que está programada la sesión que se quiere
	 *               elminar.
	 * @param hora   - Hora a la que está programada la sesión que se quiere
	 *               eliminar.
	 * @return Devuelve verdadero si se ha podido eliminar la sesión y falso en caso
	 *         contrario.
	 */
	public boolean quitarSesion(String titulo, LocalDate fecha, LocalTime hora) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo)
				&& sesion.getFecha().equals(fecha) && sesion.getHora().equals(hora))) {
			System.out.println("Se ha eliminado la sesión de la película " + titulo + " el día " + fecha + " a las "
					+ hora + "\n");
			return true;
		} else {
			System.out.println("No existe ninguna proyección de la película " + titulo + " el día " + fecha + " a las "
					+ hora + "\n");
			return false;
		}
	}

	/**
	 * Elimina todas las sesiones de una película determinada.
	 * 
	 * @param titulo - Nombre de la película de la que se desean eliminar las
	 *               sesiones.
	 * @return Devuelve verdadero si se eliminan las sesiones y falso en caso
	 *         contrario.
	 */
	public boolean quitarSesiones(String titulo) {
		if (sesiones.removeIf(sesion -> sesion.getPelicula().getTitulo().equals(titulo))) {
			System.out.println("Se han eliminado todas las sesiones de la película " + titulo + ".\n");
			return true;
		} else {
			System.out.println("No existe ninguna sesión de la película " + titulo + ".\n");
			return false;
		}
	};

	/**
	 * Elimina una película de la cartelera del cine. Además elimina todas las
	 * sesiones de esta película.
	 * 
	 * @param titulo - Nombre de la película que se quiere eliminar.
	 * @return Devuelve verdadero si se elimina la película y falso en caso
	 *         contrario.
	 */
	public boolean eliminarPelicula(String titulo) {
		if (cartelera.estaPelicula(titulo)) {
			cartelera.eliminarPelicula(titulo);
			System.out.println("Se ha eliminado de la cartelera la película " + titulo + ".");
			quitarSesiones(titulo);
			return (cartelera.eliminarPelicula(titulo));
		} else {
			System.out.println("No existe en la cartelera la película " + titulo + ".\n");
			return cartelera.eliminarPelicula(titulo);
		}
	}

	/**
	 * Permite descontar un número de entradas de la sesión elegida.
	 * @param cantidad - Número de entradas que se descuentan.
	 * @param titulo - Título de la película a la que pertenece la sesión de la que se quieren comprar entradas.
	 * @param fecha - Fecha a la que está programada la sesión de la que se quieren comprar entradas.
	 * @param hora - Hora a la que está programada la sesión de la que se quieren comprar entradas.
	 */
	public void comprarEntradas(int cantidad, String titulo, LocalDate fecha, LocalTime hora) {
		boolean _encontrada = false;
		for (Sesion sesion : sesiones) {
			if (sesion.getPelicula().getTitulo().equals(titulo) && sesion.getFecha().equals(fecha)
					&& sesion.getHora().equals(hora)) {
				_encontrada = true;
				if (sesion.reducirDisponibilidad(cantidad)) {
					System.out.println("Se han vendido " + cantidad + " entradas de la sesión:\n");
					System.out.println("Pelicula: " + titulo + "\n\tFecha: " + fecha + "\tHora: " + hora);
				}
			}
		}
		if (!_encontrada) {
			System.out.println(
					"No existe una sesión de la película " + titulo + " el día " + fecha + " a las " + hora + "\n");
		}
	}
}
