/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form.login;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Acerpc
 */
public class teste {
    public static String criptografar(String valor) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        //Note que o Algoritmo de criptografia é fornecido por parâmetro.
        //Nesse caso 'MD5' poderia ser 'SHA1'.
        MessageDigest md = MessageDigest.getInstance("MD5");

        //A instância de MessageDigest foi atualizada com o valor da String 
        //fornecida como parâmetro, neste caso foi fornecida a codificação 
        //para obtenção dos bytes da String, mas esse parâmetro é opcional.
        md.update(valor.getBytes("UTF8"));

        //É nesse ponto que é gerado um array de bytes contendo o resultado 
        //da criptografia utilizando o Algoritmo fornecido.
        byte[] s = md.digest();

        //Como precisamos do hash em String precisamos executar os seguintes
        //três passos básicos para tal necessidade:
        BigInteger hash1 = new BigInteger(1, s);
        String hash = hash1.toString(16);
        while (hash.length() < 32) {
            hash = "0" + hash;
        }

        return hash;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String senha1 = "3055980";
        String senha2 = "305598";
        System.out.println("senha 1: " + senha1 + "/n Senha 2: " + senha2);
        System.out.println("Senha 1 crip: " + criptografar(senha1));
        System.out.println("Senha 2 crip: " + criptografar(senha2));
    }
}
