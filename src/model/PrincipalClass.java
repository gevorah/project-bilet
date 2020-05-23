package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import threads.Enemy1Thread;
import threads.GravityThread;

public class PrincipalClass {

	private Enemy1Thread eThread;
	private GravityThread gThread;
	
	private BufferedReader br;

	private int[][] matrix;

	private String archiveR;
	
	private Player jugador1;
	
	private Character enemigos;

	public PrincipalClass(String r) {

		archiveR = r;
		loadMap();
		gThread = new GravityThread(this);
		
		gThread.start();
		

		eThread = new Enemy1Thread(this);
		
		eThread.start();
		

	}

	public void loadMap() {
		
		

		try {
			br = new BufferedReader(new FileReader(new File(archiveR)));
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}
		String line = "";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String size[] = line.split(",");

		if (size.length == 2) {

			try {
				matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}

		} else {

			try {
				matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[0])];

			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}

		}
		
		for(int i = 0 ; i<matrix.length;i++) {
			
			
			try {
				line = br.readLine();
				String[] fila = line.split(",");
				
				for(int j = 0 ; j < fila.length;j++) {
					
					int objeto = Integer.parseInt(fila[j]);
					
					if (objeto==2) {
						
						Character temp = new Character(i,j,null,0,0,0,"");
						jugador1 = new Player(temp);
					} else if (objeto == 6) {
						
						enemigos = new Character(i,j,null,0,0,0,"");
						
						
					}
					
					matrix[i][j] = Integer.parseInt(fila[j]);
				
				}
				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void moverDerecha() {
		
		
		if(jugador1.getPj().getY()+1 < matrix[0].length) {
			System.out.println("llegó");
			if(matrix[jugador1.getPj().getX()][jugador1.getPj().getY()+1] == 3) {
				System.out.println("llegó2");
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()+1] = 2;
				jugador1.getPj().setY(jugador1.getPj().getY()+1);
			}
		}
		
		
		
	}
	public void moverIzquierda() {

		if(jugador1.getPj().getY()-1 > 0) {
			System.out.println("llegó");
			if(matrix[jugador1.getPj().getX()][jugador1.getPj().getY()-1] == 3) {
				System.out.println("llegó2");
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()-1] = 2;
				jugador1.getPj().setY(jugador1.getPj().getY()-1);
			}
		}
	}

	public void moverArriba() {
		if(jugador1.getPj().getX()-3 > 0 && jugador1.getPj().getJump()==0) {
			System.out.println("llegó");
			if(matrix[jugador1.getPj().getX()-3][jugador1.getPj().getY()] == 3) {
				System.out.println("llegó2");
				if(matrix[jugador1.getPj().getX()-2][jugador1.getPj().getY()] == 3 &&matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()] == 3){
					matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
					matrix[jugador1.getPj().getX()-3][jugador1.getPj().getY()] = 2;
					jugador1.getPj().setX(jugador1.getPj().getX()-3);
					jugador1.getPj().setJump(1);
				}
				else if (matrix[jugador1.getPj().getX()-2][jugador1.getPj().getY()] != 3 &&matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()]==3) {
					matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
					matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()] = 2;
					jugador1.getPj().setX(jugador1.getPj().getX()-1);
					jugador1.getPj().setJump(1);
				}
			}else if(matrix[jugador1.getPj().getX()-2][jugador1.getPj().getY()] == 3 &&matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()] == 3){
					matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
					matrix[jugador1.getPj().getX()-2][jugador1.getPj().getY()] = 2;
					jugador1.getPj().setX(jugador1.getPj().getX()-2);
					jugador1.getPj().setJump(1);
			}else if (matrix[jugador1.getPj().getX()-2][jugador1.getPj().getY()] != 3 &&matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()]==3) {
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX()-1][jugador1.getPj().getY()] = 2;
				jugador1.getPj().setX(jugador1.getPj().getX()-1);
				jugador1.getPj().setJump(1);
			}
		}
	}
	
	public void fall() {
		
		if(jugador1.getPj().getX()+1 < matrix.length &&  matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] != 1 &&  matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] != 4 ) {
			
			matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
			matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] = 2;
			jugador1.getPj().setX(jugador1.getPj().getX()+1);
			
			
		}else {
			if(matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] == 1
			||matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] == 4) {
				jugador1.getPj().setJump(0);

			}
		}
		
		
		
	}
	
	
	
	public void moverEnemigoDerecha() {
		
		if(enemigos.getY()-1 > 0) {
			System.out.println("llegó");
			if(matrix[enemigos.getX()][enemigos.getY()-1] == 3) {
				System.out.println("llegó2");
				matrix[enemigos.getX()][enemigos.getY()] = 3;
				matrix[enemigos.getX()][enemigos.getY()-1] = 6;
				enemigos.setY(enemigos.getY()-1);
			}
			
			else if (matrix[enemigos.getX()][enemigos.getY()-1] == 1
					||matrix[enemigos.getX()][enemigos.getY()-1] == 4) {
				enemigos.setSpeed(1);
			}
		}
	}
	public void moverEnemigoIzquierda() {
		
		if(enemigos.getY()+1 < matrix[0].length) {
			System.out.println("llegó");
			if(matrix[enemigos.getX()][enemigos.getY()+1] == 3) {
				System.out.println("llegó2");
				matrix[enemigos.getX()][enemigos.getY()] = 3;
				matrix[enemigos.getX()][enemigos.getY()+1] = 6;
				enemigos.setY(enemigos.getY()+1);
			}
			
			else if (matrix[enemigos.getX()][enemigos.getY()+1] == 1
					||matrix[enemigos.getX()][enemigos.getY()+1] == 4) {
				enemigos.setSpeed(0);
			}
		}
	}

	public Character getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Character enemigos) {
		this.enemigos = enemigos;
	}
	
	
}	
