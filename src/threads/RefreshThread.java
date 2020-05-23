package threads;

import ui.Tablero;

public class RefreshThread extends Thread {
	
	
	private Tablero tablero;
	
	public RefreshThread(Tablero t ){
		
		tablero = t ;
		
		
	setDaemon(true);
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			
			
				for (int i = 0; i < 60; i++) {
					tablero.refresh();
				}
				
				
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	

}
