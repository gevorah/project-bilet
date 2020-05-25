package model;

public class Story {
	private Line root;
	public Story() {
	}
	public void add(int value, String data) {
		root = add(root,value,data);
	}
	private Line add(Line current, int value, String data) {
		if(current==null) return new Line(value, data);
	    if(value<current.value) {
	        current.left = add(current.left,value,data);
	    } else if(value>current.value) {
	        current.right = add(current.right,value,data);
	    } else {
	        return current;
	    }
		return current;
	}
	public String search(int value) {
		return recursiveSearch(root,value);
	}
	private String recursiveSearch(Line current, int value) {
		if(current==null) return null;
		if(current.value==value) return current.data;
		return current.value>value?recursiveSearch(current.left,value):recursiveSearch(current.right,value);
	}
	public void delete(int value) {
		root = delete(root,value);
	}
	private Line delete(Line current,int value) {
	    if(current==null) return null;
	    if(current.value==value) {
	    	if(current.left==null && current.right==null) return null;
	    	if(current.right == null) return current.left;
	    	if(current.left == null) return current.right;
	    	int minimum = findMinimum(current.right);
	    	current.value = minimum;
	    	current.right = delete(current.right,minimum);
	    	return current;
	    } 
	    if(current.value>value) {
	        current.left = delete(current.left,value);
	        return current;
	    } else {
	    	current.right = delete(current.right,value);
	    	return current;
	    }
	}
	private int findMinimum(Line root) {
	    return root.left==null?root.value:findMinimum(root.left);
	}
	private class Line {
		private int value;
		private String data;
		private Line left;
		private Line right;
		public Line(int value, String data) {
			this.value = value;
			this.data = data;
		}
	}
}
