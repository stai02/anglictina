package com.github.stai02.anglictina.main;

import com.github.stai02.anglictina.logika.Hra;
import com.github.stai02.anglictina.ui.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
	public static void main(String[] args) {
        launch(args);
}

	@Override
	public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass()
        		.getResource("Home.fxml"));
        Parent root = loader.load();

        Controller c = loader.getController();

        Hra hra = new Hra();
        c.initialize(hra);
        
        primaryStage.setTitle("Angličtina");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
               
        
}

  
}
