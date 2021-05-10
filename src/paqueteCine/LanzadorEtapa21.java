package paqueteCine;

import java.util.ArrayList;
import java.util.List;

public class LanzadorEtapa21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos una pelicula
		Pelicula p1 = new Pelicula();
		// Modificamos los valores de sus atributos
		p1.setTitulo("El lobo de Wall Street");
		p1.setAnyo(2020);
		p1.setGenero(TGenero.DRAMA);
		p1.setDirector("Martin Scorsese");
		p1.setActores("Leonardo DiCaprio, Jonah Hill, Margot Robbie");
		p1.setSinopsis("Basado en la historia real de Jordan Belfort, desde su ascenso" +
				" a un adinerado corredor de bolsa que vive la gran vida hasta su ca�da " +
				"que involucra el crimen, la corrupci�n y el gobierno federal.");
		
		// Creamos otra pelicula
		Pelicula p2 = new Pelicula("Django desencadenado");
		// Modificamos los valores de sus atributos
		p2.setAnyo(2012);
		p2.setGenero(TGenero.ACCION);
		p2.setDirector("Quentin Tarantino");
		p2.setActores("Jamie Foxx, Christoph Waltz, Leonardo DiCaprio");
		p2.setSinopsis("Con la ayuda de un cazarrecompensas alem�n, un esclavo liberado" +
				" se propone rescatar a su esposa de un brutal due�o de una " +
				"plantaci�n de Mississippi.");
		
		//Creamos una cartelera y a�adimos las peliculas
		Cartelera c1 = new Cartelera();
		c1.nuevaPelicula(p1);
		c1.nuevaPelicula(p2);
		
		//visualizamos la cartelera
		System.out.println("\n******* CARTELERA C1 *********\n\n" + c1.mostrarCartelera());
		
		// intentamos a�adir nuevamente la pel�cula p1
		if (!c1.nuevaPelicula(p1))
			System.out.println(">>>>> No se ha podido a�adir la pel�cula: " + p1.getTitulo() + " porque ya est� en la cartelera");
		
		//volvemos a visualizar la cartelera comprobando que siguen solo las dos peliculas
		System.out.println("\n******* CARTELERA C1 *********\n\n" + c1.mostrarCartelera());
				
		// Creamos otras 2 peliculas
		Pelicula p3 = new Pelicula("Malditos bastardos");
		p3.setAnyo(2009);
		p3.setGenero(TGenero.ACCION);
		p3.setDirector("Quentin Tarantino");
		p3.setActores("Brad Pitt, Diane Kruger, Eli Roth");
		p3.setSinopsis("En la Francia ocupada por los nazis durante la Segunda Guerra Mundial," +
				" un plan para asesinar a los l�deres nazis por parte de un grupo de soldados " +
				"jud�os estadounidenses coincide con los planes vengativos del due�o de un teatro al respecto.");
		
		Pelicula p4 = new Pelicula("Pulp Fiction");
		p4.setAnyo(1994);
		p4.setGenero(TGenero.ACCION);
		p4.setDirector("Quentin Tarantino");
		p4.setActores("John Travolta, Uma Thurman, Samuel L. Jackson");
		p4.setSinopsis("Las vidas de dos sicarios de la mafia, un boxeador, un g�ngster y su esposa, y un par de " +
				"bandidos comensales se entrelazan en cuatro historias de violencia y redenci�n.");

		//Construimos un conjunto y lo a�adimos a la cartelera
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		peliculas.add(p3);
		peliculas.add(p4);
		if (c1.nuevaPelicula(peliculas))
			System.out.println(">>>>> Se han a�adido a la cartelera correctamente todas las pel�culas");
		
		//Visualizamos la cartelera nuevamente
		System.out.println("\n******* CARTELERA C1 *********\n\n" + c1.mostrarCartelera());
		
		//Creamos otra cartelera con las 4 pel�culas y la visualizamos
		peliculas.add(p2);
		peliculas.add(p1);
		Cartelera c2 = new Cartelera(peliculas);
		System.out.println("\n******* CARTELERA C2 *********\n\n" + c2.mostrarCartelera());
		
		//Eliminamos la pelicula 4
		if (c2.eliminarPelicula(p4.getTitulo()))
			System.out.println(">>>>> La pel�cula " + p4.getTitulo() + " ha sido eliminada correctamente de la cartelera ");
		
		System.out.println("\n******* CARTELERA C2 *********\n\n" + c2.mostrarCartelera());
		
		//Comprobamos que no est� en la cartelera la pelicula eliminada
		if (!c2.estaPelicula(p4)) 
			System.out.println(">>>>> La pel�cula " + p4.getTitulo() + " no est� en la cartelera");
		
		//Creamos otras 2 pel�culas
		Pelicula p5 = new Pelicula("Her",2013,"Spike Jonze","Joaquin Phoenix, Scarlett Johansson",
				"Un escritor en horas bajas se enamora de una Inteligencia Artificial.",TGenero.DRAMA);
		
		Pelicula p6 = new Pelicula();
		p6.setTitulo("Warcraft: El origen");
		p6.setAnyo(2016);
		p6.setDirector("Duncan Jones");
		p6.setActores("Travis Fimmel, Paula Patton, Ben Foster, Dominic Cooper, Toby Kebbell, Ben Schnetzer, Rob Kazinsky, Daniel Wu");
		p6.setGenero(TGenero.ACCION);
		p6.setSinopsis("Un joven mago llamado Khadgar (Ben Schnetzer) ha decidido "
				+ "rebelarse contra los ancianos que forman el Kirin Tor en busca de "
				+ "una verdad m�s elevada. Azeroth est� a punto de enfrentarse a la guerra, "
				+ "y la b�squeda del joven Khadgar har� que se cruce con el comandante Lothar, "
				+ "un encuentro que cambiar� el destino de ambos.");
		
		//Creamos una nueva cartelera con una de las dos pel�culas
		Cartelera c3 = new Cartelera (p6);
		
		//Construimos un conjunto y le a�adimos todas las pel�culas que hemos creado
		List<Pelicula> peliculas2 = new ArrayList<Pelicula>();
		peliculas2.add(p1);
		peliculas2.add(p2);
		peliculas2.add(p3);
		peliculas2.add(p4);
		peliculas2.add(p5);
		peliculas2.add(p6);
				
		//A�adimos a c3 el conjunto que acabamos de crear
		c3.nuevaPelicula(peliculas2);
		
		//Mostramos los detalles de la cartelera 3 para comprobar que la pel�cula p6 no est� duplicada.
		System.out.println("\n******* CARTELERA C3 *********\n\n" + c3.mostrarCartelera());

	}

}
