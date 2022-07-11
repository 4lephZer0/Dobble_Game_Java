package Ventanas;

import Dobble.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaRegistros extends JFrame {
    JPanel panel = new JPanel();
    JLabel texto = new JLabel();
    JLabel logo = new JLabel();
    JTextField espacioTexto = new JTextField();
    VentanaRegistros app;

    Player jugador;


    DobbleGame juego = null;

    public VentanaRegistros(DobbleGame juego){

        this.juego = juego;

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

    private void etiquetas() {

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), 4)));
        panel.add(logo);

        texto = new JLabel("Ingrese el nombre del jugador n" + (juego.getJugadores().size()+1) + " :");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(150,260, 300, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);
    }

    private void cajatexto() {

        espacioTexto.setBounds(175, 300, 250, 30);
        panel.add(espacioTexto);

        KeyListener tecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (e.getKeyChar() == '\n'){

                    if (juego.getJugadores().size() != (juego.getNumPlayers()-1)){
                        jugador = new Player(espacioTexto.getText());
                        System.out.println("tamaño jugador: " + juego.getJugadores().size() + "Numplayers: " + juego.getNumPlayers());
                        juego.register(juego, jugador);
                        app = new VentanaRegistros(juego);
                        app.setVisible(true);
                        dispose();
                    }
                    else{

                        Principal app1 = new Principal(0, 0, null, 3, 0, null, juego);
                        app1.setVisible(true);
                        dispose();
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

