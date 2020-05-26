package model;

public interface PrincipalClassInterface {

	public void loadQuest();

	public void loadMap();
	
	public void moverDerecha();

	public void moverIzquierda();

	public void fall();

	public void moverEnemigoDerecha();

	public void moverEnemigoIzquierda();

	public void moverArriba();

	public int[][] getMatrix();

	public String getQuest();

	public boolean isGameOver();

	public boolean isInGame();

	public void setGameOver(boolean b);
}
