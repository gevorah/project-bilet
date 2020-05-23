package ui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import model.PrincipalClass;
import threads.RefreshThread;

public class Tablero extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private RefreshThread rT ;
	private static final long serialVersionUID = 1L;
	private PrincipalClass mundo;
	private JLabel[][] mapita;
	private JPanel panelJuego;

	public Tablero() {
		
		

		mundo = new PrincipalClass("maps/lvl1.txt");

		mapita = new JLabel[mundo.getMatrix().length][mundo.getMatrix()[0].length];

		
		
		addKeyListener(this);
		
		
		inicializarTablero();
		
		rT = new RefreshThread(this);
		rT.start();

	}

	private void inicializarTablero() {

		for (int i = 0; i < mapita.length; i++) {

			for (int j = 0; j < mapita[0].length; j++) {

				mapita[i][j] = new JLabel();

				switch (mundo.getMatrix()[i][j]) {

					case 1:
	
						mapita[i][j].setIcon(new ImageIcon("img/muro1.png"));
	
						break;
	
					case 2:
	
						mapita[i][j].setIcon(new ImageIcon("img/personaje.png"));
	
						break;
					case 3:
	
						mapita[i][j].setIcon(new ImageIcon("img/fondo1.png"));
	
						break;
	
					case 4:
	
						mapita[i][j].setIcon(new ImageIcon("img/piso1.png"));
	
						break;
	
					case 5:
	
						mapita[i][j].setIcon(new ImageIcon("img/puerta.png"));
	
						break;
					case 6:
							
						mapita[i][j].setIcon(new ImageIcon("img/enemigo.png"));
						
						break;
					
						
				}
				
				mapita[i][j].setSize(40,40);

			}
			
		}
		panelJuego = new JPanel(new GridLayout(mapita.length,mapita[0].length));
		
			for (int i = 0; i < mapita.length; i++) {
	
				for (int j = 0; j < mapita[0].length; j++) {	
					
					panelJuego.add(mapita[i][j]);
				}
			}
			// ajusta la ventana
			setLayout(new GridLayout(1,1));
			add(panelJuego);
			pack();
			
			//ajusta los atributos y valida que sean con los que esta en pantalla
			
			validate();
			
			// recarga toda la interfaz;
			repaint();
			
			// No deja que se cambie el tamaño
			
			//setResizable(false);

	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Tablero tab = new Tablero();
		tab.show();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		
		//arriba
		case 38:
			mundo.moverArriba();
			break;
		// 	izquierda
		case 37:
			mundo.moverIzquierda();
			break;
		
		//derecha
		case 39:
			mundo.moverDerecha();
			break;
			

		

			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		
		//arriba
		case 38:
			mundo.moverArriba();
			break;
		// 	izquierda
		case 37:
			mundo.moverIzquierda();
			break;
		
		//derecha
		case 39:
			mundo.moverDerecha();
			break;
			
		//No se necesita
			
		
			
		}
		System.out.println(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	public synchronized void  refresh() {
		remove(panelJuego);		
		for (int i = 0; i < mapita.length; i++) {

			for (int j = 0; j < mapita[0].length; j++) {

				mapita[i][j] = new JLabel();

				switch (mundo.getMatrix()[i][j]) {

					case 1:
	
						mapita[i][j].setIcon(new ImageIcon("img/muro1.png"));
	
						break;
	
					case 2:
	
						mapita[i][j].setIcon(new ImageIcon("img/personaje.png"));
	
						break;
					case 3:
	
						mapita[i][j].setIcon(new ImageIcon("img/fondo1.png"));
	
						break;
	
					case 4:
	
						mapita[i][j].setIcon(new ImageIcon("img/piso1.png"));
	
						break;
	
					case 5:
	
						mapita[i][j].setIcon(new ImageIcon("img/puerta.png"));
	
						break;
						
					case 6:
						
						mapita[i][j].setIcon(new ImageIcon("img/enemigo.png"));
						break;

				}
				
				mapita[i][j].setSize(40,40);

			}
			
		}
		panelJuego = new JPanel(new GridLayout(mapita.length, mapita[0].length));		
		
		for (int i = 0; i < mapita.length; i++) {
			
			for (int j = 0; j < mapita[0].length; j++) {	
				
				panelJuego.add(mapita[i][j]);
			}
		}
		
		add(panelJuego);
		repaint();
		validate();
		pack();
		
		
		
	}

}
