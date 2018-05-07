/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisección;

/**
 *
 * @author Fabian Miranda
 */
public class Bisección {

    //x^2 - 5x + 6
    public static void main(String[] args) {
        Iterador It = new Iterador("x^2");
        It.iterar(-1.9, 1.4);
    }

}
