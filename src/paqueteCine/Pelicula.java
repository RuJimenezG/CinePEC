package paqueteCine;

/**
 * Una clase para representar una película en la cartelera del cine.
 * 
 * @version 05/05/2021
 * @author Rubén Jiménez Gutiérrez 05/05/2021
 */
public class Pelicula {
	protected String titulo;
	protected int anyo;
	protected String director;
	protected String actores;
	protected String sinopsis;
	protected TGenero genero;

	/**
	 * Crea una película incluyendo todos los datos relacionados con la misma.
	 * 
	 * @param titulo   - Nombre que identifica la película.
	 * @param anyo     - Año de estreno.
	 * @param director - Nombre de la persona que la dirige.
	 * @param actores  - Nombre de las personas que actúan en la película.
	 * @param sinopsis - Breve resumen del argumento.
	 * @param genero   - Temática general de la película. Está limitado a los
	 *                 géneros ACCION, DRAMA o COMEDIA contenidos en un enumerador.
	 */
	public Pelicula(String titulo, int anyo, String director, String actores, String sinopsis, TGenero genero) {
		this.titulo = titulo;
		this.anyo = anyo;
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.genero = genero;
	}

	/**
	 * Crea una película sin ningún dato asociado. Los datos se pueden añadir
	 * posteriormente usando los métodos de la clase.
	 */
	public Pelicula() {
	}

	/**
	 * Crea una película únicamente con su título.
	 * 
	 * @param titulo - Nombre que identifica la película.
	 */
	public Pelicula(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return Devuelve el título de la película.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Cambia el título de la película.
	 * 
	 * @param titulo - Nombre que identifica la película.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return Devuelve el año de estreno.
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * Cambia el año de estreno.
	 * 
	 * @param anyo - Año de estreno.
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * @return Devuelve el director de la película.
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * Cambia el director de la película,
	 * 
	 * @param director - Nombre de la persona que dirige la película.
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	/**
	 * @return Devuelve los actores de la película.
	 */
	public String getActores() {
		return actores;
	}

	/**
	 * Cambia los actores de la película.
	 * 
	 * @param actores - Nombre de las personas que actúan en la película.
	 */
	public void setActores(String actores) {
		this.actores = actores;
	}

	/**
	 * @return Devuelve la sinopsis de la película.
	 */
	public String getSinopsis() {
		return sinopsis;
	}

	/**
	 * Cambia la sinopsis de la película.
	 * 
	 * @param sinopsis - Breve resumen del argumento.
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	/**
	 * @return Devuelve el genero de la película.
	 */
	public TGenero getGenero() {
		return genero;
	}

	/**
	 * Cambia el genero de la película.
	 * 
	 * @param genero - Temática general de la película. Está limitado a los géneros
	 *               ACCION, DRAMA o COMEDIA contenidos en un enumerador.
	 */
	public void setGenero(TGenero genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve una cadena de caracteres que lista todos los datos de la película
	 * con el siguiente formato: Título de la película Año: Genero: Director:
	 * Actores: Sinopsis:
	 * 
	 * @return Devuelve un String con las características descritas anteriormente.
	 */
	public String mostrarPelicula() {
		return titulo + "\n" + "\tAño: " + anyo + "\n\tGenero: " + genero + "\n\tDirector: " + director
				+ "\n\tActores: " + actores + "\n\tSinopsis: " + sinopsis + "\n";
	}

	/**
	 * Imprime los datos de la película.
	 */
	public void printPelicula() {
		System.out.println(mostrarPelicula());
	}

	/**
	 * Comprueba si dos películas son la misma. Se considera que si dos películas
	 * tienen el mismo título, entonces son la misma película.<br>
	 * <b>Sobreescribe</b> el metodo equals de la clase Object.
	 * 
	 * @param peliculaComparar - Nombre de la instancia de la clase película que se
	 *                         quiere comparar con otra.
	 * @return Devuelve true en caso de que las películas compartan título y false
	 *         en caso contrario.
	 */
	public boolean equals(Pelicula peliculaComparar) {
		if (this.titulo.equals(peliculaComparar.getTitulo())) {
			return true;
		} else
			return false;
	}
}
