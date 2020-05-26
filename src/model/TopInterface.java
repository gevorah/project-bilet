package model;

public interface TopInterface {
	
	public void add(int value, String data);
	
	
	public NodoABB add(NodoABB current, int value, String data);
	
	
	public String recorridoInorden();
	
	public void ayudanteInorden(NodoABB nodo);
	
	
	
	

}
