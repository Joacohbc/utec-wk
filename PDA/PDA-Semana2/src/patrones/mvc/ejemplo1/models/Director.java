package patrones.mvc.ejemplo1.models;

import patrones.mvc.ejemplo1.models.builders.Builder;
import patrones.mvc.ejemplo1.models.personaje.Personaje;

public class Director {
    
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Personaje buildPersonaje(String nombre, String region) {
        builder
            .setNombre(nombre)
            .setRegion(region);
        return builder.getResult();
    }
}
