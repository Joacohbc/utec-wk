package patrones.builder.ejemplo1;

import java.time.LocalDate;

import patrones.builder.ejemplo1.libro.Autor;
import patrones.builder.ejemplo1.libro.Libro;


// Nuestra Biblioteca, por ejemplo, podria ser nuetro Director
public class LibroDirector {
    
    private LibroBuilder libroBuilder;

    public LibroDirector(LibroBuilder libroBuilder){
        this.libroBuilder = libroBuilder;
    }

    public Libro getLibro() {
        return libroBuilder.getLibro();
    }

    public LibroDirector makeLibro(Autor autor, String titulo, LocalDate lanzamiento) {
        libroBuilder.setAutor(autor);
        libroBuilder.setTitulo(titulo);
        libroBuilder.setLanzamiento(lanzamiento);
        return this;
    }
}
