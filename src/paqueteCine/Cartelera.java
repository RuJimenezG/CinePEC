package paqueteCine;

import java.util.ArrayList;
import java.util.List;

/**
 * Una clase para representar el conjunto de las películas que proyecta el cine.
 * Se trata de un listado de objetos de la clase Película.
 * @version 	09/05/2021
 * @author 		Rubén Jiménez Gutiérrez
 */
public class Cartelera {
	private ArrayList <Pelicula> peliculas;

	/**
	 * Crea una cartelera vacía. Es decir, un listado vacío para añadir películas.
	 */
	public Cartelera() {
		peliculas = new ArrayList<Pelicula>();
		}
	
	/**
	 * Crea una cartelera a partir de una película individual.
	 * Posteriormente se podrán seguir añadiendo más instancias de la clase Pelicula.
	 * @param pelicula	- Nombre de la instancia de la clase Pelicula que se quiere añadir al crear la cartelera.
	 */
	public Cartelera (Pelicula pelicula) {
		peliculas = new ArrayList<Pelicula>();
		peliculas.add(pelicula);
	}
	
	/**
	 * Crea una cartelera a partir de un listado existente de películas.
	 * Posteriormente se podrán seguir añadiendo más instancias de la clase Pelicula.
	 * @param lista	- Nombre de la instancia de tipo lista que contiene las películas.
	 */
	public Cartelera(List<Pelicula> lista) {
		peliculas = new ArrayList<Pelicula>();
		peliculas.addAll(lista);
	}

	/**
	 * Comprueba si ya existe en la cartelera una película con el título indicado.
	 * @param titulo 	- Nombre que identifica la película.
	 * @return Devuelve true si la película buscada está en la cartelera. Si no devuelve false.
	 */
	public boolean estaPelicula (String titulo) {
		boolean _encontrada = false;
		if (peliculas.stream()
		.map(pelicula -> pelicula.getTitulo())
		.anyMatch(t -> t.equals(titulo))==true) {
			_encontrada = true;
		}
		return _encontrada;
	}
	
	/**
	 * Comprueba si ya existe en la cartelera una película con el título indicado.
	 * @param pelicula - Nombre de la instancia de la clase película que se quiere buscar.
	 * @return Devuelve true si la película buscada está en la cartelera. Si no devuelve false.
	 */
	public boolean estaPelicula (Pelicula pelicula) {
		if (peliculas.contains(pelicula)) {
			return true;
		} else return false;
	}
	
	/**
	 * Añade nuevas películas a la cartelera a partir de un listado preexistente.
	 * Para cada película del listado se comprueba primero si dicha película no está ya en el listado.
	 * De ser así se añade.
	 * @param lista		- Nombre de la instancia del objeto lista que contiene las películas que se quieren añadir.
	 * @return Devuelve el valor true si alguna de las películas añadidas no estaba ya en la cartelera.
	 * En caso contrario devuelve false.
	 */
	public boolean nuevaPelicula(List<Pelicula> lista) {
		boolean _algunaPeliNueva = false;
		for (Pelicula pelicula : lista) {
			if (!estaPelicula(pelicula)) {
				peliculas.add(pelicula);
				_algunaPeliNueva = true;
				System.out.println("La película " + pelicula.getTitulo() + " se ha añadido a la cartelera.");
			} else {
				System.out.println("No se ha podido añadir la película " + pelicula.getTitulo() + " porque ya está en la cartelera.");
			}
		}
		return _algunaPeliNueva;
	}
	
	/**
	 * Añade una nueva película a la cartelera.
	 * Primero comprueba que la película que se quiere añadir no está ya en el listado y de ser así la añade.
	 * @param pelicula	- Nombre de instancia del objeto película que se quiere añadir. No tiene por qué coincidir con el título.
	 * @return Devuelve el valor true si la película que se ha añadido no estaba ya en la cartelera.
	 * En caso contrario devuelve false.
	 */
	public boolean nuevaPelicula(Pelicula pelicula) {
		if (!estaPelicula(pelicula)) {
			peliculas.add(pelicula);
			System.out.println("La película " + pelicula.getTitulo() + " se ha añadido a la cartelera.");
			return true;
		} else {
			System.out.println("No se ha podido añadir la película " + pelicula.getTitulo() + " porque ya está en la cartelera.");
			return false;
		}
	}
	
	/**
	 * Elimina de la cartelera la película con el título indicado.
	 * @param titulo	- Título de la película que se quiere eliminar.
	 * @return Devuelve el valor true si la película se encontraba en la cartelera y ha sido eliminada.
	 * En caso contrario devuelve false.
	 */
	public boolean eliminarPelicula (String titulo) {
		if (estaPelicula(titulo)) {
			peliculas.removeIf(pelicula -> pelicula.getTitulo().equals(titulo));
		}
		return estaPelicula(titulo);
	}
	
	/**
	 * Devuelve una cadena de caracteres que contiene todos los datos de todas las películas con el siguiente formato:
	 * Título de la película
	 *		Año:
	 * 		Genero: 
	 * 		Director:
	 * 		Actores:
	 * 		Sinopsis:
	 * @return Devuelve un String con las características descritas anteriormente.
	 */
	public String mostrarCartelera() {
		String _cartelera = "";
		for (Pelicula pelicula : peliculas) {
			_cartelera = _cartelera + pelicula.mostrarPelicula() + "\n";
		}
		/*peliculas.forEach(pelicula -> {
			String _cartelera; 
			_cartelera = _cartelera + pelicula.mostrarPelicula();
			});*/
		return _cartelera;
	}
	


	
}