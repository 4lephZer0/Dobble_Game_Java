package View;

import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VentanaSpotit extends JFrame {

    JPanel panel = new JPanel();
    JLabel logo = new JLabel();
    JLabel texto = new JLabel();
    JTextField espacioTexto = new JTextField();

    private DobbleGame juego;
    private Integer largo;

    public VentanaSpotit(DobbleGame juego){

        this.juego = juego;

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
        cajatexto();

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

        texto = new JLabel("Ingrese elemento spoteado:");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(150,150, 300, 30);
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

                    String elemento = espacioTexto.getText();
                    largo = juego.getDobble().getCards().size();
                    juego = juego.play(juego, "2", elemento);

                    if(largo.equals(juego.getDobble().getCards().size())){

                        VentanaCaso app1 = new VentanaCaso(juego, 1);
                        app1.setVisible(true);
                        dispose();

                    }
                    else{

                        VentanaCaso app1 = new VentanaCaso(juego, 0);
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
