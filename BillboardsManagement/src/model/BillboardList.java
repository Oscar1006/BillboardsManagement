package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class BillboardList implements Serializable {
	// width|height|inUse|brand

	ArrayList<Billboard> billboards;

	public BillboardList() {
		billboards = new ArrayList<>();
	}

	public void loadBillboards(String path) {
		File file = new File(path);

		FileReader fr;
		try {
			fr = new FileReader(file);

			BufferedReader input = new BufferedReader(fr);

			input.readLine();

			while (input.ready()) {

				String line = input.readLine();
				String[] data = line.split("\\|");

				int whidth = Integer.parseInt(data[0]);
				int height = Integer.parseInt(data[1]);

				boolean inUse = Boolean.parseBoolean(data[2]);

				String brand = data[3];
				addBillboard(whidth, height, inUse, brand);
			}

			input.close();
			fr.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addBillboard(int w, int h, boolean inUse, String brand) {
		Billboard b = new Billboard(w, h, inUse, brand);
		billboards.add(b);
	}
	
	public void addBillboard(String text) {
		String[] data = text.split("\\+\\+");
		
		int whidth = Integer.parseInt(data[0]);
		int height = Integer.parseInt(data[1]);

		boolean inUse = Boolean.parseBoolean(data[2]);

		String brand = data[3];
		addBillboard(whidth, height, inUse, brand);
	}
	public String showBillboards() {
		String text = "W	H	inUse	Brand \n";
		int totalBillboards = 0;
		for (Billboard b : billboards) {
			text += "\n" + b.toString();
			totalBillboards++;
		}
		text += "\n TOTAL: " + totalBillboards + " billboards";
		
		return text;
	}
	public String dangerReport() {
		String report = "===========================\r\n"
						+ "DANGEROUS BILLBOARD REPORT\r\n"
						+ "===========================\r\n"
						+ "The dangerous billboard are:\r\n";
		
		int num = 0;
		for (Billboard b: billboards) {
			if(b.isDangerous()) {
				num++;
				report += num + ". " + b.dagerousBillboard();	
			}
		}
		writeFile(report);
		return report;
	}
	public void writeFile(String text)  {
		File file = new File("report.txt");
		
		FileWriter fw;
		try {
			fw = new FileWriter(file);

			BufferedWriter output = new BufferedWriter(fw);
			
			output.write(text);
			
			output.close();
			fw.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
