package juego;

import java.awt.Graphics2D;
import java.awt.geom.Area;

import javax.swing.ImageIcon;

public class Obstaculo {
	
	// Objeto de la clase juego
	Juego jueguito;
	
	// Variables que delimitan el area del obstaculo
	Area cabeza, cuerpo, arbol;
	
	// Variables del tamaño del personaje
	int anchoObstaculo = 70;
	int altoObstaculo = 70;
	
	// Coordenadas iniciales donde se ubica el objeto
	static int x_inicial = 1300;
	static int y_inicial = 270;
	
	// Coordenadas para manipular el objeto
	static int x_auxiliar = -4;

	
	// Constructor del Objeto Obstaculo
	// Recibe un JPanel para poder autodibujarse
	public Obstaculo(Juego jueguito) {
		this.jueguito = jueguito;
	}
	
	// Autodibujarse
	public void paint(Graphics2D g) {
		ImageIcon obstaculo = new ImageIcon(getClass().getResource("/multimedia/arbol.png"));
		g.drawImage(obstaculo.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo, null);
	}
	
}
