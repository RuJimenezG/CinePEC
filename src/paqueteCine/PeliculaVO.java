package paqueteCine;

/**
 * Una clase para representar una pel�cula en versi�n original. Hereda todos sus
 * campos de la clase Pelicula excepto el idioma.
 * 
 * @version 13/05/2021
 * @author Rub�n Jim�nez Guti�rrez
 */
public class PeliculaVO extends Pelicula {
	private TIdioma idioma;

	/**
	 * Crea una pel�cula nueva en versi�n original. Hereda todos sus campos de la
	 * clase pe�cula excepto el idioma, que se puede definir con el m�todo
	 * setIdioma().
	 */
	public PeliculaVO() {
		super();
	}

	/**
	 * Modifica la informaci�n sobre el idioma en el que se proyecta la pel�cula.
	 * 
	 * @param idioma - Idioma en que se proyecta la pel�cula.
	 */
	public void setIdioma(TIdioma idioma) {
		this.idioma = idioma;
	}

	/**
	 * Devuelve una cadena de caracteres que lista todos los datos de la pel�cula
	 * con el siguiente formato: T�tulo de la pel�cula A�o: Genero: Director:
	 * Actores: Sinopsis: Idioma:
	 * 
	 * @return Devuelve un String con las caracter�sticas descritas anteriormente.
	 */
	@Override
	public String mostrarPelicula() {
		return titulo + "\n" + "\tA�o: " + anyo + "\n\tGenero: " + genero + "\n\tDirector: " + director
				+ "\n\tActores: " + actores + "\n\tSinopsis: " + sinopsis + "\n\tIdioma: " + idioma + "\n";
	}
}
