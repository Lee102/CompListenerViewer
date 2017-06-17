/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.KeyboardClick;
import java.util.Collection;
import javafx.scene.control.TextArea;

/**
 *
 * @author Łukasz Wojtas
 */
public class KeyboardClickTextArea {

    public static void getTextAreaInc(TextArea keyboardClickTextArea, Collection<KeyboardClick> keyboardClickCollection) {
        String text = new String();

        if (keyboardClickCollection != null) {
            for (KeyboardClick keyboardClick : keyboardClickCollection) {
                if (keyboardClick.getKeyText().length() == 1 && keyboardClick.getKeyText().charAt(0) >= 'A' && keyboardClick.getKeyText().charAt(0) <= 'Z') {
                    text += keyboardClick.getKeyText();
                } else if (keyboardClick.getKeyText().compareTo("Space") == 0) {
                    text += ' ';
                } else if (keyboardClick.getKeyText().compareTo("Enter") == 0) {
                    text += "\n";
                } else if (keyboardClick.getKeyText().compareTo("Backspace") == 0) {
                    text = text.substring(0, text.length() - 1);
                }
            }
        }

        keyboardClickTextArea.setText(text);
    }

    public static void getTextAreaExc(TextArea keyboardClickTextArea, Collection<KeyboardClick> keyboardClickCollection) {
        String text = new String();

        if (keyboardClickCollection != null) {
            for (KeyboardClick keyboardClick : keyboardClickCollection) {
                if (keyboardClick.getKeyText().length() == 1 && keyboardClick.getKeyText().charAt(0) >= 'A' && keyboardClick.getKeyText().charAt(0) <= 'Z') {
                    text += keyboardClick.getKeyText();
                } else if (keyboardClick.getKeyText().compareTo("Space") == 0) {
                    text += ' ';
                } else if (keyboardClick.getKeyText().compareTo("Enter") == 0) {
                    text += "\n";
                }
            }
        }

        keyboardClickTextArea.setText(text);
    }

}
