package semana2.patrones.mvc.ejemplo1.models.builders;

import semana2.patrones.mvc.ejemplo1.models.personaje.Arma;
import semana2.patrones.mvc.ejemplo1.models.personaje.Personaje;

public class Mago extends Builder {

	public Mago() {
		create();
		personaje
			.setArma(Arma.BASTON_MAGICO)
			.setUsaEscudo(false)
			.setVidaMaxima(200)
			.setDanioBase(50)
			.setManaMaximo(500)
			.setUsaMana(true);
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
