package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PrincipalClass {

	private BufferedReader br;

	private int[][] matrix;

	private String archiveR;

	public PrincipalClass(String r) {

		archiveR = r;
		loadMap();

	}

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
		
		for(int i = 0 ; i<matrix.length;i++) {
			try {
				line = br.readLine();
				String[] fila = line.split(",");
				
				for(int j = 0 ; j < fila.length;j++) {
					
					matrix[i][j] = Integer.parseInt(fila[j]);
				
				}
				
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
