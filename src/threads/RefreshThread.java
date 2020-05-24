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
			
			
			
				
					tablero.refresh();
				
				
				
		
			try {
				Thread.sleep(0,001);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	

}
