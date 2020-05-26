package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import threads.Enemy1Thread;
import threads.GravityThread;

public class PrincipalClass implements PrincipalClassInterface{

	private Enemy1Thread eThread;
	private GravityThread gThread;

	private BufferedReader br;

	private int[][] matrix;

	private LinkedList enemigos;

	private String archiveR;

	private String archiveS;

	private Player jugador1;


	
	private String quest;

	private boolean inGame;
	private boolean gameOver;

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public PrincipalClass(String r) {
		enemigos = new LinkedList();
		archiveR = r;
		archiveS = "data/selection.txt";
		loadMap();
		loadQuest();
		inGame = true;
		gameOver = false;
		gThread = new GravityThread(this);

		gThread.start();

		eThread = new Enemy1Thread(this);

		eThread.start();

	}
	
	public void loadQuest() {
		try {
			br = new BufferedReader(new FileReader(new File(archiveS)));
			String line = null;
			int rand = (int)(Math.random()*4);
			for(int i=0;i<=rand;i++) {
				line = br.readLine();
			}
			quest = line;
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	@Override
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

		for (int i = 0; i < matrix.length; i++) {

			try {
				line = br.readLine();
				String[] fila = line.split(",");

				for (int j = 0; j < fila.length; j++) {

					int objeto = Integer.parseInt(fila[j]);

					if (objeto == 2) {

						Character temp = new Character(i, j, null, 0, 0, "");
						jugador1 = new Player(temp);
					} else if (objeto == 6) {
						
						enemigos.add(new Enemy(i, j, null, 0, 0));

					}

					matrix[i][j] = Integer.parseInt(fila[j]);

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public void moverDerecha() {

		if (matrix[jugador1.getPj().getX()][jugador1.getPj().getY() + 1] == 6) {
			gameOver = true;
		} else if(matrix[jugador1.getPj().getX()][jugador1.getPj().getY()+1] == 5) {
			inGame = false;
		} else if (jugador1.getPj().getY() + 1 < matrix[0].length) {

			if (matrix[jugador1.getPj().getX()][jugador1.getPj().getY() + 1] == 3) {

				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY() + 1] = 2;
				jugador1.getPj().setY(jugador1.getPj().getY() + 1);
			}
		}

	}

	@Override
	public void moverIzquierda() {

		if (matrix[jugador1.getPj().getX()][jugador1.getPj().getY() - 1] == 6) {
			gameOver = true;
		} else if(matrix[jugador1.getPj().getX()][jugador1.getPj().getY()-1] == 5) {
			inGame = false;
		} else if (jugador1.getPj().getY() - 1 > 0) {

			if (matrix[jugador1.getPj().getX()][jugador1.getPj().getY() - 1] == 3) {

				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY() - 1] = 2;
				jugador1.getPj().setY(jugador1.getPj().getY() - 1);
			}
		}
	}

	@Override
	public void moverArriba() {
		if (jugador1.getPj().getX() - 3 > 0 && jugador1.getPj().getJump() == 0) {

			if (matrix[jugador1.getPj().getX() - 3][jugador1.getPj().getY()] == 6){
				gameOver = true;
			} else if(matrix[jugador1.getPj().getX()-3][jugador1.getPj().getY()] == 5) {
				inGame = false;
			} else if (matrix[jugador1.getPj().getX() - 3][jugador1.getPj().getY()] == 3) {

				if (matrix[jugador1.getPj().getX() - 2][jugador1.getPj().getY()] == 3
						&& matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] == 3) {
					matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
					matrix[jugador1.getPj().getX() - 3][jugador1.getPj().getY()] = 2;
					jugador1.getPj().setX(jugador1.getPj().getX() - 3);
					jugador1.getPj().setJump(1);
				} else if (matrix[jugador1.getPj().getX() - 2][jugador1.getPj().getY()] != 3
						&& matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] == 3) {
					matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
					matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] = 2;
					jugador1.getPj().setX(jugador1.getPj().getX() - 1);
					jugador1.getPj().setJump(1);
				}
			} else if (matrix[jugador1.getPj().getX() - 2][jugador1.getPj().getY()] == 3
					&& matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] == 3) {
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX() - 2][jugador1.getPj().getY()] = 2;
				jugador1.getPj().setX(jugador1.getPj().getX() - 2);
				jugador1.getPj().setJump(1);
			} else if (matrix[jugador1.getPj().getX() - 2][jugador1.getPj().getY()] != 3
					&& matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] == 3) {
				matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
				matrix[jugador1.getPj().getX() - 1][jugador1.getPj().getY()] = 2;
				jugador1.getPj().setX(jugador1.getPj().getX() - 1);
				jugador1.getPj().setJump(1);
			}
		}
	}

	@Override
	public void fall() {

		if (matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] == 6) {

			gameOver = true;

		} else if(matrix[jugador1.getPj().getX()+1][jugador1.getPj().getY()] == 5) {
			
			inGame = false;
			
		} else if (jugador1.getPj().getX() + 1 < matrix.length
				&& matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] != 1
				&& matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] != 4
				&& matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] != 5) {

			matrix[jugador1.getPj().getX()][jugador1.getPj().getY()] = 3;
			matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] = 2;
			jugador1.getPj().setX(jugador1.getPj().getX() + 1);

		} else {
			if (matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] == 1
					|| matrix[jugador1.getPj().getX() + 1][jugador1.getPj().getY()] == 4) {
				jugador1.getPj().setJump(0);

			}
		}

	}
	
	@Override
	public void moverEnemigoDerecha() {

		if (enemigos.find(0).getEnemi().getY() - 1 >= 0) {

			if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() - 1] == 2) {
				gameOver = true;
			}

			else if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() - 1] == 3) {

				matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY()] = 3;
				matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() - 1] = 6;
				enemigos.find(0).getEnemi().setY(enemigos.find(0).getEnemi().getY() - 1);
			}

			else if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() - 1] != 3) {
				enemigos.find(0).getEnemi().setDirection(1);
			}
		}
	}
	
	@Override
	public void moverEnemigoIzquierda() {

		if (enemigos.find(0).getEnemi().getY() + 1 <= matrix[0].length) {

			if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() + 1] == 2) {

				gameOver = true;

			}

			else if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() + 1] == 3) {

				matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY()] = 3;
				matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() + 1] = 6;
				enemigos.find(0).getEnemi().setY(enemigos.find(0).getEnemi().getY() + 1);
			}

			else if (matrix[enemigos.find(0).getEnemi().getX()][enemigos.find(0).getEnemi().getY() + 1] != 3) {
				enemigos.find(0).getEnemi().setDirection(0);
			}
		}
	}

	public LinkedList getEnemigo() {
		return enemigos;
	}

	public void setEnemigo(LinkedList enemigo) {
		this.enemigos = enemigo;
	}

	public void siguienteNivel() {

	}
	
	@Override
	public boolean isGameOver() {
		return gameOver;
	}

	@Override
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	@Override
	public String getQuest() {
		return quest;
	}

	public LinkedList getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(LinkedList enemigos) {
		this.enemigos = enemigos;
	}
	
}
