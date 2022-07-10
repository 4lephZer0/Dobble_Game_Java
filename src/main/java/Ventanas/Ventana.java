package Ventanas;

import javax.swing.*;
import java.awt.*;


public class Ventana extends JFrame {
    JPanel panel = new JPanel();

    public Ventana(){
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
        //ingresoTexto();
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

        logo.setBounds(200, 0, 200, 200);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);
    }

    private void botones(){

        JButton boton1 = new JButton("Crear un Nuevo Juego");
        boton1.setBounds(200,220, 200,30);
        boton1.setFont(new Font("Georgia",0, 15));
        boton1.setEnabled(true);
        panel.add(boton1);
    }

    private void ingresoTexto(){
        JTextField espaciotexto1 = new JTextField();
        espaciotexto1.setBounds(200, 270, 200, 30);

        panel.add(espaciotexto1);

    }
}
