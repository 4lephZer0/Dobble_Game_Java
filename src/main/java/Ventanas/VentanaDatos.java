package Ventanas;

import Dobble.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VentanaDatos extends JFrame {
    JPanel panel = new JPanel();
    JLabel texto = new JLabel();
    JLabel logo = new JLabel();
    JTextField espacioTexto = new JTextField();
    VentanaDatos app;

    int maxC;
    int numE;
    int cantJug;
    int n;
    List<String> elements;
    Dobble mazo;
    DobbleGame juego = null;

    public VentanaDatos(int n, int maxC, int numE, List<String> elements, int cantJug){
        this.n = n;
        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;
        this.cantJug = cantJug;

        setSize(600,600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 600));

        setTitle("Dobble");


        componentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void componentes(){

        paneles();
        etiquetas();
        cajatexto();

    }

    private void paneles(){

        panel.setBackground(new Color(0, 128, 0,255));
        this.getContentPane().add(panel);
        panel.setLayout(null);
    }

    private void etiquetas(){

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);

        switch (n){

            case 1:
                texto = new JLabel("Ingrese la cantidad maxima de cartas: ");
                break;

            case 2:
                texto = new JLabel("Ingrese la cantidad de elementos por carta: ");
                break;

            case 3:
                texto = new JLabel("Ingrese una lista de elementos: ");
                break;

            case 4:
                texto = new JLabel("Ingrese la cantidad de jugadores: ");
                break;
        }

        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(100,260, 400, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);

    }

    private void cajatexto(){

        espacioTexto.setBounds(175, 300, 250, 30);
        panel.add(espacioTexto);


        KeyListener tecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (e.getKeyChar() == '\n'){

                    switch (n){
                        case 1:
                            maxC = Integer.parseInt(espacioTexto.getText());
                            break;
                        case 2:
                            numE = Integer.parseInt(espacioTexto.getText());
                            break;
                        case 3:
                            elements = new ArrayList<String>(Arrays.asList(espacioTexto.getText().split(",")));
                            break;
                        case 4:
                            cantJug = Integer.parseInt(espacioTexto.getText());
                            Principal app1 = new Principal(maxC, numE, elements, 2, cantJug, mazo, juego);
                            app1.setVisible(true);
                            dispose();
                            break;
                    }
                    switch (n){
                        case 4:
                            VentanaDatos.super.dispose();
                            break;

                        default:
                            app = new VentanaDatos(n+1, maxC, numE, elements, cantJug);
                            app.setVisible(true);
                            dispose();
                            break;
                    }
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        espacioTexto.addKeyListener(tecla);

    }
}
