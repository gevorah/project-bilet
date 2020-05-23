package threads;


import model.PrincipalClass;

public class GravityThread extends Thread {
	
	
	private PrincipalClass principalClass;
	
	public GravityThread(PrincipalClass pC) {
		
		
		principalClass = pC;
		
		
	}
	
	@Override
	public void run() {
		
		while(true) {
			
			principalClass.fall();		
			
			try {
				Thread.sleep(190);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		}
	}
	
	
	
}
