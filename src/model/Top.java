package model;

public class Top implements TopInterface {

	private NodoABB root;
	private String ordenado;

	public Top() {

	}
	
	@Override
	public void add(int value, String data) {
		root = add(root, value, data);
	}
	
	@Override
	public NodoABB add(NodoABB current, int value, String data) {
		if (current == null)
			return new NodoABB(value, data);
		if (value < current.getScore()) {
			current.setLeft(add(current.getLeft(), value, data));
		} else if (value > current.getScore()) {
			current.setRight(add(current.getRight(), value, data));
		} else {
			return current;
		}
		return current;
	}

	public NodoABB search(int value) {
		return recursiveSearch(root, value);
	}

	public NodoABB recursiveSearch(NodoABB current, int value) {
		if (current == null)
			return null;
		if (current.getScore() == value)
			return current;
		return current.getScore() > value ? recursiveSearch(current.getLeft(), value)
				: recursiveSearch(current.getRight(), value);
	}
	@Override
	public String recorridoInorden() {
		ordenado = "";
		ayudanteInorden(root);
		return ordenado;
	}
	@Override
	public void ayudanteInorden(NodoABB nodo) {
		if (nodo == null) {
			
			return;
		}else {
		ayudanteInorden(nodo.getLeft());
		ordenado += nodo.getNickName() + nodo.getScore() + " \n";
		ayudanteInorden(nodo.getRight());
		}
	}
}
