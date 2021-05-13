package paqueteCine;

/**
 * Una clase para representar una película en versión original. Hereda todos sus
 * campos de la clase Pelicula excepto el idioma.
 * 
 * @version 13/05/2021
 * @author Rubén Jiménez Gutiérrez
 */
public class PeliculaVO extends Pelicula {
	private TIdioma idioma;

	/**
	 * Crea una película nueva en versión original. Hereda todos sus campos de la
	 * clase peícula excepto el idioma, que se puede definir con el método
	 * setIdioma().
	 */
	public PeliculaVO() {
		super();
	}

	/**
	 * Modifica la información sobre el idioma en el que se proyecta la película.
	 * 
	 * @param idioma - Idioma en que se proyecta la película.
	 */
	public void setIdioma(TIdioma idioma) {
		this.idioma = idioma;
	}

	/**
	 * Devuelve una cadena de caracteres que lista todos los datos de la película
	 * con el siguiente formato: Título de la película Año: Genero: Director:
	 * Actores: Sinopsis: Idioma:
	 * 
	 * @return Devuelve un String con las características descritas anteriormente.
	 */
	@Override
	public String mostrarPelicula() {
		return titulo + "\n" + "\tAño: " + anyo + "\n\tGenero: " + genero + "\n\tDirector: " + director
				+ "\n\tActores: " + actores + "\n\tSinopsis: " + sinopsis + "\n\tIdioma: " + idioma + "\n";
	}
}
