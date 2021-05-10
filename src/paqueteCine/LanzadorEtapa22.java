package paqueteCine;

import java.time.LocalDate;
import java.time.LocalTime;


public class LanzadorEtapa22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Creamos pelicula P1
		Pelicula p1 = new Pelicula();
		p1.setTitulo("El lobo de Wall Street");
		p1.setAnyo(2020);
		p1.setGenero(TGenero.DRAMA);
		p1.setDirector("Martin Scorsese");
		p1.setActores("Leonardo DiCaprio, Jonah Hill, Margot Robbie");
		p1.setSinopsis("Basado en la historia real de Jordan Belfort, desde su ascenso" +
				" a un adinerado corredor de bolsa que vive la gran vida hasta su caída " +
				"que involucra el crimen, la corrupción y el gobierno federal.");
		
		// Creamos pelicula P2
		Pelicula p2 = new Pelicula("Django desencadenado");
		// Modificamos los valores de sus atributos
		p2.setAnyo(2012);
		p2.setGenero(TGenero.ACCION);
		p2.setDirector("Quentin Tarantino");
		p2.setActores("Jamie Foxx, Christoph Waltz, Leonardo DiCaprio");
		p2.setSinopsis("Con la ayuda de un cazarrecompensas alemán, un esclavo liberado" +
				" se propone rescatar a su esposa de un brutal dueño de una " +
				"plantación de Mississippi.");
				
		//Creamos una cartelera y añadimos las peliculas
		Cartelera c1 = new Cartelera();
		c1.nuevaPelicula(p1);
		c1.nuevaPelicula(p2);
		
		//Creamos distintas sesiones y las visualizamos
		Sesion s1 = new Sesion(50);
		s1.setFecha(LocalDate.of(2020,3,18));
		s1.setHora(LocalTime.of(16, 00));
		s1.setPelicula(p1);
		System.out.println(s1.mostrarSesion());
		
		Sesion s2 = new Sesion(LocalDate.of(2020,3,19), LocalTime.of(18, 00), p2);
		s2.setCapacidad(45);
		System.out.println(s2.mostrarSesion());
		
		//Simulamos la venta de 10 entradas de la sesion s1
		int butacasVendidas = 10;
		s1.reducirDisponibilidad(butacasVendidas);
		System.out.println(s1.mostrarSesion());
		
		//Simulamos la venta de 5 entradas de la sesion s2
		butacasVendidas = 5;
		s2.reducirDisponibilidad(butacasVendidas);
		System.out.println(s2.mostrarSesion());
		
		//Intentamos vender más butacas que las disponibles
		butacasVendidas = s2.getButacasDisponibles() +1;
		if (butacasVendidas > s2.getButacasDisponibles()) {
			System.out.println(">>>>> No se pueden vender " + butacasVendidas + " butacas de la sesion " + s2.mostrarSesion());
		}
		else {
			System.out.println(">>>>> Error: Se han vendido " + butacasVendidas + " butacas de la sesion " + s2.mostrarSesion());
		}
		
		//Creamos unas pocas películas más
		Pelicula p3 = new Pelicula("Viuda Negra",2021,"Cate Shortland","Scarlett Johansson, Florence Pugh, David Harbour, "
				+ "Rachel Weisz, O. T. Fagbenle, William Hurt, Ray Winstone","Al nacer, la Viuda Negra, "
						+ "también conocida como Natasha Romanova, se entrega a la KGB para convertirse "
						+ "en su agente definitivo. Cuando la URSS se separa, el gobierno intenta matarla "
						+ "mientras la acción se traslada a la actual Nueva York.",TGenero.ACCION);
		
		Pelicula p4 = new Pelicula();
		p4.setTitulo("Nadie");
		p4.setAnyo(2021);
		p4.setDirector("Ilya Naishuller");
		p4.setActores("Bob Odenkirk, Connie Nielsen, Aleksey Serebryakov, Christopher Lloyd, Michael Ironside, Colin Salmon");
		p4.setGenero(TGenero.ACCION);
		p4.setSinopsis("Una noche, cuando dos ladrones entran en su casa, Hutch decide no actuar y no trata de defenderse "
				+ "ni al él mismo ni a su familia, convencido de que solo así evitará una escalada de violencia. "
				+ "Tras el ataque, su hija adolescente Blake (Gage Munroe, La cabaña) no oculta su decepción, "
				+ "y su esposa Becca (Connie Nielsen, Wonder Woman) se aleja todavía más.");
				
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
				+ "una verdad más elevada. Azeroth está a punto de enfrentarse a la guerra, "
				+ "y la búsqueda del joven Khadgar hará que se cruce con el comandante Lothar, "
				+ "un encuentro que cambiará el destino de ambos.");
		
		//Las añadimos a la cartelera C1 y mostramos sus datos
		c1.nuevaPelicula(p3);
		c1.nuevaPelicula(p4);
		c1.nuevaPelicula(p5);
		c1.nuevaPelicula(p6);
		System.out.println("\n******* CARTELERA C3 *********\n\n" + c1.mostrarCartelera());
		
		//Creamos unas cuantas sesiones, añadimos las películas, fecha, hora y capacidad de la sala
		Sesion s3 = new Sesion(100);
		s3.setFecha(LocalDate.of(2021, 5, 15));
		s3.setHora(LocalTime.of(20, 00));
		s3.setPelicula(p4);
		
		Sesion s4 = new Sesion(LocalDate.of(2021, 7, 9),LocalTime.of(22, 00),p3);
		s4.setCapacidad(100);
		
		Sesion s5 = new Sesion(50);
		s5.setFecha(LocalDate.of(2021, 5, 15));
		s5.setHora(LocalTime.of(19, 00));
		s5.setPelicula(p5);
		
		Sesion s6 = new Sesion(LocalDate.of(2021, 5, 15),LocalTime.of(17, 00),p6);
		s6.setCapacidad(50);
	
		//Mostramos los detalles de las sesiones
		System.out.println(s3.mostrarSesion());
		System.out.println(s4.mostrarSesion());
		System.out.println(s5.mostrarSesion());
		System.out.println(s6.mostrarSesion());
		
		//Vendemos algunas entradas
		s3.reducirDisponibilidad(5);
		s4.reducirDisponibilidad(2);
		s5.reducirDisponibilidad(1);
		s6.reducirDisponibilidad(4);
		s3.reducirDisponibilidad(3);
		s3.reducirDisponibilidad(6);
		s5.reducirDisponibilidad(2);
		s4.reducirDisponibilidad(1);
		s6.reducirDisponibilidad(1);
		s2.reducirDisponibilidad(5);
		s1.reducirDisponibilidad(3);
		
		//Y volvemos a mostrar los detalles de las sesiones
		System.out.println(s3.mostrarSesion());
		System.out.println(s4.mostrarSesion());
		System.out.println(s5.mostrarSesion());
		System.out.println(s6.mostrarSesion());
		
		//Intentamos vender más butacas de las que quedan en la sesión s2
		s2.reducirDisponibilidad(s2.getButacasDisponibles()+1);
		
	}

}
