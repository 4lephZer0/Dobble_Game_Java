package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VentanaMaxC extends JFrame {
    JPanel panel = new JPanel();
    JLabel texto = new JLabel();
    JLabel logo = new JLabel();
    JTextField espacioTexto = new JTextField();

    int maxC;
    int numE;
    int n;
    List<String> elements;

    public VentanaMaxC(int n){
        this.n = n;
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
                texto.setHorizontalAlignment(SwingConstants.CENTER);

            case 2:
                texto = new JLabel("Ingrese la cantidad de elementos por carta: ");
                texto.setHorizontalAlignment(SwingConstants.CENTER);

            case 3:
                texto = new JLabel("Ingrese una lista de elementos: ");
                texto.setHorizontalAlignment(SwingConstants.CENTER);
        }

        texto.setBounds(150,260, 300, 30);
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
                        case 2:
                            numE = Integer.parseInt(espacioTexto.getText());
                        case 3:
                            elements = new ArrayList<String>(Arrays.asList(espacioTexto.getText().split(",")));
                            dispose();
                    }
                    VentanaMaxC app = new VentanaMaxC(n+1);
                    app.setVisible(true);
                    dispose();
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
