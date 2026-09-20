/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.typing_tutor;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Admin
 */
public class Keyboard {
    private GridPane keyboard;
    
    public Keyboard() {
        this.keyboard = new GridPane();     // create new gridPane
        keyboard.setAlignment(Pos.CENTER);
        keyboard.setHgap(5);
        keyboard.setVgap(5);
        
        createKeyboard();
    }
    
    /**
     * Adds elements to the keyboard field.
     */
    private void createKeyboard() {
        String[] keys = {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "<----",     // row0
        "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\",                          // row1
        "CAPS LOCK","A", "S", "D", "F", "G", "H", "J", "K", "L", ";", "'", "ENTER",                         //row2
        "SHIFT", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "/", "SHIFT",                             //row3
        "CTRL", "ALT", "CMD", "SPACE", "CMD", "ALT", "CTRL"                                             //row4
        };
        
        int column = 0;
        int row = 0;
        for (String key : keys) {
            Button button = new Button(key);
            button.setPrefSize(50, 50);
            
            keyboard.add(button, column, row);
            
            column++;
            
            if ((row == 0 && column == 14) || 
                (row == 1 && column == 14) ||
                (row == 2 && column == 13) ||
                (row == 3 && column == 12) ||
                (row == 4 && column == 7))
            {
                row++;
                column = 0;
            }
        }
    }
    
    /**
     * Returns a GridPane representing a keyboard.
     */
    public GridPane getKeyboard() {
        return keyboard; 
    }   
}
