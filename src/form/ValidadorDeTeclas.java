/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.awt.event.KeyEvent;

/**
 *
 * @author Acerpc
 */
public class ValidadorDeTeclas {
    public void validarSomenteLetras(KeyEvent evt) {
    String caracteres = "0987654321´`[]{}^~:;.,<>_)(*&¨%$#@!'-=+§ªº?'/|°¬¢£³²¹";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
}
    public void validarSomenteNumeros(KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    public void validarNumerosComPonto(KeyEvent evt) {
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
    
    public void validarSomenteLetrasENumeros(KeyEvent evt) {
    String caracteres = "´`[]{}^~:;.,<>_)(*&¨%$#@!'-=+§ªº?'/|°¬¢£³²¹";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }
}