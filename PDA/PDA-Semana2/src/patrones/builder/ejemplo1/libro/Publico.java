package patrones.builder.ejemplo1.libro;

public enum Publico {
    INFANTIL,
    ADOLENCENTE,
    JOVEN,
    ADULTO,
    TERCERA_EDAD;

    @Override
    public String toString() {
        String publico = name().replace('_', ' ');
        return publico.charAt(0) + publico.substring(1).toLowerCase();
    }
}