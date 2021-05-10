package paqueteCine;

/**
 * Una clase para representar una pel�cula en la cartelera del cine.
 * @version		05/05/2021
 * @author 		Rub�n Jim�nez Guti�rrez 05/05/2021
 */
public class Pelicula {
	private String titulo;
	private int anyo;
	private String director;
	private String actores;
	private String sinopsis;
	private TGenero genero;
	
	/**
	 * Crea una pel�cula incluyendo todos los datos relacionados con la misma.
	 * @param titulo 	- Nombre que identifica la pel�cula.
	 * @param anyo 		- A�o de estreno.
	 * @param director 	- Nombre de la persona que la dirige.
	 * @param actores 	- Nombre de las personas que act�an en la pel�cula.
	 * @param sinopsis  - Breve resumen del argumento.
	 * @param genero	- Tem�tica general de la pel�cula. Est� limitado a los g�neros ACCION, DRAMA o COMEDIA contenidos en un enumerador.
	 */
	public Pelicula (String titulo, int anyo, String director, String actores, String sinopsis, TGenero genero) {
		this.titulo = titulo;
		this.anyo = anyo;
		this.director = director;
		this.actores = actores;
		this.sinopsis = sinopsis;
		this.genero = genero;
	}
	
	/**
	 * Crea una pel�cula sin ning�n dato asociado. Los datos se pueden a�adir posteriormente usando los m�todos de la clase.
	 */
	public Pelicula() {
	}
	
	/**
	 * Crea una pel�cula �nicamente con su t�tulo.
	 * @param titulo 	- Nombre que identifica la pel�cula.
	 */
	public Pelicula(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return Devuelve el t�tulo de la pel�cula.
	 */
	public String getTitulo()
	{
		return titulo;
	}
	
	/**
	 * Cambia el t�tulo de la pel�cula.
	 * @param titulo 	- Nombre que identifica la pel�cula.
	 */
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	/**
	 *  @return Devuelve el a�o de estreno.
	 */
	public int getAnyo()
	{
		return anyo;
	}
	
	/**
	 * Cambia el a�o de estreno.
	 * @param anyo 		- A�o de estreno.
	 */
	public void setAnyo(int anyo)
	{
		this.anyo = anyo;
	}
	
	/**
	 * @return Devuelve el director de la pel�cula.
	 */
	public String getDirector()
	{
		return director;
	}
	
	/**
	 * Cambia el director de la pel�cula, 
	 * @param director 	- Nombre de la persona que la dirige.
	 */
	public void setDirector(String director)
	{
		this.director = director;
	}
	
	/**
	 * @return Devuelve los actores de la pel�cula.
	 */
	public String getActores()
	{
		return actores;
	}
	
	/**
	 * Cambia los actores de la pel�cula. 
	 * @param actores 	- Nombre de las personas que act�an en la pel�cula.
	 */
	public void setActores(String actores)
	{
		this.actores = actores;
	}
	
	/**
	 * @return Devuelve la sinopsis de la pel�cula.
	 */
	public String getSinopsis()
	{
		return sinopsis;
	}
	
	/**
	 * Cambia la sinopsis de la pel�cula. 
	 * @param sinopsis  - Breve resumen del argumento.
	 */
	public void setSinopsis(String sinopsis)
	{
		this.sinopsis = sinopsis;
	}
	
	/**
	 * @return Devuelve el genero de la pel�cula.
	 */
	public TGenero getGenero()
	{
		return genero;
	}
	
	/**
	 * Cambia el genero de la pel�cula. 
	 * @param genero	- Tem�tica general de la pel�cula. Est� limitado a los g�neros ACCION, DRAMA o COMEDIA contenidos en un enumerador.
	 */
	public void setGenero(TGenero genero)
	{
		this.genero = genero;
	}
	
	/**
	 * Devuelve una cadena de caracteres que lista todos los datos de la pel�cula con el siguiente formato:
	 * T�tulo de la pel�cula
	 *		A�o:
	 * 		Genero: 
	 * 		Director:
	 * 		Actores:
	 * 		Sinopsis:
	 * @return Devuelve un String con las caracter�sticas descritas anteriormente.
	 */
	public String mostrarPelicula()
	{
		return titulo+"\n"
				+ "\tA�o: "+anyo+
				"\n\tGenero: " + genero+
				"\n\tDirector: "+director+
				"\n\tActores: "+actores+
				"\n\tSinopsis: "+sinopsis+
				"\n";
	}
	
	/**
	 * Imprime los datos de la pel�cula.
	 */
	public void printPelicula()
	{
		System.out.println(mostrarPelicula());
	}
			
}
