package View;

import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Clase VentanaSpotit, esta representa el Final de un juego y muestra por pantalla al ganador o si hay algun empate
public class VentanaFin extends JFrame {

    JPanel panel = new JPanel();
    JLabel logo = new JLabel();
    JLabel texto = new JLabel();
    JLabel texto2 = new JLabel();
    DobbleGame juego; //Atributo que representa un juego de Dobble

    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaFin(DobbleGame juego){

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
        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), 4)));
        panel.add(logo);

        texto = new JLabel("Juego Finalizado");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(150,260, 300, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);

        texto2 = new JLabel("Ganador: " + juego.getGanador(juego));
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        texto2.setBounds(150,300, 300, 30);
        texto2.setForeground(Color.BLACK);
        texto2.setFont(new Font("Georgia",1, 15));
        panel.add(texto2);
    }

    // Este metodo se encarga de generar los botones y darles un evento asociado.
    private void botones() {

        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.setBounds(225, 340, 150, 30);
        aceptarButton.setFont(new Font("Georgia", Font.PLAIN, 14));
        aceptarButton.setEnabled(true);

        ActionListener aceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaPrincipal app2 = new VentanaPrincipal(0, 0, null, 1, 0, null, null);
                app2.setVisible(true);
                dispose();
            }
        };
        aceptarButton.addActionListener(aceptar);
        panel.add(aceptarButton);


    }
}
