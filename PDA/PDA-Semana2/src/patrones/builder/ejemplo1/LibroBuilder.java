package patrones.builder.ejemplo1;

import java.time.LocalDate;
import java.util.Set;

import patrones.builder.ejemplo1.libro.Autor;
import patrones.builder.ejemplo1.libro.Categoria;
import patrones.builder.ejemplo1.libro.Libro;
import patrones.builder.ejemplo1.libro.Publico;

/*
    Tengo mi Clase Libro el cual tendra mi objeto complejo del cual pueden haber muchos tipos
    (muchos tipos de libros)
*/
public abstract class LibroBuilder {

    // Objeto Libro, lo pongo protected porque ya tengo un getLibro()
    protected Libro libro;

    // Metodo para crear la instancia mis objetos
    protected void create() {
        libro = new Libro();
    }

    /*
        Desde el Builder pongo los campos parametrizable para las diferentes opciones
        de nuestra clase Producto tengan sus especificos ya faciles de settear en el constructor
        de los otros builders.
        
        Como en la herencia pongo los campos caracterticos de cada Clase hija, aqui 
        pongo los atributos que sean predeterminados en los nuevos tipos de objetos, en el caso 
        de los Libros, la Categoria y su Publico los hacen nuevas Clases especificos.
    */

    // Lo pongo Protected y no Public ya que solo se debe acceder
    // a este Set desde otros builders (que herendan de Builder, por tanto son
    // hijas)
    protected void setCategoria(Set<Categoria> categoria) {
        libro.setCategorias(categoria);
    }

    // Lo pongo Protected y no Public ya que solo se debe acceder
    // a este Set desde otros builders (que herendan de Builder, por tanto son
    // hijas)
    protected void setPublico(Publico publico) {
        libro.setPublico(publico);
    }

    /*
        Los atributos que tiene que ser de cada especificacion del Producto final
    */

    public abstract LibroBuilder setTitulo(String titulo);

    public abstract LibroBuilder setAutor(Autor autor);

    public abstract LibroBuilder setLanzamiento(LocalDate lanzamiento);

    public Libro getLibro() {
        return libro;
    }
}
