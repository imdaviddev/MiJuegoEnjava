package juego;

// MIN: 47 VIDEO

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

	public static int reiniciarJuego = -1;

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "¿Estas listo?");

		// Creamo una intancia JFrame (un objeto ventana)
		JFrame ventana = new JFrame("Jueguito");

		// Creamos una instanca de Juego que tiene hereda de JPanel
		// basicamente es un JPanel personal(podemos reescribir metodos del padre).
		Juego jueguito = new Juego();

		// Añadir el JPanel dentro de la ventana
		ventana.add(jueguito);

		// Añadir el tamaño de la ventana
		ventana.setSize(1300, 400);

		// Localizacion de la ventana en pantalla
		ventana.setLocation(70, 200);

		// Poner visible la pantalla
		ventana.setVisible(true);

		// Poner la opcion para que se cierre la ventana al
		// presionar la 'x'
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Bucle Principal
		while (true) {

			if (jueguito.juegoFinalizado) {
				reiniciarJuego = JOptionPane.showConfirmDialog(null, "Haz Perdido, ¿Quieres jugar de nuevo?",
						"Haz Perdido", JOptionPane.YES_NO_OPTION);
				if (reiniciarJuego == 0) {
					reiniciarValores();
				} else if (reiniciarJuego == 1) {
					System.exit(0);
				}

			} else {
				
				// Con esto actualizo la pantalla. Redibujo los componentes de 'jueguito'
				jueguito.repaint();

				// Contador de tiempo
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
					Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
				}
				
				if(Juego.pierdeVida == true) {
					JOptionPane.showMessageDialog(null, "Cuidado!!!");
					Juego.pierdeVida = false;
					Juego.vidas--;
					Auto.y_inicial = 270;
					Auto.saltando = false;
					Obstaculo.x_inicial = 1300;
				}

			}

		}

	}

	public static void reiniciarValores() {
		Juego.juegoFinalizado = false;
		Obstaculo.x_auxiliar = -4;
		Juego.puntos = 0;
		Juego.nivel = 0;
		Juego.vidas = 3;
		reiniciarJuego = -1;
		Obstaculo.x_inicial = 1300;
	}
}
