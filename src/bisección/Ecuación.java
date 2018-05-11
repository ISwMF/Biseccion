/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bisección;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Ecuación {

    String equation;
    String[] componentes;

    public Ecuación(String ecu) {
        this.equation = ecu;
        this.equation = this.equation.replace(" ", "");
        for (int i = 1; i < equation.length(); i++) {
            if (equation.charAt(i) == 'x') {
                if (Character.isDigit(equation.charAt(i - 1))) {
                    equation = equation.substring(0, i) + "*" + equation.substring(i, equation.length());
                }
            }
        }
        componentes = new String[equation.length()];
    }

    public double evaluarEcuacion(String x) {
        String equa = this.equation;
        for (int i = 0; i < equa.length(); i++) {
            if (equa.charAt(i) == ')') {
                for (int j = i; j > 0; j--) {
                    if (equa.charAt(j) == '(') {
                        equa = equa.replace(equa.substring(j, (i + 1)), resolverEcuacion(equa.substring(j, (i + 1)), x));
                        if (equa.contains("(") || equa.contains(")")) {
                            i = 0;
                        }
                        break;
                    }
                }
            }
        }
        return Double.parseDouble(resolverEcuacion(equa, x));
    }

    public String resolverEcuacion(String ecua, String x) {
        ArrayList<String> comp = obtenerComponentes(ecua);
        String resultado = "";
        for (int i = 0; i < comp.size(); i++) {
            comp.set(i, comp.get(i).replace("(", ""));
            comp.set(i, comp.get(i).replace(")", ""));
            if (comp.get(i).contains("x")) {
                String recuperar = comp.get(i).replace("x", x);
                comp.set(i, recuperar);
            }
            if (comp.get(i).contains("Tan")) {
                double angulo = Double.parseDouble(comp.get(i).substring(comp.get(i).indexOf("n") + 1, comp.get(i).length())) * Math.PI / 180.0;
                comp.set(i, String.valueOf(Math.tan(angulo)));
            }
            if (comp.get(i).contains("Cos")) {
                double angulo = Double.parseDouble(comp.get(i).substring(comp.get(i).indexOf("s") + 1, comp.get(i).length())) * Math.PI / 180.0;
                comp.set(i, String.valueOf(Math.cos(angulo)));
            }
            if (comp.get(i).contains("Sen")) {
                double angulo = Double.parseDouble(comp.get(i).substring(comp.get(i).indexOf("n") + 1, comp.get(i).length())) * Math.PI / 180.0;
                comp.set(i, String.valueOf(Math.sin(angulo)));
            }
            if (comp.get(i).contains("ln")) {
                double logaritmo = Math.log(Double.parseDouble(comp.get(i).substring(comp.get(i).indexOf("n") + 1, comp.get(i).length())));
                comp.set(i, String.valueOf(logaritmo));
            }
        }
        for (int i = 0; i < comp.size(); i++) {
            if (i == comp.size() - 1) {
                resultado = resultado + comp.get(i);
            } else {
                if (comp.get(i + 1).contains("^")) {
                    double asd = Math.pow(Double.parseDouble(comp.get(i)), Double.parseDouble(comp.get(i + 2)));
                    resultado = resultado + asd;
                    i = i + 2;
                } else {
                    resultado = resultado + comp.get(i);
                }
            }
        }
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine interprete = manager.getEngineByName("js");
        String solución = "";
        try {
            solución = interprete.eval(resultado).toString();
        } catch (ScriptException se) {
            System.out.println(se.getMessage());
        }
        return solución;
    }

    public ArrayList<String> obtenerComponentes(String equation) {
        ArrayList<String> Componentes = new ArrayList<>();
        int contador = 0;
        for (int i = 0; i < equation.length(); i++) {
            switch (equation.charAt(i)) {
                case '+':
                    Componentes.add(equation.substring(contador, i));
                    Componentes.add("+");
                    contador = i + 1;
                    break;
                case '-':
                    Componentes.add(equation.substring(contador, i));
                    Componentes.add("-");
                    contador = i + 1;
                    break;
                case '*':
                    Componentes.add(equation.substring(contador, i));
                    Componentes.add("*");
                    contador = i + 1;
                    break;
                case '/':
                    Componentes.add(equation.substring(contador, i));
                    Componentes.add("/");
                    contador = i + 1;
                    break;
                case '^':
                    Componentes.add(equation.substring(contador, i));
                    Componentes.add("^");
                    contador = i + 1;
                    break;
                default:
                    break;
            }
        }
        Componentes.add(equation.substring(contador));
        System.out.println(Componentes);
        return Componentes;
    }
}
