package patrones.builder.ejemplo1;

import java.time.LocalDate;

import patrones.builder.ejemplo1.builders.ComicCienciaFiccionBuilder;
import patrones.builder.ejemplo1.builders.NovelaRomComBuilder;
import patrones.builder.ejemplo1.libro.Autor;

public class Main {

    public static void main(String[] args) {

        LibroDirector romcom = new LibroDirector(new NovelaRomComBuilder());
        Autor autor1 = new Autor("Sōichirō", "Yamamoto", LocalDate.of(1986, 5, 31));
        romcom.makeLibro(autor1, "Karakai Jōzu no Takagi-san", LocalDate.of(2013, 6, 12));
        System.out.println(romcom.getLibro());

        LibroDirector accion = new LibroDirector(new ComicCienciaFiccionBuilder());
        Autor autor2 = new Autor("Reki", "Kawahara", LocalDate.of(1974, 8, 17));
        accion.makeLibro(autor2, "Sword Art Online", LocalDate.of(2009, 4, 10));
        System.out.println("\n" + accion.getLibro());

    }
}
