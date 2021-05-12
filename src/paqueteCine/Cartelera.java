package paqueteCine;

import java.util.ArrayList;
import java.util.List;

/**
 * Una clase para representar el conjunto de las pel�culas que proyecta el cine.
 * Se trata de un listado de objetos de la clase Pel�cula.
 * @version 	09/05/2021
 * @author 		Rub�n Jim�nez Guti�rrez
 */
public class Cartelera {
	private ArrayList <Pelicula> peliculas;

	/**
	 * Crea una cartelera vac�a. Es decir, un listado vac�o para a�adir pel�culas.
	 */
	public Cartelera() {
		peliculas = new ArrayList<Pelicula>();
		}
	
	/**
	 * Crea una cartelera a partir de una pel�cula individual.
	 * Posteriormente se podr�n seguir a�adiendo m�s instancias de la clase Pelicula.
	 * @param pelicula	- Nombre de la instancia de la clase Pelicula que se quiere a�adir al crear la cartelera.
	 */
	public Cartelera (Pelicula pelicula) {
		peliculas = new ArrayList<Pelicula>();
		peliculas.add(pelicula);
	}
	
	/**
	 * Crea una cartelera a partir de un listado existente de pel�culas.
	 * Posteriormente se podr�n seguir a�adiendo m�s instancias de la clase Pelicula.
	 * @param lista	- Nombre de la instancia de tipo lista que contiene las pel�culas.
	 */
	public Cartelera(List<Pelicula> lista) {
		peliculas = new ArrayList<Pelicula>();
		peliculas.addAll(lista);
	}

	/**
	 * Comprueba si ya existe en la cartelera una pel�cula con el t�tulo indicado.
	 * @param titulo 	- Nombre que identifica la pel�cula.
	 * @return Devuelve true si la pel�cula buscada est� en la cartelera. Si no devuelve false.
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
	 * Comprueba si ya existe en la cartelera una pel�cula con el t�tulo indicado.
	 * @param pelicula - Nombre de la instancia de la clase pel�cula que se quiere buscar.
	 * @return Devuelve true si la pel�cula buscada est� en la cartelera. Si no devuelve false.
	 */
	public boolean estaPelicula (Pelicula pelicula) {
		if (peliculas.contains(pelicula)) {
			return true;
		} else return false;
	}
	
	/**
	 * A�ade nuevas pel�culas a la cartelera a partir de un listado preexistente.
	 * Para cada pel�cula del listado se comprueba primero si dicha pel�cula no est� ya en el listado.
	 * De ser as� se a�ade.
	 * @param lista		- Nombre de la instancia del objeto lista que contiene las pel�culas que se quieren a�adir.
	 * @return Devuelve el valor true si alguna de las pel�culas a�adidas no estaba ya en la cartelera.
	 * En caso contrario devuelve false.
	 */
	public boolean nuevaPelicula(List<Pelicula> lista) {
		boolean _algunaPeliNueva = false;
		for (Pelicula pelicula : lista) {
			if (!estaPelicula(pelicula)) {
				peliculas.add(pelicula);
				_algunaPeliNueva = true;
				System.out.println("La pel�cula " + pelicula.getTitulo() + " se ha a�adido a la cartelera.");
			} else {
				System.out.println("No se ha podido a�adir la pel�cula " + pelicula.getTitulo() + " porque ya est� en la cartelera.");
			}
		}
		return _algunaPeliNueva;
	}
	
	/**
	 * A�ade una nueva pel�cula a la cartelera.
	 * Primero comprueba que la pel�cula que se quiere a�adir no est� ya en el listado y de ser as� la a�ade.
	 * @param pelicula	- Nombre de instancia del objeto pel�cula que se quiere a�adir. No tiene por qu� coincidir con el t�tulo.
	 * @return Devuelve el valor true si la pel�cula que se ha a�adido no estaba ya en la cartelera.
	 * En caso contrario devuelve false.
	 */
	public boolean nuevaPelicula(Pelicula pelicula) {
		if (!estaPelicula(pelicula)) {
			peliculas.add(pelicula);
			System.out.println("La pel�cula " + pelicula.getTitulo() + " se ha a�adido a la cartelera.");
			return true;
		} else {
			System.out.println("No se ha podido a�adir la pel�cula " + pelicula.getTitulo() + " porque ya est� en la cartelera.");
			return false;
		}
	}
	
	/**
	 * Elimina de la cartelera la pel�cula con el t�tulo indicado.
	 * @param titulo	- T�tulo de la pel�cula que se quiere eliminar.
	 * @return Devuelve el valor true si la pel�cula se encontraba en la cartelera y ha sido eliminada.
	 * En caso contrario devuelve false.
	 */
	public boolean eliminarPelicula (String titulo) {
		if (estaPelicula(titulo)) {
			peliculas.removeIf(pelicula -> pelicula.getTitulo().equals(titulo));
		}
		return estaPelicula(titulo);
	}
	
	/**
	 * Devuelve una cadena de caracteres que contiene todos los datos de todas las pel�culas con el siguiente formato:
	 * T�tulo de la pel�cula
	 *		A�o:
	 * 		Genero: 
	 * 		Director:
	 * 		Actores:
	 * 		Sinopsis:
	 * @return Devuelve un String con las caracter�sticas descritas anteriormente.
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