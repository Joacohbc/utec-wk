package patrones.mvc.ejemplo1.models.builders;

import patrones.mvc.ejemplo1.models.personaje.Personaje;

public abstract class Builder {

    protected Personaje personaje;

    public void create(){
        personaje = Personaje.make();
    } 

    public abstract Builder setNombre(String nombre);
    public abstract Builder setRegion(String region);
    public abstract Personaje getResult();
}
