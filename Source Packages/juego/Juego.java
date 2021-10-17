package juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.JPanel;

// La clase JPanel es nuestro espacio para agregar, modificar, dibujar, etc.
public class Juego extends JPanel {

	// Falta implementar
	// Sonidos del juego
	URL direccionSonidoSalto, direccionSonidoChoque;
	@SuppressWarnings("deprecation")
	AudioClip sonidoChoque, sonidoSalto;

	// Objetos de las clases auto, obstaculo y fondo
	Auto auto = new Auto(this);
	Obstaculo obstaculo = new Obstaculo(this);
	Fondo fondo = new Fondo(this);

	// Variables pra el juego
	static boolean juegoFinalizado = false;
	static boolean pierdeVida = false;
	static int vida = 3;
	static int puntos = 0;
	static int nivel = 1;

	public Juego() {
//		direccionSonidoChoque = getClass().getResource("/multimedia/nombre.wav");
//		sonidoChoque = Applet.newAudioClip(direccionSonidoChoque);

//		direccionSonidoSalto = getClass().getResource("/multimedia/name.wav");
//		sonidoSalto = Applet.newAudioClip(direccionSonidoChoque);

		// Escuchar al teclado
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Saltar con espacio
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//					sonidoSalto.play();
					auto.keyPressed(e);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
		setFocusable(true);

	}

	// Dibujar
	public void paintComponent(Graphics2D g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		dibujar(g2);
		dibujarPuntaje(g2);
	}

	public void dibujar(Graphics2D g) {
		fondo.paint(g);
		auto.paint(g);
		obstaculo.paint(g);
	}

	public void dibujarPuntaje(Graphics2D g) {

	}

}
