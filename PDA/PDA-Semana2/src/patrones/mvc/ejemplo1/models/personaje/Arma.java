package patrones.mvc.ejemplo1.models.personaje;

public enum Arma {
	ESPADA,
	PISTIOLA,
	ARCO,
	BASTON_MAGICO;

	@Override
	public String toString(){
		String s = name().replace('_', ' ');
		return s.charAt(0) + s.substring(1).toLowerCase();
	}
}
