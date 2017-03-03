package main;

import java.io.IOException;
import java.util.function.Function;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static Stage popup;
	private static Stage primaryStage;
	public static Parent mainLayout;
	public static int port=3307;
	public static String host = "localhost";

	public void start(Stage primaryStage) throws IOException {
		Main.primaryStage = primaryStage;
		popup = new Stage(); 
     //   primaryStage.getIcons().add(new Image("/src/41.png"));
        primaryStage.setTitle("Deep Siam Lab");
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.initOwner(primaryStage);
		showMenu("MainScreen");
	}
	
	public static void showMenu(String screen) throws IOException{
		FXMLLoader loader = new FXMLLoader(); 
		loader.setLocation(Main.class.getResource("/GUI/" + screen + ".fxml"));
		mainLayout = loader.load();
		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.show();
	}
	
	public static void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}

	
	public static void main(String[] args) 
	{
		launch(args);
	}

}


