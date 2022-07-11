package View;

import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCaso extends JFrame {

    JPanel panel = new JPanel();
    JLabel logo = new JLabel();
    JLabel texto = new JLabel();
    JLabel texto2 = new JLabel();
    DobbleGame juego;
    int caso;

    public VentanaCaso(DobbleGame juego, int caso){

        this.juego = juego;
        this.caso = caso;

        setSize(600,600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 600));

        setTitle("Model");


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

    private void etiquetas() {
        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        logo.setBounds(0, 0, 100, 100);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), 4)));
        panel.add(logo);

        switch (caso){

            case 0:

                texto = new JLabel("El elemento ingresado no coincide :(");
                texto.setHorizontalAlignment(SwingConstants.CENTER);
                texto.setBounds(100,150, 400, 30);
                texto.setForeground(Color.BLACK);
                texto.setFont(new Font("Georgia",1, 15));
                panel.add(texto);
                break;

            case 1:

                texto = new JLabel("Elemento spoteado con exito!!");
                texto.setHorizontalAlignment(SwingConstants.CENTER);
                texto.setBounds(100,150, 400, 30);
                texto.setForeground(Color.BLACK);
                texto.setFont(new Font("Georgia",1, 15));
                panel.add(texto);
                break;

        }
    }

    private void botones() {

        JButton aceptarButton = new JButton("Continuar");
        aceptarButton.setBounds(225, 300, 150, 30);
        aceptarButton.setFont(new Font("Georgia", Font.PLAIN, 14));
        aceptarButton.setEnabled(true);

        ActionListener aceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaJuego app2 = new VentanaJuego(juego, "NoCards");
                app2.setVisible(true);
                dispose();
            }
        };
        aceptarButton.addActionListener(aceptar);
        panel.add(aceptarButton);


    }
}
