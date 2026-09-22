/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.typing_tutor;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Admin
 */
public class Keyboard {
    private VBox keyboard;
    private ArrayList<Key> keys;
    
    public Keyboard() {
        this.keys = new ArrayList<>();      // create empty list
        
        this.keyboard = new VBox(5);     // create new VBox
        keyboard.setAlignment(Pos.CENTER);
        
        createKeyboard();
    }
    
    /**
     * Adds elements to the keyboard field.
     */
    private void createKeyboard() {
        String[] row1Keys = {"`", "1\n!", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "<----"};
        String[] row2Keys = {"TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\"};
        String[] row3Keys = {"CAPS LOCK","A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "ENTER"};
        String[] row4Keys = {"SHIFT", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "SHIFT"};
        String[] row5Keys = {"CTRL", "ALT", "CMD", "SPACE", "CMD", "ALT", "CTRL"};
        
        HBox row1 = createRow(row1Keys);
        HBox row2 = createRow(row2Keys);
        HBox row3 = createRow(row3Keys);
        HBox row4 = createRow(row4Keys);
        HBox row5 = createRow(row5Keys);
        
        keyboard.getChildren().addAll(row1, row2, row3, row4, row5);
    }
    
    /**
     * Creates a row of buttons(keys).
     * @param keys an array of string that represents keyboard keys in a row
     * @return an HBox of buttons
     */
    private HBox createRow(String[] keyTexts) {
        HBox result = new HBox(5);
       
        for (String keyText : keyTexts) {
            Button button = new Button(keyText);
            
            double width;

            switch (keyText) {
                case "<----":
                    width = 80;
                    break;
                case "SPACE":
                    width = 300;
                    break;
                case "TAB":
                    width = 80;
                    break;
                case "SHIFT":
                    width = 110;
                    break;
                case "ENTER":
                    width = 90;
                    break;
                case "CAPS LOCK":
                    width = 100;
                    break;
                default:
                    width = 50;
                    break;
            }

            button.setPrefSize(width, 50);
            
            // key creation + adding to keys
            KeyCode keyCode = getKeyCode(keyText);      
            Key key = new Key(keyCode, button);                 
            keys.add(key);                                      
            
            result.getChildren().add(button);                   
        }
        
        return result;    
    }
    
    /**
     * Gets the KeyCode of special keys and alphabetical keys.
     * @param keyText the text displayed on the keyboard key
     * @return the KeyCode corresponding to the given key text
     */
    private KeyCode getKeyCode(String keyText) {
        switch (keyText) {
            case "<----":
                return KeyCode.BACK_SPACE;

            case "CAPS LOCK":
                return KeyCode.CAPS;

            case "SPACE":
                return KeyCode.SPACE;

            case "TAB":
                return KeyCode.TAB;

            case "ENTER":
                return KeyCode.ENTER;

            case "SHIFT":
                return KeyCode.SHIFT;

            case "CTRL":
                return KeyCode.CONTROL;

            case "ALT":
                return KeyCode.ALT;

            case "CMD":
                return KeyCode.META;

            case "\\":
                return KeyCode.BACK_SLASH;

            case "[":
                return KeyCode.OPEN_BRACKET;

            case "]":
                return KeyCode.CLOSE_BRACKET;

            case ";":
                return KeyCode.SEMICOLON;

            case "'":
                return KeyCode.QUOTE;

            case ",":
                return KeyCode.COMMA;

            case ".":
                return KeyCode.PERIOD;

            case "/":
                return KeyCode.SLASH;

            case "-":
                return KeyCode.MINUS;

            case "=":
                return KeyCode.EQUALS;

            case "`":
                return KeyCode.BACK_QUOTE;

            default:
                return KeyCode.getKeyCode(keyText);
        }
    }
    
    /**
     * Changes the background color of a Key button.
     * @param keyCode the keyCode associated to the Key button.
     */
    public void keyPressed(KeyCode keyCode) {
        for (Key key : keys) {
            if (key.getKeyCode() == keyCode) {
                key.getButton().setStyle("-fx-background-color: lightgrey;");
            }
        }
    }
    
    /**
     * Returns a GridPane representing a keyboard.
     */
    public VBox getKeyboard() {
        return keyboard; 
    }   
}
