/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.utils;

import java.awt.Color;
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
