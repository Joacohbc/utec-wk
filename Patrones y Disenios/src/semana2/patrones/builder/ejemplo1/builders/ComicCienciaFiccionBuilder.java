package semana2.patrones.builder.ejemplo1.builders;

import java.time.LocalDate;
import java.util.Set;

import semana2.patrones.builder.ejemplo1.LibroBuilder;
import semana2.patrones.builder.ejemplo1.libro.Autor;
import semana2.patrones.builder.ejemplo1.libro.Categoria;
import semana2.patrones.builder.ejemplo1.libro.Publico;

public class ComicCienciaFiccionBuilder extends LibroBuilder{

    public ComicCienciaFiccionBuilder() {
        this.create();
        this.setCategoria(Set.of(Categoria.COMIC, Categoria.CIENCIA_FICCION));
        this.setPublico(Publico.ADOLENCENTE);
    }

    @Override
    public LibroBuilder setAutor(Autor autor) {
        libro.setAutor(autor);
        return this;
    }

    @Override
    public LibroBuilder setTitulo(String titulo) {
        libro.setTitulo(titulo);
        return this;
    }

    @Override
    public LibroBuilder setLanzamiento(LocalDate lanzamiento) {
        libro.setLanzamiento(lanzamiento);
        return this;
    }
}
