package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaNumE extends JFrame {

    JPanel panel = new JPanel();
    int maxC;
    int numE;
    public VentanaNumE(int maxC){

        this.maxC = maxC;

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
        //botones();
        cajatexto();
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


        JLabel texto = new JLabel("Ingrese la cantidad de elementos por carta: ");
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        texto.setBounds(150,260, 300, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);

    }

    private void cajatexto(){

        JTextField espacioTexto = new JTextField();
        espacioTexto.setBounds(175, 300, 250, 30);
        panel.add(espacioTexto);
        KeyListener tecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (e.getKeyChar() == '\n'){

                    numE = Integer.parseInt(espacioTexto.getText());
                    VentanaElements app = new VentanaElements(maxC, numE);
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
