package practica1singleton;

public class Robot {

    // Atributos //

    private String name;
    private byte lives;

    // Instancia Unica //

    private static final Robot RobotObj = new Robot();

    public static Robot getInstances() {
        return RobotObj;
    }

    // Constructores //

    private Robot() {
    }

    // Getters y Setters //

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getLives() {
        return lives;
    }

    public void setLives(byte lives) {
        this.lives = lives;
    }

    @Override
    public String toString() {
        return String.format("Robot Class:\n- Name: %s\n- Lives: %s ❤\n", name, lives);
    }
}
