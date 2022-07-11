package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import Dobble.*;


public class Principal extends JFrame {
    JPanel panel = new JPanel();

    Dobble mazo;
    DobbleGame juego = null;

    int maxC;
    int numE;
    List<String> elements;
    int caso;
    int cantJug;



    public Principal(int maxC, int numE, List<String> elements, int caso, int cantJug, Dobble mazo, DobbleGame juego){

        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;
        this.caso = caso;
        this.cantJug = cantJug;
        this.juego = juego;
        this.mazo = mazo;

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
        botones();

    }

    private void paneles(){

        panel.setBackground(new Color(0, 128, 0,255));
        this.getContentPane().add(panel);
        panel.setLayout(null);

    }

    private void etiquetas(){

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        JLabel logo = new JLabel();

        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);
    }

    private void botones(){

        JButton crearJuego = new JButton("Crear un Nuevo Juego");
        crearJuego.setBounds(175,280, 250,30);
        crearJuego.setFont(new Font("Georgia",0, 15));

        switch (caso){

            case 1:
                crearJuego.setEnabled(true);
                break;

            default:
                crearJuego.setEnabled(false);
                break;
        }
        panel.add(crearJuego);

        ActionListener empezar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaDatos app2 = new VentanaDatos(1, maxC, numE, elements, cantJug);
                app2.setVisible(true);
                dispose();
            }
        };
        crearJuego.addActionListener(empezar);

        JButton registrarJugadores = new JButton("Registrar Jugadores");
        registrarJugadores.setBounds(175,320, 250,30);
        registrarJugadores.setFont(new Font("Georgia",0, 15));

        switch (caso){

            case 2:
                registrarJugadores.setEnabled(true);
                break;

            default:
                registrarJugadores.setEnabled(false);
                break;
        }

        panel.add(registrarJugadores);

        ActionListener registrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mazo = new Dobble(maxC, numE, elements);
                System.out.println("mazo: " + mazo);
                juego = new DobbleGame(cantJug, mazo,"stackMode");
                VentanaRegistros app3 = new VentanaRegistros(juego);
                app3.setVisible(true);
                dispose();
            }
        };
        registrarJugadores.addActionListener(registrar);


        JButton jugar = new JButton("Empezar a jugar");
        jugar.setBounds(175,360, 250,30);
        jugar.setFont(new Font("Georgia",0, 15));

        switch (caso){

            case 3:
                jugar.setEnabled(true);
                break;

            default:
                jugar.setEnabled(false);
                break;
        }
        panel.add(jugar);

        ActionListener JugarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaJuego app4 = new VentanaJuego(juego, "NoCards");
                app4.setVisible(true);
                dispose();
            }
        };
        jugar.addActionListener(JugarA);

        JButton boton4 = new JButton("Salir");
        boton4.setBounds(175,400, 250,30);
        boton4.setFont(new Font("Georgia",0, 15));
        boton4.setEnabled(true);
        panel.add(boton4);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        boton4.addActionListener(accion);
    }
}
