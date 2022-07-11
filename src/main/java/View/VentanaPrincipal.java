package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import Model.*;

/*
 * Clase VentanaPrincipal, esta representa la ventana principal del juego
 * donde se encuentran las opciones de crear juego, Registrar jugadores, empezar partida y Cerrar juego.
 */
public class VentanaPrincipal extends JFrame {
    JPanel panel = new JPanel();

    private Dobble mazo;
    private DobbleGame juego;

    private int maxC; //Atributo que representa el maximo de cartas
    private int numE; //Atributo que representa el numero total de elementos por carta
    private List<String> elements; //Atributo que representa la lista de elementos
    private int caso; //Atributo que representa el caso actual
    private int cantJug; //Atributo que representa la cantidad de jugadores a registrarse


    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaPrincipal(int maxC, int numE, List<String> elements, int caso, int cantJug, Dobble mazo, DobbleGame juego){

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

        setTitle("Model");


        componentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Este metodo se encarga de encapsular otros metodos para el orden del codigo.
    private void componentes(){

        paneles();
        etiquetas();
        botones();

    }

    // Este metodo se encarga de generar el panel de fondo con su respectivo Color o diseño.
    private void paneles(){

        panel.setBackground(new Color(0, 128, 0,255));
        this.getContentPane().add(panel);
        panel.setLayout(null);

    }

    // Este metodo se encarga de generar las etiquetas para los textos y el logo.
    private void etiquetas(){

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        JLabel logo = new JLabel();

        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);
    }

    // Este metodo se encarga de generar los botones y darles un evento asociado.
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
