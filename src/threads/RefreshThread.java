package threads;

import javafx.application.Platform;
import ui.Tablero;
import ui.UsserGUI;

public class RefreshThread extends Thread {
	
	
	private Tablero tablero;
	private UsserGUI gui;
	
	public RefreshThread(Tablero t, UsserGUI gui){
		
		tablero = t ;
		this.gui = gui;
		
		setDaemon(true);
	}
	

	@Override
	public void run() {
		
		while(!tablero.getMundo().isGameOver() && tablero.getMundo().isInGame()) {
					tablero.refresh();
					if (tablero.getTimeThread().getTime()==0)
					{
						tablero.getMundo().setGameOver(true);
					}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		int r = -1;
		if(tablero.getMundo().isGameOver() ) {
			r=tablero.perdio();
			if(r!=0) gui.updateData(false,"",0,-1);
		} 
		else {
			tablero.getTimeThread().stopThread();
			int score = tablero.getTimeThread().getTime()*100;
			int win = tablero.gano();
			gui.updateData(true,tablero.getR().split("/")[1],score+(win*50),win);
		}
		
		
	}
	
	

}
