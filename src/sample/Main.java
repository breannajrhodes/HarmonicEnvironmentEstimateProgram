package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Harmonic_Client current_client;
    public static Project current_project;
    public static Quote current_quote;
    public static Labor current_labor;
    public static Material current_material;
    public static User current_user;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login_screen.fxml"));
        Scene sceneMain = new Scene(root);
        primaryStage.setScene(sceneMain);
        sceneMain.getStylesheets().add(Main.class.getResource("layout.css").toExternalForm());
        primaryStage.setTitle("Harmonic Environment Estimator");
        //primaryStage.setScene(new Scene(root, 710, 620));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void createNewScene(Event event, String newFileFXML){
     Parent newRoot = null;
        try {
            newRoot = FXMLLoader.load(Main.class.getResource(newFileFXML));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene newScene = new Scene(newRoot);
        newScene.getStylesheets().add(Main.class.getResource("layout.css").toExternalForm());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
}


}
