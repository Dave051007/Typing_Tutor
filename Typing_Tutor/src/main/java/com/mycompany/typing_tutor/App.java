package com.mycompany.typing_tutor;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    
    private int count = 1;

    @Override
    public void start(Stage stage) {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));

        // Keyboard
        Keyboard keyboard = new Keyboard();
        StackPane virtualKeyboard = new StackPane();
        virtualKeyboard.getChildren().add(keyboard.getKeyboard());
        root.add(virtualKeyboard, 0, 4);
        
        // display text
        TextField textDisplay = new TextField();
        textDisplay.setEditable(false);             // make user unable to edit
        textDisplay.setFocusTraversable(false);          // removes focus
        textDisplay.setMouseTransparent(true);          // for ignoring mouse clicks and events
        textDisplay.setPrefHeight(50);
        root.add(textDisplay, 0, 0);
        
        textDisplay.setText(texts[count - 1]);
        
        // typed texts
        TextField textTyped = new TextField();
        textTyped.setFocusTraversable(false);
        root.add(textTyped, 0, 3);
        
        // error message label
        Label errorLabel = new Label();
        root.add(errorLabel, 0, 2);
        
        // text count label
        Label countLabel = new Label(count + " of 6 texts");
        root.add(countLabel, 0, 1);
        root.setValignment(countLabel, VPos.TOP);
        
        // next button
        Button nextBtn = new Button("Next");
        nextBtn.setFocusTraversable(false);
        nextBtn.setMinHeight(30);
        nextBtn.setMinWidth(100);
        root.add(nextBtn, 1, 0);
        
        nextBtn.setOnAction(event -> {
            if (count >= 6) {
                errorLabel.setText("You have reached the limit of available texts, please reset");
                return;
            }
            
            count++;
            countLabel.setText(count + " of 6 texts");
            textDisplay.setText(texts[count - 1]);
        });
         
        // reset button
        Button resetBtn = new Button("Reset");
        resetBtn.setFocusTraversable(false);
        resetBtn.setMinHeight(30);
        resetBtn.setMinWidth(100);
        root.add(resetBtn, 1, 1);
        
        resetBtn.setOnAction(event -> {
           count = 1;
           errorLabel.setText("");
           countLabel.setText(count + " of 6 texts");
           textDisplay.setText(texts[count - 1]);
        });
        
        // message display label
        Label label = new Label();
        
        Scene scene = new Scene(root, 800, 500);
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {       // event filter: get event during capture phase
            keyboard.keyPressed(event.getCode());
        });
        
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            keyboard.keyReleased(event.getCode());
        });
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}