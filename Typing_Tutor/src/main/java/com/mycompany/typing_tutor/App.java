package com.mycompany.typing_tutor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Keyboard keyboard = new Keyboard();
        BorderPane root = new BorderPane();

        StackPane virtualKeyboard = new StackPane();
        virtualKeyboard.getChildren().add(keyboard.getKeyboard());

        root.setCenter(virtualKeyboard);

        Scene scene = new Scene(root, 600, 600);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}