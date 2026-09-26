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
import javafx.scene.input.KeyCode;
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
        "The quick brown fox jumps over the lazy dog.",
        "Five big quacking zephyrs jolt my wax bed.",
        "Sympathizing would fix Quaker objectives.",
        "A large fawn jumped quickly over white zinc boxes.",
    };
    
    private final String errorMessage = "Function not available";
    
    private int count = 1;

    private int correctKeyStrokes = 0;
    private int incorrectKeyStrokes = 0;
    private int typedPosition = 0;
            
    private Label accuracyLabel = new Label("Accuracy: 100%");
    
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
        root.add(textTyped, 0, 3);
        
        // error message label
        Label errorLabel = new Label();
        root.add(errorLabel, 0, 2);
        errorLabel.setStyle("-fx-text-fill: red;");
        
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
        
        // correct and incorrect number of keystrokes display label
        Label correct = new Label("Correct: ");
        root.add(correct, 1, 3);
        Label incorrect = new Label("Incorrect: ");
        root.add(incorrect, 1, 4);
        root.setValignment(incorrect, VPos.TOP);
        
        // accuracy label
        root.add(accuracyLabel, 1, 5);
        
        nextBtn.setOnAction(event -> {
            if (count >= 6) {
                errorLabel.setText("You have reached the limit of available texts, please reset");
                return;
            }
            
            errorLabel.setText("");
            
            count++;
            
            textTyped.clear();
            textTyped.setEditable(true);
            
            countLabel.setText(count + " of 6 texts");
            textDisplay.setText(texts[count - 1]);
            typedPosition = 0;
        });
         
        // reset button
        Button resetBtn = new Button("Reset");
        resetBtn.setFocusTraversable(false);
        resetBtn.setMinHeight(30);
        resetBtn.setMinWidth(100);
        root.add(resetBtn, 1, 1);
        
        resetBtn.setOnAction(event -> {
           errorLabel.setText("");
           
           count = 1;
           
           textTyped.clear();
           textTyped.setEditable(true);
           
           countLabel.setText(count + " of 6 texts");
           textDisplay.setText(texts[count - 1]);
           
           typedPosition = 0;
           incorrectKeyStrokes = 0;
           correctKeyStrokes = 0;
           
           correct.setText("Correct: ");
           incorrect.setText("Incorrect: ");
        });
        
        Scene scene = new Scene(root, 800, 500);
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {       // event filter: get event during capture phase
            keyboard.keyPressed(event.getCode());
            
            errorLabel.setText("");                     // clears after pressing available key

            if (isUnavailableKey(event)) {
                errorLabel.setText(errorMessage);
                
                event.consume();                              // prevent unavailable keys from performing
                return;
            }
            
            // prevents ctrl + backspace.
            if (event.isControlDown()) {
                errorLabel.setText("Ctrl combinations are unavailable");
                
                event.consume();
                return;
            }
             
            // Back space
            if (event.getCode() == KeyCode.BACK_SPACE) {
                if (typedPosition > 0) {
                    typedPosition--;
                }
                
                return;
            }
            
            // prevent shift from producing character
            if (isShiftPressed(event)) {
                if (event.getCode() == KeyCode.SHIFT) {
                    return;
                }
            }
            
            String typedText = event.getText();
            
            if (typedText == null || typedText.isEmpty()) {
                return;
            }
            
            // prevent typing when text is completed
            if (typedPosition >= textDisplay.getText().length()) {          
                textTyped.setEditable(false);
                
                errorLabel.setText("Text complete. Press Next to continue.");
                
                event.consume();
                return;
            }
            
            char correctLetter = textDisplay.getText().charAt(typedPosition);
            char typedLetter = typedText.charAt(0);
            
            // handles shift + letter
             if (isShiftPressed(event)) {
                typedLetter = Character.toUpperCase(typedLetter);
            }

            if (typedLetter == correctLetter) {            // compare text typed and correct letter
                correctKeyStrokes++;
                correct.setText("Correct: " + correctKeyStrokes);
            } else {
                incorrectKeyStrokes++;
                incorrect.setText("Incorrect: " + incorrectKeyStrokes);
            }   

            typedPosition++;
        });
        
        scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> {
            keyboard.keyReleased(event.getCode());
        });
        
        stage.setScene(scene);
        stage.show();
    }
    
    /**
    * Checks if a key is unavailable.
    * @param event the key event containing the key that was pressed
    * @return true if the key is unavailable, false otherwise
    */
    private boolean isUnavailableKey(KeyEvent event) {
    switch (event.getCode()) {
        case F1:
        case F2:
        case F3:
        case F4:
        case F5:
        case F6:
        case F7:
        case F8:
        case F9:
        case F10:
        case F11:
        case F12:
        case INSERT:
        case HOME:
        case PAGE_UP:
        case PAGE_DOWN:
        case END:
        case TAB:
        case ALT:
        case CONTROL:
        case ENTER:
        case NUMPAD0:
        case NUMPAD1:
        case NUMPAD2:
        case NUMPAD3:
        case NUMPAD4:
        case NUMPAD5:
        case NUMPAD6:
        case NUMPAD7:
        case NUMPAD8:
        case NUMPAD9:
        case ADD:
        case SUBTRACT:
        case MULTIPLY:
        case DIVIDE:
        case DECIMAL:
            return true;

        default:
            return false;
        }
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    /**
     * Checks if shift is pressed
     * @param event the event being checked
     * @return true if shift is pressed, else false
     */
    private boolean isShiftPressed(KeyEvent event) {
        return event.isShiftDown();
    }
}
