package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	
	//width|height|inUse|brand
	public static int DANGER = 200000;
	
	private int width;
	private int heigth;
	private boolean inUse;
	private String brand;
	private boolean isDangerous;
	
	public Billboard(int width, int heigth, boolean inUse, String brand) {
		
		this.width = width;
		this.heigth = heigth;
		this.inUse = inUse;
		this.brand = brand;
		if ( (width*heigth) >= DANGER ) {
			isDangerous = true;
		}else {
			isDangerous = false;
		}
	}

	@Override
	public String toString() {
		return width + "	" + heigth + "	" + inUse + "	" + brand;
	}
	
	public String dagerousBillboard() {
		int area = width * heigth;
		return "Billboard " + brand + " with area " + area;
	}
	public boolean isDangerous() {
		return isDangerous;
	}
	
}
