package ui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import model.PrincipalClass;
import model.PrincipalClassInterface;
import threads.RefreshThread;
import threads.TimeKeeperThread;


public class Tablero extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private RefreshThread rT ;
	private TimeKeeperThread timeThread;
	private static final long serialVersionUID = 1L;
	private PrincipalClassInterface mundo;
	public static final int TIMEKEEPER=60;
	public static final int SCORE=100;
	
	public PrincipalClassInterface getMundo() {
		return mundo;
	}
	
	public TimeKeeperThread getTimeThread()
	{
		return this.timeThread;
	}

	public void setMundo(PrincipalClass mundo) {
		this.mundo = mundo;
	}

	private JLabel[][] mapita;
	private JPanel panelJuego;
	
	private String r;
	public String getR() {
		return r;
	}

	private UsserGUI gui;
	
	public Tablero(String r, UsserGUI gui) {
		this.r = r;
		this.gui = gui;
		this.timeThread = new TimeKeeperThread();

		mundo = new PrincipalClass(r);

		mapita = new JLabel[mundo.getMatrix().length][mundo.getMatrix()[0].length];


		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		addKeyListener(this);
		
		
		inicializarTablero();
		
		rT = new RefreshThread(this,gui);
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
		
			setLayout(new GridLayout(1,1));
			add(panelJuego);
			// ajusta la ventana
			pack();
			
			//ajusta los atributos y valida que sean con los que esta en pantalla
			
			validate();
			
			// recarga toda la interfaz;
			repaint();
			
			// No deja que se cambie el tamaño
			
			setResizable(false);
			
			timeThread.start();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		switch(e.getKeyCode()) {
		
		
		//tecla arriba
		case 38:
			mundo.moverArriba();
			break;
		// 	tecla izquierda
		case 37:
			mundo.moverIzquierda();
			break;
		
		// tecla derecha
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

	public int perdio() {
		Object[] options1 = { "Continue", "Quit" };
		JPanel panel = new JPanel();
		panel.add(new JLabel("Game Over"));
		int result = JOptionPane.showOptionDialog(null, panel, "Game Over",
        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options1, null);
		if (result == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "Jo");
			reset();
		} else {
			this.dispose();
		}
		return result;
	}
	
	public int gano() {
		String data[] = mundo.getQuest().split(",");
		Object[] options1 = { data[1], data[2] };
		JPanel panel = new JPanel();
		panel.add(new JLabel(data[0]));
		int result = JOptionPane.showOptionDialog(null, panel, "Level Complete",
        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, options1, null);
		
		int ans = -1;
		if (result == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, data[3].split(":")[0]);
			ans = Integer.parseInt(data[3].split(":")[1]);
		} else {
			JOptionPane.showMessageDialog(null, data[4].split(":")[0]);
			ans = Integer.parseInt(data[4].split(":")[1]);
		}
		this.dispose();
		return ans;
	}
	void reset(){
		mundo = new PrincipalClass(r);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		rT = new RefreshThread(this,gui);
		rT.start();
	}
	
	

}
