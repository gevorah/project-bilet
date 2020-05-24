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
	private Player player1;
	private Character enemies;

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
			String line = "";
			line = br.readLine();
			String size[] = line.split(",");
			if (size.length == 2) {
					matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
			} else {
					matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[0])];
			}
			for(int i=0;i<matrix.length;i++) {
					line = br.readLine();
					String[] fila = line.split(",");
					for(int j=0;j<fila.length;j++) {
						int objeto = Integer.parseInt(fila[j]);
						if (objeto==2) {
							Character temp = new Character(i,j,"character_1",10,10);
							player1 = new Player(temp);
						} else if (objeto == 6) {
							enemies = new Character(i,j,"character_1",0,0);
						}
						matrix[i][j] = Integer.parseInt(fila[j]);
					}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public void moverDerecha() {
		
		
		if(player1.getPj().getY()+1 < matrix[0].length) {
			
			if(matrix[player1.getPj().getX()][player1.getPj().getY()+1] == 3) {
				
				matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
				matrix[player1.getPj().getX()][player1.getPj().getY()+1] = 2;
				player1.getPj().setY(player1.getPj().getY()+1);
			}
		}
		
		
		
	}
	public void moverIzquierda() {

		if(player1.getPj().getY()-1 > 0) {
			System.out.println("llegó");
			if(matrix[player1.getPj().getX()][player1.getPj().getY()-1] == 3) {
				System.out.println("llegó2");
				matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
				matrix[player1.getPj().getX()][player1.getPj().getY()-1] = 2;
				player1.getPj().setY(player1.getPj().getY()-1);
			}
		}
	}

	public void moverArriba() {
		if(player1.getPj().getX()-3 > 0 && player1.getPj().getJump()==0) {
		
			if(matrix[player1.getPj().getX()-3][player1.getPj().getY()] == 3) {
				
				if(matrix[player1.getPj().getX()-2][player1.getPj().getY()] == 3 &&matrix[player1.getPj().getX()-1][player1.getPj().getY()] == 3){
					matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
					matrix[player1.getPj().getX()-3][player1.getPj().getY()] = 2;
					player1.getPj().setX(player1.getPj().getX()-3);
					player1.getPj().setJump(1);
				}
				else if (matrix[player1.getPj().getX()-2][player1.getPj().getY()] != 3 &&matrix[player1.getPj().getX()-1][player1.getPj().getY()]==3) {
					matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
					matrix[player1.getPj().getX()-1][player1.getPj().getY()] = 2;
					player1.getPj().setX(player1.getPj().getX()-1);
					player1.getPj().setJump(1);
				}
			}else if(matrix[player1.getPj().getX()-2][player1.getPj().getY()] == 3 &&matrix[player1.getPj().getX()-1][player1.getPj().getY()] == 3){
					matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
					matrix[player1.getPj().getX()-2][player1.getPj().getY()] = 2;
					player1.getPj().setX(player1.getPj().getX()-2);
					player1.getPj().setJump(1);
			}else if (matrix[player1.getPj().getX()-2][player1.getPj().getY()] != 3 &&matrix[player1.getPj().getX()-1][player1.getPj().getY()]==3) {
				matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
				matrix[player1.getPj().getX()-1][player1.getPj().getY()] = 2;
				player1.getPj().setX(player1.getPj().getX()-1);
				player1.getPj().setJump(1);
			}
		}
	}
	
	public void fall() {
		
		if(player1.getPj().getX()+1 < matrix.length &&  matrix[player1.getPj().getX()+1][player1.getPj().getY()] != 1 &&  matrix[player1.getPj().getX()+1][player1.getPj().getY()] != 4 ) {
			
			matrix[player1.getPj().getX()][player1.getPj().getY()] = 3;
			matrix[player1.getPj().getX()+1][player1.getPj().getY()] = 2;
			player1.getPj().setX(player1.getPj().getX()+1);
			
			
		}else {
			if(matrix[player1.getPj().getX()+1][player1.getPj().getY()] == 1
			||matrix[player1.getPj().getX()+1][player1.getPj().getY()] == 4) {
				player1.getPj().setJump(0);

			}
		}
		
		
		
	}
	
	
	
	public void moverEnemigoDerecha() {
		
		if(enemies.getY()-1 > 0) {
			System.out.println("llegó");
			if(matrix[enemies.getX()][enemies.getY()-1] == 3) {
				System.out.println("llegó2");
				matrix[enemies.getX()][enemies.getY()] = 3;
				matrix[enemies.getX()][enemies.getY()-1] = 6;
				enemies.setY(enemies.getY()-1);
			}
			
			else if (matrix[enemies.getX()][enemies.getY()-1] == 1
					||matrix[enemies.getX()][enemies.getY()-1] == 4) {
				enemies.setSpeed(1);
			}
		}
	}
	public void moverEnemigoIzquierda() {
		
		if(enemies.getY()+1 < matrix[0].length) {
			
			if(matrix[enemies.getX()][enemies.getY()+1] == 3) {
			
				matrix[enemies.getX()][enemies.getY()] = 3;
				matrix[enemies.getX()][enemies.getY()+1] = 6;
				enemies.setY(enemies.getY()+1);
			}
			
			else if (matrix[enemies.getX()][enemies.getY()+1] == 1
					||matrix[enemies.getX()][enemies.getY()+1] == 4) {
				enemies.setSpeed(0);
			}
		}
	}

	public Character getEnemigos() {
		return enemies;
	}

	public void setEnemigos(Character enemigos) {
		this.enemies = enemigos;
	}
	
	
}	
