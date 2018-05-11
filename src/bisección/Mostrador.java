package bisección;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class Mostrador extends JFrame {

    public Mostrador() {
        JPanel PanelIntervalo = new JPanel(new GridLayout(1, 2));
        JPanel PanelRestante = new JPanel(new GridLayout(1, 5));
        JPanel PanelOperandos = new JPanel(new GridLayout(1, 5));
        JPanel PanelNumeros = new JPanel(new GridLayout(4, 3));
        JPanel PanelFunciones = new JPanel(new GridLayout(1, 3));
        JPanel PanelBotones = new JPanel();
        PanelBotones.setLayout(new BoxLayout(PanelBotones, BoxLayout.PAGE_AXIS));
        JPanel PanelEntrada = new JPanel(new GridLayout(1, 1));

        JTextField Entrada = new JTextField();

        SpinnerNumberModel model = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
        JSpinner Intervalo1 = new JSpinner(model);

        SpinnerNumberModel model2 = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
        JSpinner Intervalo2 = new JSpinner(model2);

        PanelIntervalo.add(Intervalo1);
        PanelIntervalo.add(Intervalo2);

        JButton[] Botones = new JButton[9];
        JButton[] OtrosBotones = new JButton[9];
        for (int i = 0; i < Botones.length; i++) {
            Botones[i] = new JButton(Integer.toString(i + 1));
            int j = i + 1;
            Botones[i].addActionListener((ActionEvent e) -> {
                String valoración = Entrada.getText();
                valoración = valoración + j;
                Entrada.setText(valoración);
            });
            PanelNumeros.add(Botones[i]);
        }
        JButton Punto = new JButton(".");
        Punto.addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + ".";
            Entrada.setText(valoración);
        });
        PanelNumeros.add(Punto);
        JButton Boton0 = new JButton("0");
        Boton0.addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "0";
            Entrada.setText(valoración);
        });
        PanelNumeros.add(Boton0);

        OtrosBotones[5] = new JButton("Evaluar");
        OtrosBotones[5].addActionListener((ActionEvent e) -> {
            Iterador I = new Iterador(Entrada.getText());
            I.iterar((Double)Intervalo1.getValue(), (Double)Intervalo2.getValue());
        });
        PanelNumeros.add(OtrosBotones[5]);

        OtrosBotones[0] = new JButton("Ln");
        OtrosBotones[0].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "ln ";
            Entrada.setText(valoración);
        });
        OtrosBotones[1] = new JButton("(");
        OtrosBotones[1].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "(";
            Entrada.setText(valoración);
        });
        OtrosBotones[2] = new JButton(")");
        OtrosBotones[2].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + ")";
            Entrada.setText(valoración);
        });
        OtrosBotones[3] = new JButton("x");
        OtrosBotones[3].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "x";
            Entrada.setText(valoración);
        });
        OtrosBotones[4] = new JButton("←");
        OtrosBotones[4].addActionListener((ActionEvent e) -> {
            if (Entrada.getText().length() != 0) {
                String valoración = Entrada.getText();
                Entrada.setText(valoración.substring(0, valoración.length() - 1));
            }

        });
        PanelRestante.add(OtrosBotones[0]);
        PanelRestante.add(OtrosBotones[1]);
        PanelRestante.add(OtrosBotones[2]);
        PanelRestante.add(OtrosBotones[3]);
        PanelRestante.add(OtrosBotones[4]);

        JButton[] Operandos = new JButton[5];
        Operandos[0] = new JButton("+");
        Operandos[0].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + " + ";
            Entrada.setText(valoración);
        });
        Operandos[1] = new JButton("-");
        Operandos[1].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + " - ";
            Entrada.setText(valoración);
        });
        Operandos[2] = new JButton("*");
        Operandos[2].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + " * ";
            Entrada.setText(valoración);
        });
        Operandos[3] = new JButton("/");
        Operandos[3].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + " / ";
            Entrada.setText(valoración);
        });
        Operandos[4] = new JButton("^");
        Operandos[4].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "^";
            Entrada.setText(valoración);
        });
        PanelOperandos.add(Operandos[0]);
        PanelOperandos.add(Operandos[1]);
        PanelOperandos.add(Operandos[2]);
        PanelOperandos.add(Operandos[3]);
        PanelOperandos.add(Operandos[4]);

        Entrada.setEditable(false);
        PanelEntrada.add(Entrada);

        OtrosBotones[6] = new JButton("Sen");
        OtrosBotones[6].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "Sen ";
            Entrada.setText(valoración);
        });
        OtrosBotones[7] = new JButton("Cos");
        OtrosBotones[7].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "Cos ";
            Entrada.setText(valoración);
        });
        OtrosBotones[8] = new JButton("Tan");
        OtrosBotones[8].addActionListener((ActionEvent e) -> {
            String valoración = Entrada.getText();
            valoración = valoración + "Tan ";
            Entrada.setText(valoración);
        });

        PanelFunciones.add(OtrosBotones[6]);
        PanelFunciones.add(OtrosBotones[7]);
        PanelFunciones.add(OtrosBotones[8]);

        PanelBotones.add(PanelEntrada);
        PanelBotones.add(PanelIntervalo);
        PanelBotones.add(PanelRestante);
        PanelBotones.add(PanelFunciones);
        PanelBotones.add(PanelOperandos);
        PanelBotones.add(PanelNumeros);

        this.add(PanelBotones);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
