/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.utils;

import javax.swing.text.JTextComponent;

/**
 *
 * @author sergi
 */
public class TextValidator {
    public static boolean isEmpty(JTextComponent c) {
        return c.getText().length() == 0;
    }
    public static boolean isEquals(JTextComponent c1, JTextComponent c2) {
        return c1.getText().equals(c2.getText());
    }
}
