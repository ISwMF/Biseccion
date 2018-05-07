/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisección;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Ecuación {

    String ecuación;
    String[] componentes;

    public Ecuación(String ecu) {
        this.ecuación = ecu;
        this.ecuación = this.ecuación.replace(" ", "");
        for (int i = 1; i < ecuación.length(); i++) {
            if (ecuación.charAt(i) == 'x') {
                if (Character.isDigit(ecuación.charAt(i - 1))) {
                    ecuación = ecuación.substring(0, i) + "*" + ecuación.substring(i, ecuación.length());
                }
            }
        }
        componentes = new String[ecuación.length()];

    }

    public double evaluarEcuación(double x) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i] = Character.toString(ecuación.charAt(i));
        }
        String ecuaciónEval = "";
        String[] componentesAUX = componentes;
        for (int i = 0; i < componentesAUX.length; i++) {
            if (componentesAUX[i].equals("x")) {
                componentesAUX[i] = String.valueOf(x);
            }
        }
        for (int i = 0; i < componentesAUX.length; i++) {
            if (i < componentesAUX.length - 1) {
                if (componentesAUX[i + 1].equals("^")) {
                    double valExponente = Math.pow(Double.parseDouble(componentesAUX[i]), Double.parseDouble(componentesAUX[i + 2]));
                    ecuaciónEval = ecuaciónEval + valExponente;
                    i = i + 2;
                } else {
                    ecuaciónEval = ecuaciónEval + componentesAUX[i];
                }
            } else {
                ecuaciónEval = ecuaciónEval + componentesAUX[i];
            }
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine interprete = manager.getEngineByName("js");
        String solución = "";

        try {
            solución = interprete.eval(ecuaciónEval).toString();
        } catch (ScriptException se) {
            System.out.println(se.getMessage());
        }
        return Double.parseDouble(solución);
    }
}
