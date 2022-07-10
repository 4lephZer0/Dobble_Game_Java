package Dobble;

import Ventanas.*;


// CLASE MAIN, aqui ocurre toda la magia del menu por consola.
public class Main {
    public static void main(String[] args){
        int maxC;
        Principal app = new Principal();
        app.setVisible(true);

        /*
        Scanner escaneo = new Scanner(System.in);
        int condicion = 0;
        Dobble mazo;
        DobbleGame juego = null;

        System.out.println("Bienvenido a Dobble!!");
        System.out.println("Este programa simula el juego de Dobble");
        System.out.println("Para empezar");

        // Ciclo de decisiones menu 1
        while (condicion < 1){

            System.out.println("Ingrese una de las siguientes opciones\n");
            System.out.println("-----------------------------");
            System.out.println("[1] Para crear un nuevo juego");
            System.out.println("[2] Para Registrar Usuarios");
            System.out.println("[3] Para Jugar");
            System.out.println("[4] Para terminar el juego");
            System.out.println("-----------------------------");
            System.out.print("Opcion: ");
            String opcion = escaneo.nextLine();


            if (opcion.equals("1")){
                System.out.print("Ingrese la cantidad maxima de cartas: ");
                String maxC1  = escaneo.nextLine();
                int maxC = Integer.parseInt(maxC1);

                System.out.print("Ingrese la cantidad de elementos por carta: ");
                String numE1  = escaneo.nextLine();
                int numE = Integer.parseInt(numE1);

                String cadena;
                List<String> elements = null;
                
                int condicion2 = 0;
                while (condicion2 != 1){
                    System.out.print("Ingrese una lista de elementos (EJEMPLO: A,B,C,D,E)\n" +
                            "Procure que sea del mismo tamaño que la cantidad de elementos por carta: ");
                    cadena  = escaneo.nextLine();
                    elements = new ArrayList<String>(Arrays.asList(cadena.split(",")));
                    Integer cantElem = ((numE - 1) * (numE - 1)) + (numE - 1) + 1;
                    if (cantElem.equals(elements.size())){
                        condicion2 = 1;
                    }

                }

                mazo = new Dobble(maxC, numE, elements);
                System.out.println(mazo);

                System.out.println("MAZO CREADO CORRECTAMENTE!!!\n");

                System.out.print("Ingrese la cantidad de jugadores maximo a registrar: ");
                String cantJug  = escaneo.nextLine();
                int cantidadJugadores = Integer.parseInt(cantJug);

                juego = new DobbleGame(cantidadJugadores, mazo,"stackMode");

                System.out.println("JUEGO CREADO CORRECTAMENTE!!!\n");
                System.out.println("\nAhora ingrese la opcion 2 para registrar jugadores.\n");

            }else if (opcion.equals("2")){

                System.out.print("Ingrese el nombre del jugador a registrar: ");
                String player  = escaneo.nextLine();
                Player jugador = new Player(player);

                juego.register(juego, jugador);

            }else if (opcion.equals("3")){

                int condicion3 = 0;
                System.out.println("para empezar el juego, ingrese alguna de las siguientes opciones: ");

                // Ciclo de decisiones menu 2
                while (condicion3 != 1){

                    Player jugador2 = juego.whoseTurnIsIt(juego);

                    System.out.println("## TURNO DE " + jugador2.getJugador() + " ##");
                    System.out.println("-----------------------------");
                    System.out.println("[1] Para extraer 2 cartas del mazo (en caso de ya haber 2 cartas, por favor no utilizar.)");
                    System.out.println("[2] Para nombrar la coincidencia (en caso de haber extraido 2 cartas)");
                    System.out.println("[3] Para pasar el turno");
                    System.out.println("[4] Para finalizar la partida");
                    System.out.println("-----------------------------");
                    System.out.print("Opcion: ");
                    String opcion1 = escaneo.nextLine();

                    if (opcion1.equals("1")){

                        juego = juego.play(juego,opcion1, "");

                        System.out.println("## CARTAS EN LA MESA ##");
                        System.out.println("-----------------------------");
                        System.out.println("Carta 1: " + juego.getMesa().get(0));
                        System.out.println("Carta 2: " + juego.getMesa().get(1));
                        System.out.println("-----------------------------");
                        System.out.println("CARTAS RESTANTES DEL MAZO: " + juego.getDobble().getCards().size());

                    }else if (opcion1.equals("2")){

                        System.out.print("Ingrese el elemento de coincidencia: ");
                        String elemento = escaneo.nextLine();
                        juego = juego.play(juego, opcion1, elemento);

                    }else if (opcion1.equals("3")){

                        juego = juego.play(juego, opcion1, "");

                    }else if (opcion1.equals("4")){

                        juego = juego.play(juego, opcion1, "");
                        condicion3 = 1;
                    }
                }

            }else if (opcion.equals("4")){

                System.out.println("PROGRAMA FINALIZADO.");
                condicion = 1;
            }
        }
        */
    }
}