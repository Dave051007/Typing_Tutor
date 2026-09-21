/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.typing_tutor;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Admin
 */
public class Keyboard {
    private VBox keyboard;
    
    public Keyboard() {
        this.keyboard = new VBox(5);     // create new VBox
        keyboard.setAlignment(Pos.CENTER);
        
        createKeyboard();
    }
    
    /**
     * Adds elements to the keyboard field.
     */
    private void createKeyboard() {
//        String[] keys = {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "<----",     // row0
//        "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\",                          // row1
//        "CAPS LOCK","A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "ENTER",                         //row2
//        "SHIFT", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "SHIFT",                             //row3
//        "CTRL", "ALT", "CMD", "SPACE", "CMD", "ALT", "CTRL"                                             //row4
//        };
//        
//        int column = 0;
//        int row = 0;
//        for (String key : keys) {
//            Button button = new Button(key);
//            
//            double width;
//
//            switch (key) {
//                case "<----":
//                    width = 80;
//                    break;
//                case "SPACE":
//                    width = 300;
//                    break;
//                case "TAB":
//                    width = 80;
//                    break;
//                case "SHIFT":
//                    width = 110;
//                    break;
//                case "ENTER":
//                    width = 90;
//                    break;
//                case "CAPS LOCK":
//                    width = 100;
//                    break;
//                default:
//                    width = 50;
//                    break;
//            }
//
//            button.setPrefSize(width, 50);
//            keyboard.add(button, column, row);
//            
//            column++;
//            
//            // change rows
//            if ((row == 0 && column == 14) || 
//                (row == 1 && column == 14) ||
//                (row == 2 && column == 13) ||
//                (row == 3 && column == 12) ||
//                (row == 4 && column == 7))
//            {
//                row++;
//                column = 0;
//            }
//        }
      
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
    private HBox createRow(String[] keys) {
        HBox result = new HBox(5);
       
        for (String key : keys) {
            Button button = new Button(key);
            
            double width;

            switch (key) {
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
            result.getChildren().add(button);
        }
        
        return result;    
    }
    
    /**
     * Returns a GridPane representing a keyboard.
     */
    public VBox getKeyboard() {
        return keyboard; 
    }   
}
