package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Clase VentanaRegistros, esta ventana se encarga de registrar a los jugadores segun su nombre
 * solo se puede ingresar un maximo de jugadores el cual es el valor ingresado previamente en datos
 */
public class VentanaRegistros extends JFrame {
    JPanel panel = new JPanel();
    JLabel texto = new JLabel();
    JLabel logo = new JLabel();
    JTextField espacioTexto = new JTextField();
    VentanaRegistros app;

    Player jugador;


    private DobbleGame juego; //Atributo que representa un juego de Dobble

    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaRegistros(DobbleGame juego){

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
        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), 4)));
        panel.add(logo);

        texto = new JLabel("Ingrese el nombre del jugador n" + (juego.getJugadores().size()+1) + " :");
        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(150,260, 300, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia", Font.BOLD, 15));
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

                    Integer tamano = juego.getJugadores().size();

                    if (juego.getJugadores().size() < (juego.getNumPlayers() - 1)){

                        jugador = new Player(espacioTexto.getText());
                        juego.register(juego, jugador);
                        app = new VentanaRegistros(juego);
                        app.setVisible(true);
                        dispose();

                    }else if(tamano.equals(juego.getNumPlayers() - 1)){


                        jugador = new Player(espacioTexto.getText());
                        juego.register(juego, jugador);
                        VentanaPrincipal app1 = new VentanaPrincipal(0, 0, null, 3, 0, null, juego);
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

