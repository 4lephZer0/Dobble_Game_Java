package View;

import Model.DobbleGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


//Clase VentanaSpotit, esta representa el caso en el que se clickee Spotit y se solicita el elemento spoteado
public class VentanaSpotit extends JFrame {

    JPanel panel = new JPanel();
    JLabel logo = new JLabel();
    JLabel texto = new JLabel();
    JTextField espacioTexto = new JTextField();

    private DobbleGame juego; //Atributo que representa un juego de Dobble
    private Integer largo; //Atributo que representa el largo del mazo restante

    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaSpotit(DobbleGame juego){

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
        cajatexto();

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

        texto = new JLabel("Ingrese elemento spoteado:");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(150,150, 300, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);
    }

    // Este metodo se encarga de generar una caja de texto que contiene eventos asociados y donde se puede escribir.
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
