package patrones.builder.ejemplo1.libro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Nuentra clase Autor es un Componente
public class Autor {
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Autor() {
    }

    public Autor(String nombre, String apellido, LocalDate nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }   

    // Settear el formato, predeterminadamente es dd/MM/yyyy
    public void setDateLayout(String layout) {
        formatter =DateTimeFormatter.ofPattern(layout);
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public String getNacimientoString() {
        return formatter.format(nacimiento);
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return String.format("Autor [ Nombre: %s - Apellido: %s - Nacimiento: %s ] ", nombre, apellido,
                formatter.format(nacimiento));
    }
}
