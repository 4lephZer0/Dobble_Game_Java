package View;

import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Clase VentanaJuego, esta representa la ventana donde ocurre todo el juego de Dobble
 * aqui se encuentran las diversas opciones como Voltear cartas, Pasar turno, Spotear cartas y finalizar juego.
 */
public class VentanaJuego extends JFrame {

    JPanel panel = new JPanel();
    JLabel textoTurno = new JLabel();
    JLabel texto = new JLabel();
    JLabel texto2 = new JLabel();
    JLabel texto3 = new JLabel();
    JLabel logo = new JLabel();
    VentanaJuego app;


    private String caso; //Atributo que representa el caso actual, dependiendo de lo que diga, ocurre una y otra cosa.
    private DobbleGame juego; //Atributo que representa un juego de Dobble

    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaJuego(DobbleGame juego, String caso){

        this.caso = caso;
        this.juego = juego;

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
    private void etiquetas() {

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        logo.setBounds(0, 0, 100, 100);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), 4)));
        panel.add(logo);

        if (caso.equals("vuelta")){

            textoTurno = new JLabel("Turno de: " + juego.whoseTurnIsIt(juego).getJugador() + " || Puntaje: " + juego.getCartasJugadores().get(juego.getTurno()-1).size());
            textoTurno.setHorizontalAlignment(SwingConstants.CENTER);
            textoTurno.setBounds(150,50, 300, 50);
            textoTurno.setForeground(Color.BLACK);
            textoTurno.setFont(new Font("Georgia",1, 20));
            panel.add(textoTurno);

            texto = new JLabel("Encuentra el simbolo en comun!!");
            texto.setHorizontalAlignment(SwingConstants.CENTER);
            texto.setBounds(150,100, 300, 30);
            texto.setForeground(Color.BLACK);
            texto.setFont(new Font("Georgia",1, 15));
            panel.add(texto);

            texto2 = new JLabel("Carta1: " + juego.getMesa().get(0).getElementos());
            texto2.setHorizontalAlignment(SwingConstants.CENTER);
            texto2.setBounds(150,140, 300, 30);
            texto2.setForeground(Color.BLACK);
            texto2.setFont(new Font("Georgia",1, 15));
            panel.add(texto2);

            texto3 = new JLabel("Carta2: " + juego.getMesa().get(1).getElementos());
            texto3.setHorizontalAlignment(SwingConstants.CENTER);
            texto3.setBounds(150,180, 300, 30);
            texto3.setForeground(Color.BLACK);
            texto3.setFont(new Font("Georgia",1, 15));
            panel.add(texto3);

        }else if(caso.equals("NoCards")){

            texto = new JLabel("No hay cartas en la mesa");
            texto.setHorizontalAlignment(SwingConstants.CENTER);
            texto.setBounds(150,150, 300, 30);
            texto.setForeground(Color.BLACK);
            texto.setFont(new Font("Georgia",1, 16));
            panel.add(texto);
        }
    }

    // Este metodo se encarga de generar los botones y darles un evento asociado.
    private void botones(){

        JButton darVueltaCartas = new JButton("Dar Vuelta Cartas");
        darVueltaCartas.setBounds(100,280, 150,30);
        darVueltaCartas.setFont(new Font("Georgia",0, 14));

        if (caso.equals("vuelta")){
            darVueltaCartas.setEnabled(false);

        }else if(caso.equals("NoCards")){
            darVueltaCartas.setEnabled(true);

        }
        panel.add(darVueltaCartas);

        ActionListener vueltas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int largo = juego.getDobble().getCards().size();
                System.out.println("Cartas restantes: " + juego.getDobble().getCards());
                if (largo <= 1){

                    VentanaFin app2 = new VentanaFin(juego);
                    app2.setVisible(true);
                    dispose();
                }

                else{
                    juego = juego.play(juego,"1", "");
                    VentanaJuego app1 = new VentanaJuego(juego, "vuelta");
                    app1.setVisible(true);
                    dispose();
                }

            }
        };
        darVueltaCartas.addActionListener(vueltas);

        JButton pass = new JButton("Pasar turno");
        pass.setBounds(350,280, 150,30);
        pass.setFont(new Font("Georgia",0, 15));

        if (caso.equals("vuelta")){
            pass.setEnabled(true);

        }else if(caso.equals("NoCards")){
            pass.setEnabled(false);

        }
        panel.add(pass);

        ActionListener pasar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                juego = juego.play(juego, "3", "");
                app = new VentanaJuego(juego, "NoCards");
                app.setVisible(true);
                dispose();
            }
        };
        pass.addActionListener(pasar);

        JButton spotear = new JButton("Spotear Elemento");
        spotear.setBounds(100,410, 150,30);
        spotear.setFont(new Font("Georgia",0, 14));

        if (caso.equals("vuelta")){
            spotear.setEnabled(true);

        }else if(caso.equals("NoCards")){
            spotear.setEnabled(false);

        }
        panel.add(spotear);

        ActionListener spotit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaSpotit app1 = new VentanaSpotit(juego);
                app1.setVisible(true);
                dispose();
            }
        };
        spotear.addActionListener(spotit);

        JButton finalizar = new JButton("Finalizar");
        finalizar.setBounds(350,410, 150,30);
        finalizar.setFont(new Font("Georgia",0, 15));
        finalizar.setEnabled(true);
        panel.add(finalizar);

        ActionListener finaliza = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaFin app2 = new VentanaFin(juego);
                app2.setVisible(true);
                dispose();
            }
        };
        finalizar.addActionListener(finaliza);

    }



}
