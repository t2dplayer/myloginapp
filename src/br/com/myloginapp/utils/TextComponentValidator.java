/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.utils;

import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

/**
 *
 * @author sergi
 */
public class TextComponentValidator {
    public static void checkIsEqualsTextComponent(JFrame frame, 
            JTextComponent c1, 
            JTextComponent c2) {
        List<JTextComponent> list = Arrays.asList(
                c1,
                c2
        );
        if (!TextValidator.isEquals(c1, c2)) {
            // TODO: Melhorar isso aqui!!!
            JOptionPane.showMessageDialog(frame,
                "O texto do campo " + c1.getToolTipText() + " é diferente do campo " + c2.getToolTipText(), 
                "Mensagem de Erro", 
                JOptionPane.ERROR_MESSAGE
            );
            for (JTextComponent item: list) {
                item.setBorder(new LineBorder(Color.red, 3));
            }            
        } else {
            for (JTextComponent item: list) {
                item.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
                SwingUtilities.updateComponentTreeUI(item);
            }             
        }
    }
    public static void checkIsEmptyTextComponent(JFrame frame, List<JTextComponent> list) {
        for (JTextComponent item: list) {
            item.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
            SwingUtilities.updateComponentTreeUI(item);
            if (TextValidator.isEmpty(item)) {
                JOptionPane.showMessageDialog(frame,
                        "Preencha o campo: " + item.getToolTipText(), 
                        "Mensagem de Erro", 
                        JOptionPane.ERROR_MESSAGE
                );
                item.requestFocus();
                item.setBorder(new LineBorder(Color.red, 3));
                break;
            }
        }
    }
}
