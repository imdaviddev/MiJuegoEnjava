package juego;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class Fondo {

	// Objeto de la clase juego
	Juego jueguito;
	
	// Variables del tamaño del fondo
	int anchoFondo = 1300;
	int altoFondo = 400;
	
	// Coordenadas iniciales para mover el Fondo
	int x1 = 1300;
	int y1 = 0;
	
	// Coordenadas auxiliares que mueven otro fondo
	int x2 = 0;
	int y2 = 0;
	
	// Constructor
	// Recibe un JPanel para poder autodibujarse
	public Fondo(Juego jueguito) {
		this.jueguito = jueguito;
	}
	
	// Autodibujarse
	public void paint(Graphics2D g) {
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/multimedia/fondoArboles.jpg"));
		g.drawImage(imagenFondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
		g.drawImage(imagenFondo.getImage(), x2, y2, anchoFondo, altoFondo, null);
	}
	
}
