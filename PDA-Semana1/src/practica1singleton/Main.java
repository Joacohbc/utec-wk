package practica1singleton;

public class Main {
    public static void main(String[] args) {

        // Asigno instancia unica a una variable
        Robot catbot = Robot.getInstances();

        // Imprimo el robot
        System.out.println("> Antes de asignar atributos: (desde la Variable)");
        System.out.println(catbot);

        System.out.println("> Antes de asignar atributos: (desde el Metodo)");
        System.out.println(Robot.getInstances());

        // Asigno atributos
        catbot.setName("MeowBot  #01");
        catbot.setLives((byte) 7);
        
        // Imprimo el robot
        System.out.println("> Luego de asignar atributos: (desde la Variable)");
        System.out.println(catbot);

        System.out.println("> Luego de asignar atributos: (desde el Metodo)");
        System.out.println(Robot.getInstances());
    }
}
