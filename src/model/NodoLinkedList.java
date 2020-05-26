package model;

public class NodoLinkedList {
	
	private NodoLinkedList next;
	
	private EnemyInterface enemy;

	public NodoLinkedList(EnemyInterface enemy) {
		this.enemy = enemy;
	}
	
	public NodoLinkedList getNext() {
		return next;
	}

	public void setNext(NodoLinkedList next) {
		this.next = next;
	}
	
	public EnemyInterface getEnemi() {
		return enemy;
	}

	public void setEnemi(EnemyInterface enemy) {
		this.enemy = enemy;
	}
}
