package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

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
	
	// Movimiento
	void mover() {
		if(x_inicial <= -100) {
			jueguito.puntos++;
			x_inicial = 1300;
			if(jueguito.puntos%3 == 0) {
				x_auxiliar += -2;
				jueguito.nivel++;
			}
		}else {
			if(colision()) {
				if(jueguito.vidas == 0) {
					jueguito.finJuego();
				}else {
					jueguito.pierdeVida();
				}
			}else {
				x_inicial += x_auxiliar;
			}			
		}
	}
	
	
	// Autodibujarse
	public void paint(Graphics2D g) {
		ImageIcon obstaculo = new ImageIcon(getClass().getResource("/multimedia/arbol.png"));
		g.drawImage(obstaculo.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo, null);
	}
	
	public Area getBounds(){
		Ellipse2D formal = new Ellipse2D.Double(x_inicial, y_inicial, 48, 48);
		Rectangle forma2 = new Rectangle(x_inicial+12, y_inicial+16, 50, 53);
		
		cabeza = new Area(formal);
		cuerpo = new Area(forma2);
		
		arbol = cabeza;
		arbol.add(cabeza);
		arbol.add(cuerpo);
		
		return arbol;
	}
	
	public boolean colision() {
		Area areaA = new Area(jueguito.auto.getBounds());
		areaA.intersect(getBounds());
		
		return !areaA.isEmpty();
	}
	
}
