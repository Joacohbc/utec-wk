package semana2.patrones.builder.ejemplo1.libro;

public enum Categoria {
    DRAMA,
    CIENCIA_FICCION,
    THRILELR,
    TERROR,
    DOCUMENTAL,
    POLICIAL,
    NOVELA,
    COMEDIA,
    ROMANCE,
    INFANTIL,
    ACCION,
    COMIC;

    @Override
    public String toString() {
        String categoria = name().replace('_', ' ');
        return categoria.charAt(0) + categoria.substring(1).toLowerCase();
    }
}