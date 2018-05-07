/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisección;

public class Iterador {

    Ecuación Ec;

    public Iterador(String ecuación) {
        Ec = new Ecuación(ecuación);
    }

    public void iterar(double izq, double der) {
        if ((der - izq) <= 0.001) {
            System.out.println("Se encontró el límite entre " + izq + " - " + der);
        } else {
            double mitad = (izq + der) / 2;
            double funizq = Ec.evaluarEcuación(izq);
            double funder = Ec.evaluarEcuación(der);
            double funmit = Ec.evaluarEcuación(mitad);
            
            System.out.println("-------------------------------------");
            System.out.println("Izquierda: f(" + izq + ") = " + funizq);
            System.out.println("Mitad: f(" + mitad + ") = " + funmit);
            System.out.println("Derecha: f(" + der + ") = " + funder);

            if ((funizq > 0 && funmit < 0) || (funizq < 0 && funmit > 0)) {
                System.out.println("Nuevo intervalo " + izq + " y " + mitad );
                iterar(izq, mitad);
            } else if ((funder < 0 && funmit > 0) || (funder > 0 && funmit < 0)) {
                System.out.println("Nuevo intervalo  " + mitad + " y " + der );
                iterar(mitad, der);
            } else {
                System.out.println("No se puede seguir iterando");
                if (funizq == 0) {
                    System.out.println("La raiz es " + izq);
                } else if (funder == 0) {
                    System.out.println("La raiz es " + der);
                } else if (funmit == 0) {
                    System.out.println("La raiz es " + mitad);
                } else {
                    System.out.println("Nunca toca X");
                }
            }
        }
    }

}
