package model;

import java.io.Serializable;

public class Story implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Line root;
	public Line getRoot() {
		return root;
	}
	public static final int LVLONE1 = 90;
	public static final int LVLONE2 = 30;
	public static final int LVLTWO1 = 100;
	public static final int LVLTWO2 = 70;
	public static final int LVLTWO3 = 10;
	public static final int LVLTHREE1 = 75;
	public static final int LVLTHREE2 = 20;
	public static final int LVLFOUR1 = 80;
	public static final int LVLFOUR2 = 25;
	public static final int LVLFOUR3 = 15;
	public static final int WIN = 13;
	public Story() {
	}
	public void add(int value, String data, boolean free) {
		root = add(root,value,data,free);
	}
	private Line add(Line current, int value, String data, boolean free) {
		if(current==null) return new Line(value, data, free);
	    if(value<current.value) {
	        current.left = add(current.left,value,data,free);
	    } else if(value>current.value) {
	        current.right = add(current.right,value,data,free);
	    } else {
	        return current;
	    }
		return current;
	}
	public Line search(int value) {
		return search(root,value);
	}
	private Line search(Line current, int value) {
		if(current==null) return null;
		if(current.value==value) return current;
		return current.value>value?search(current.left,value):search(current.right,value);
	}
	public void modify(int value, boolean free) {
		search(value).free = free;
	}
	public class Line implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int value;
		private String data;
		private boolean free;
		private Line left;
		private Line right;
		public Line(int value, String data, boolean free) {
			this.value = value;
			this.data = data;
			this.free = free;
		}
		public int getValue() {
			return value;
		}
		public Line getLeft() {
			return left;
		}
		public Line getRight() {
			return right;
		}
		public String getData() {
			return data;
		}
		public boolean isFree() {
			return free;
		}
	}
}
