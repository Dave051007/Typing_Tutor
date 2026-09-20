/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.typing_tutor;

import javafx.geometry.Pos;
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
    }
    
    /**
     * Returns a GridPane representing a keyboard.
     */
    public GridPane Keyboard() {
        return keyboard; 
    }   
}
