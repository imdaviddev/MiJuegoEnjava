package juego;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) {
		
		// Creamo una intancia JFrame (un objeto ventana)
		JFrame ventana = new JFrame("Jueguito");
		
		// Creamos una instanca de Juego que tiene hereda de JPanel 
		// basicamente es un JPanel personal(podemos reescribir metodos del padre).
		Juego jueguito = new Juego();
		
		// Añadir el JPanel dentro de la ventana 
		ventana.add(jueguito);
		
		// Añadir el tamaño de la ventana
		ventana.setSize(1300,400);
		
		// Localizacion de la ventana en pantalla
		ventana.setLocation(70,200);
		
		// Poner visible la pantalla
		ventana.setVisible(true);
		
		// Poner la opcion para que se cierre la ventana al 
		// presionar la 'x'
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Bucle Principal
		while(true) {
			// Con esto actualizo la pantalla. Redibujo los componentes de 'jueguito'
			jueguito.repaint();
			
			// Contador de tiempo
			try {
				Thread.sleep(10);
			}catch(InterruptedException ex) {
				Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
			}
			
		}
		
		
	}
	
	
}
