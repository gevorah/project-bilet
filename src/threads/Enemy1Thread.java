package threads;


import model.PrincipalClass;

public class Enemy1Thread extends Thread {
	
	public PrincipalClass principalClass;
	
	public Enemy1Thread(PrincipalClass pC) {
		principalClass = pC;
		setDaemon(true);
	}
	
	public void run() {
		while(true) {
			
			if (principalClass.getEnemigos().getSpeed()==0) {
				principalClass.moverEnemigoDerecha();
			} else {
				principalClass.moverEnemigoIzquierda();
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
