package patrones.mvc.ejemplo1.models.builders;

import patrones.mvc.ejemplo1.models.personaje.Arma;
import patrones.mvc.ejemplo1.models.personaje.Personaje;

public class Guerrero extends Builder {
    
    public Guerrero(){
        create();
        personaje.setArma(Arma.ESPADA)
        .setUsaEscudo(true)
        .setVidaMaxima(500)
        .setDanioBase(70)
        .setManaMaximo(0)
        .setUsaMana(false);
    }

    @Override
    public Builder setNombre(String nombre) {
        personaje.setNombre(nombre);
        return this;
    }

    @Override
    public Builder setRegion(String region) {
        return this;
    }

    @Override
    public Personaje getResult() {
        return personaje;
    }    
}
