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
    private final String[] texts = {
        "Try typing this text. Do it as quickly and accurately as you can.",
        "Next type another line of input data.",
        " The quick brown fox jumps over the lazy dog.",
        "Five big quacking zephyrs jolt my wax bed.",
        "Sympathizing would fix Quaker objectives.",
        " A large fawn jumped quickly over white zinc boxes.",
    };
    
    private final String errorMessage = "Function not available";

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        // Keyboard
        Keyboard keyboard = new Keyboard();
        StackPane virtualKeyboard = new StackPane();
        virtualKeyboard.getChildren().add(keyboard.getKeyboard());
        root.setBottom(virtualKeyboard);

        // display text
        TextField textDisplay = new TextField();
        textDisplay.setEditable(false);             // make user unable to edit
        textDisplay.setFocusTraversable(false);          // removes focus
        textDisplay.setMouseTransparent(true);          // for ignoring mouse clicks and events
        textDisplay.setPrefHeight(50);
        root.setTop(textDisplay);
        
        // next button
        Button nextBtn = new Button("Next");
         
        // reset button
        Button resetBtn = new Button("Reset");
        
        // message display label
        Label label = new Label();
        
        Scene scene = new Scene(root, 600, 600);
        
        scene.setOnKeyPressed(event -> {
            keyboard.keyPressed(event.getCode());
        });
        
        scene.setOnKeyReleased(event -> {
            keyboard.keyReleased(event.getCode());
        });
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}