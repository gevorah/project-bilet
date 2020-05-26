package model;

public class NodoABB {

	private String nickName;
	private int score;
	private NodoABB left;
	private NodoABB	right;
	
	public NodoABB (int score, String nickName ) {
		this.nickName= nickName;
		this.score= score;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public NodoABB getLeft() {
		return left;
	}

	public void setLeft(NodoABB left) {
		this.left = left;
	}

	public NodoABB getRight() {
		return right;
	}

	public void setRight(NodoABB right) {
		this.right = right;
	}
	
	
}
