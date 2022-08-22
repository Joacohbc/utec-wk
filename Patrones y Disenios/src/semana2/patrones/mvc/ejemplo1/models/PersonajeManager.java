package semana2.patrones.mvc.ejemplo1.models;

import java.util.LinkedList;
import java.util.List;

import semana2.patrones.mvc.ejemplo1.models.personaje.Personaje;

public class PersonajeManager {

    private static List<Personaje> personajes = new LinkedList<>();

    public static void NuevoPerosonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    public static void BorrarPerosonaje(Personaje personaje) {
        personajes.remove(personaje);
    }

    public static List<Personaje> GetPersonajes() {
        return personajes;
    }
}
