package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class Auto {
	
	// Objeto de la clase juego
	Juego jueguito;
	
	// Variables que nos ayudan a saber si el auto salta o no
	static boolean saltando = false;
	boolean sube = false;
	boolean baja = false;
	
	// Variables que delimitan el area del objeto
	Area llantaDelantera, llantaTrasera, carroceria, auto;
	
	// Variables de tama�o del personaje
	int anchoPersonaje = 112;
	int altoPersonaje = 78;
	
	// Coordenadas iniciales de personaje
	static int x_inicial = 50;
	static int y_inicial = 270;
	
	// Coordenadas para manipular el personaje
	int x_auxiliar = 0;
	int y_auxiliar = 0;
	
	// Constructor de el Objeto Auto
	// Al recibir un JPanel(jueguito) se podra autodibujar 
	public Auto(Juego jueguito) {
		this.jueguito = jueguito;	
	}
	
	public void mover() {
		if(x_inicial + x_auxiliar > 0 && x_inicial + x_auxiliar < jueguito.getWidth()-anchoPersonaje) {
			x_inicial += x_auxiliar;
		}
		if(saltando) {
			if(y_inicial == 270) { // Si el auto esta en el suelo
				sube = true;
				y_auxiliar = -2;
				baja = false;
			}
			System.out.println(x_inicial);
			if(y_inicial == 150) { // Si el auto llego al limite del salto
				baja = true;
				y_auxiliar = 2;
				sube = false;
			}
			if(sube) {
				y_inicial += y_auxiliar;
			}
			if(baja) {
				y_inicial += y_auxiliar;
				if(y_inicial == 270) { // Si el auto llega al suelo
					saltando = false;
				}
			}
			
		}
	}
	
	public void paint(Graphics2D g) {
		ImageIcon auto = new ImageIcon(getClass().getResource("/multimedia/jeep.png"));
		g.drawImage(auto.getImage(), x_inicial, y_inicial, anchoPersonaje, altoPersonaje, null);
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			saltando = true;
		}
	}
	
	// Para la animacion del salto, no usa otro sprite
	public Area getBounds() {
		Rectangle formal = new Rectangle(x_inicial, y_inicial, 95,62);
		carroceria = new Area(formal);
		
		Ellipse2D forma2 = new Ellipse2D.Double(x_inicial, y_inicial+28, 48,48);
		llantaTrasera = new Area(forma2);
		
		Ellipse2D forma3 = new Ellipse2D.Double(x_inicial+73, y_inicial+39, 38,38);
		llantaDelantera = new Area(forma3);
		
		auto = carroceria;
		auto.add(carroceria);
		auto.add(llantaTrasera);
		auto.add(llantaDelantera);
	
		return auto;
	}
	
	
}
