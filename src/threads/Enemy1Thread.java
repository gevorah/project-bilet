package threads;

import model.PrincipalClass;

public class Enemy1Thread extends Thread {
	
	
	public PrincipalClass principalClass;
	
	
	
	public Enemy1Thread(PrincipalClass pC) {
		principalClass = pC;

		
		setDaemon(true);

	}
	
	public void run() {
		
		
		while(principalClass.isInGame()) {
			
			if (principalClass.getEnemigo().find(0).getEnemi().getDirection()==0) {
				
				principalClass.moverEnemigoDerecha();
			}
			else {
				principalClass.moverEnemigoIzquierda();
			}
 			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	}


