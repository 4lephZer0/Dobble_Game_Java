package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Principal extends JFrame {
    JPanel panel = new JPanel();


    public Principal(){
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

        /*
        JLabel texto = new JLabel("Dobble");
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        texto.setBounds(100,100, 150, 100);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("cooper black",0, 30));
        panel.add(texto);
        */


        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        JLabel logo = new JLabel();

        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);
    }

    private void botones(){

        JButton EmpezarJuego = new JButton("Crear un Nuevo Juego");
        EmpezarJuego.setBounds(175,280, 250,30);
        EmpezarJuego.setFont(new Font("Georgia",0, 15));
        EmpezarJuego.setEnabled(true);
        panel.add(EmpezarJuego);

        ActionListener empezar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                VentanaMaxC app2 = new VentanaMaxC(1);
                app2.setVisible(true);
                dispose();
            }
        };
        EmpezarJuego.addActionListener(empezar);

        JButton boton2 = new JButton("Registrar Jugadores");
        boton2.setBounds(175,320, 250,30);
        boton2.setFont(new Font("Georgia",0, 15));
        boton2.setEnabled(false);
        panel.add(boton2);

        JButton boton3 = new JButton("Empezar a jugar");
        boton3.setBounds(175,360, 250,30);
        boton3.setFont(new Font("Georgia",0, 15));
        boton3.setEnabled(false);
        panel.add(boton3);

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
