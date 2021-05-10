package paqueteCine;

public class LanzadorEtapa1 {
	
	public static void main(String[] args)
	{
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
				
				//Visualizamos su informaci�n por pantalla
				System.out.println(p1.mostrarPelicula());
				
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
				
				//Visualizamos su informaci�n por pantalla
				System.out.println(p2.mostrarPelicula());
				
				//Modificamos el a�o de la pelicula p1
				p1.setAnyo(p1.getAnyo() - 7);
				
				//Volvemos a visualizar su informaci�n por pantalla
				System.out.println(p1.mostrarPelicula());
				
				//Creamos otra pel�cula
				Pelicula p3 = new Pelicula("Her",2013,"Spike Jonze","Joaquin Phoenix, Scarlett Johansson",
						"Un escritor en horas bajas se enamora de una Inteligencia Artificial.",TGenero.DRAMA);
				//Visualizamos la informaci�n en pantalla
				System.out.println(p3.mostrarPelicula());
				
				//Creamos otra pel�cula
				Pelicula p4 = new Pelicula();
				p4.setTitulo("Warcraft: El origen");
				p4.setAnyo(2016);
				p4.setDirector("Duncan Jones");
				p4.setActores("Travis Fimmel, Paula Patton, Ben Foster, Dominic Cooper, Toby Kebbell, Ben Schnetzer, Rob Kazinsky, Daniel Wu");
				p4.setGenero(TGenero.ACCION);
				p4.setSinopsis("Un joven mago llamado Khadgar (Ben Schnetzer) ha decidido "
						+ "rebelarse contra los ancianos que forman el Kirin Tor en busca de "
						+ "una verdad m�s elevada. Azeroth est� a punto de enfrentarse a la guerra, "
						+ "y la b�squeda del joven Khadgar har� que se cruce con el comandante Lothar, "
						+ "un encuentro que cambiar� el destino de ambos.");
				//Visualizamos su informaci�n
				System.out.println(p4.mostrarPelicula());
	}
	
}
