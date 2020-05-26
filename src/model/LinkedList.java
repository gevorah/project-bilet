package model;

public class LinkedList {
	
	private NodoLinkedList first;
	
	public NodoLinkedList getFirst() {
		return first;
	}

	public void setFirst(NodoLinkedList first) {
		this.first = first;
	}

	public LinkedList() {
		
	}
	
	public void add(EnemyInterface enemy) {
		if(first==null) {
			first = new NodoLinkedList(enemy);
		}else {
			NodoLinkedList temp = first;
			while(temp.getNext()!=null) {
				temp= temp.getNext();
			}
			temp.setNext(new NodoLinkedList(enemy));
		}
	}
	
	public NodoLinkedList find(int index) {
		NodoLinkedList nodo = first;
		for (int i = 0; i < index && i < count(); i++) {
			if(nodo==null) {
				break;
			}else{
				nodo = nodo.getNext();
			}
		}
		return nodo;
	}
	
	public int count() {
		int i = 0;
		NodoLinkedList temp = first;
		while(temp!=null) {
			i++;
			temp = temp.getNext();
		}
		return i;
	}
	
}
