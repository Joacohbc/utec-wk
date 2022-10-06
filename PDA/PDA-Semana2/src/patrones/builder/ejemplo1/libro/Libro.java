package patrones.builder.ejemplo1.libro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

// Nuestra clase Libro, es nuetro Produto, es aquel 
// objeto complejo a dividir en difernetes builders
public class Libro {

    private Autor autor;
    private Set<Categoria> categorias;
    private Publico publico;
    private String titulo;
    private LocalDate lanzamiento;

    public Libro() {
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Set<Categoria> getCategoria() {
        return categorias;
    }

    // Asigna un conjuto de categorias
    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    // Agrega una catergoria
    // public void addCategoria(Categoria categoria) {
    // categorias.add(categoria);
    // }

    // Remueve una catergoria
    // public void removeCategoria(Categoria categoria) {
    // categorias.remove(categoria);
    // }

    public Publico getPublico() {
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(LocalDate lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    @Override
    public String toString() {
        return String.format("Libro: %s\n- Autor: %s\n- Fecha de Lanzamiento: %s\n- Categoria: %s\n- Publico: %s",
                titulo,
                autor.toString(),
                lanzamiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                categorias.toString(), publico.toString());
    }
}
