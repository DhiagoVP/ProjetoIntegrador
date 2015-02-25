/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Aluno
 */
public class Comparador implements java.util.Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Professor p1 = (Professor) o1;
            Professor p2 = (Professor) o2;

            return p1.getNome().compareTo(p2.getNome());
        }
    }
