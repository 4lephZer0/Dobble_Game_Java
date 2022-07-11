package View;

import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Clase VentanaDatos, esta representa la ventana que se encarga de recopilar los datos para la creacion del mazo
 * utiliza diversos atributos para la generacion del mazo y se repite hasta recopilarlos todos los datos correspondientes.
 */
public class VentanaDatos extends JFrame {
    JPanel panel = new JPanel();
    JLabel texto = new JLabel();
    JLabel logo = new JLabel();
    JTextField espacioTexto = new JTextField();
    VentanaDatos app;

    private int maxC; //Atributo que representa el maximo de cartas
    private int numE; //Atributo que representa el numero total de elementos por carta
    private int cantJug; //Atributo que representa la cantidad de jugadores a registrar
    private int n; //Atributo que representa el caso actual a realizar dependiendo de su valor
    private List<String> elements; //Atributo que representa la lista de elementos
    private DobbleGame juego = null; //Atributo que representa un juego de Dobble

    // Este metodo se encarga de construir la Ventana e instanciar todos los atributos de él.
    public VentanaDatos(int n, int maxC, int numE, List<String> elements, int cantJug){
        this.n = n;
        this.maxC = maxC;
        this.numE = numE;
        this.elements = elements;
        this.cantJug = cantJug;

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
    private void etiquetas(){

        ImageIcon logotipo = new ImageIcon("dobbleLogo.png");
        logo.setBounds(175, 0, 250, 250);
        logo.setIcon(new ImageIcon(logotipo.getImage().getScaledInstance(logo.getWidth(),logo.getHeight(),4)));
        panel.add(logo);

        switch (n){

            case 1:
                texto = new JLabel("Ingrese la cantidad maxima de cartas: ");
                break;

            case 2:
                texto = new JLabel("Ingrese la cantidad de elementos por carta: ");
                break;

            case 3:
                texto = new JLabel("Ingrese una lista de elementos: ");
                break;

            case 4:
                texto = new JLabel("Ingrese la cantidad de jugadores: ");
                break;
        }

        texto.setHorizontalAlignment(SwingConstants.CENTER);
        texto.setBounds(100,260, 400, 30);
        texto.setForeground(Color.BLACK);
        texto.setFont(new Font("Georgia",1, 15));
        panel.add(texto);

    }

    // Este metodo se encarga de generar una caja de texto que contiene eventos asociados y donde se puede escribir.
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
                            break;
                        case 2:
                            numE = Integer.parseInt(espacioTexto.getText());
                            break;
                        case 3:
                            elements = new ArrayList<String>(Arrays.asList(espacioTexto.getText().split(",")));
                            break;
                        case 4:
                            cantJug = Integer.parseInt(espacioTexto.getText());
                            VentanaPrincipal app1 = new VentanaPrincipal(maxC, numE, elements, 2, cantJug, null, juego);
                            app1.setVisible(true);
                            dispose();
                            break;
                    }
                    switch (n){
                        case 4:
                            VentanaDatos.super.dispose();
                            break;

                        default:
                            app = new VentanaDatos(n+1, maxC, numE, elements, cantJug);
                            app.setVisible(true);
                            dispose();
                            break;
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
