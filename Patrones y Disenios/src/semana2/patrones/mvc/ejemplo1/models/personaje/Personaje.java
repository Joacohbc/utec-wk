package semana2.patrones.mvc.ejemplo1.models.personaje;

public class Personaje {

	// Campos Especificos
	private String nombre;
	private String region;

	// Campos generales
	private Arma arma;
	private boolean usaEscudo;
	private int vidaMaxima;
	private int danioBase;
	private int manaMaximo;
	private boolean usaMana;

	// private Personaje(Arma arma, boolean usaEscudo, int vidaMaxima, int danioBase, int manaMaximo, boolean usaMana) {
	// 	this.arma = arma;
	// 	this.usaEscudo = usaEscudo;
	// 	this.vidaMaxima = vidaMaxima;
	// 	this.danioBase = danioBase;
	// 	this.manaMaximo = manaMaximo;
	// 	this.usaMana = usaMana;
	// }

	private Personaje(){}

	public static Personaje make(){
		return new Personaje();
	}

	public Personaje build(){
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public Personaje setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public Arma getArma() {
		return arma;
	}

	public Personaje setArma(Arma arma) {
		this.arma = arma;
		return this;
	}

	public boolean isUsaEscudo() {
		return usaEscudo;
	}

	public Personaje setUsaEscudo(boolean usaEscudo) {
		this.usaEscudo = usaEscudo;
		return this;
	}

	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public Personaje setVidaMaxima(int vidaMaxima) {
		this.vidaMaxima = vidaMaxima;
		return this;
	}

	public int getDanioBase() {
		return danioBase;
	}

	public Personaje setDanioBase(int danioBase) {
		this.danioBase = danioBase;
		return this;
	}

	public int getManaMaximo() {
		return manaMaximo;
	}

	public Personaje setManaMaximo(int manaMaximo) {
		this.manaMaximo = manaMaximo;
		return this;
	}

	public boolean isUsaMana() {
		return usaMana;
	}

	public Personaje setUsaMana(boolean usaMana) {
		this.usaMana = usaMana;
		return this;
	}

	public String getRegion() {
		return region;
	}

	public Personaje setRegion(String region) {
		this.region = region;
		return this;
	}

	@Override
	public String toString() {
		return "Personaje [arma=" + arma + ", danioBase=" + danioBase + ", manaMaximo=" + manaMaximo + ", nombre="
				+ nombre + ", region=" + region + ", usaEscudo=" + usaEscudo + ", usaMana=" + usaMana + ", vidaMaxima="
				+ vidaMaxima + "]";
	}
}
