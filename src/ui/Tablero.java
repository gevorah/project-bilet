package ui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.PrincipalClass;

public class Tablero extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrincipalClass mundo;
	private JLabel[][] mapita;

	public Tablero() {

		mundo = new PrincipalClass("maps/lvl1.txt");

		mapita = new JLabel[mundo.getMatrix().length][mundo.getMatrix()[0].length];

		inicializarTablero();
		
		

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

				}
				
				mapita[i][j].setSize(40,40);

			}
			
		}
		setLayout(new GridLayout(mapita.length,mapita[0].length));
		
			for (int i = 0; i < mapita.length; i++) {
	
				for (int j = 0; j < mapita[0].length; j++) {	
					
					add(mapita[i][j]);
				}
			}
			// ajusta la ventana
			pack();
			
			//ajusta los atributos y valida que sean con los que esta en pantalla
			
			validate();
			
			// recarga toda la interfaz;
			repaint();
			
			// No deja que se cambie el tamaño
			
			setResizable(false);

	}
	public static void main(String[] args) {
		
		Tablero tab = new Tablero();
		tab.show();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
