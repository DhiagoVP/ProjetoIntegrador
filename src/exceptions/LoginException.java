/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Acerpc
 */
public class LoginException extends Exception {

    public LoginException() {
    }

    public LoginException(String string) {
        super(string);
    }
}
