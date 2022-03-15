package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.BillboardList;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	private BillboardList billboards = new BillboardList();

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));

			Parent root = loader.load();
			ViewController controller = loader.getController();
			controller.setMain(this);

			Scene scene = new Scene(root);

			Stage newStage = new Stage();
			newStage.setScene(scene);
			newStage.show();
			
			deserialize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void serialize() {
		File file = new File("dataBillboards.class");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(billboards);

			oos.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Serializado");
	}

	public void deserialize() {

		File file = new File("dataBillboards.class");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			billboards = (BillboardList) ois.readObject();
			System.out.println(billboards);

			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	public BillboardList getBillboards() {
		return billboards;
	}
}
