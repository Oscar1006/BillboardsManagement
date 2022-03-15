package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ViewController{
	Main main;
	
	public void setMain(Main m) {
		main = m;
	}


    @FXML
    private TextArea txtPath;	
    @FXML
    private TextField txtBillboard;

    @FXML
    public void importData() {
    	String path = txtPath.getText();
    	main.getBillboards().loadBillboards(path);
    	main.serialize();
    }
    
    @FXML
    public void addBillboard() {
    	String newBillboard = txtBillboard.getText();
    	main.getBillboards().addBillboard(newBillboard);
    	main.serialize();
    }
    
    @FXML
    public void showBillboards() {
    	String text = main.getBillboards().showBillboards();
    	System.out.println(text);
    }
    
    @FXML
    public void exportDangerReport() {
    	String report = main.getBillboards().dangerReport();
    	System.out.println(report);
    }


    

}
