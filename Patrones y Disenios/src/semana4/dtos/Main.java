package semana4.dtos;

import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

	// Un Consumer<? super ArticuloVO>, funcion lambada que pide cualquier tipo que
	// extienda de ArticuloVO, es decir que ArticuloVO sea el Padre (super)
	private static final Consumer<? super ArticuloVO> printArticuloVO = avo -> {
		System.out.println("ID: " + avo.getId());
		System.out.println("Nombre: " + avo.getNombre());
		System.out.println("Precio: " + avo.getPrecio());
		System.out.println("Tipo de IVA: " + avo.getIva());
	};

	public static void main(String[] args) {

		// Mostrar un Titulo de separacion
		final Function<String, Void> separacion = (s) -> {
			System.out.println("\n		bo.obtenerArticulos().forEach(printArticuloVO);\n"
					+ "*** " + s + " ***");
			return null;
		};

		ArticuloBO bo = new ArticuloBO();

		separacion.apply("Listar el todos los articulos");
		bo.obtenerArticulos().forEach(printArticuloVO);

		separacion.apply("Actualizar el Articulo en el Indice 0");
		ArticuloVO art = bo.obtenerArticulo(0);
		art.setNombre("Azucarlito x 1kg");
		bo.actualizarArticulos(art); // Esto es innecesario?
		
		separacion.apply("Mostrar el Articulo en el Indice 0");
		printArticuloVO.accept(bo.obtenerArticulo(0));
		System.out.println();
		
		separacion.apply("Eliminar el Articulo en el Indice 0");
		art = bo.obtenerArticulo(0);
		bo.eliminarArticulo(art);
		
		separacion.apply("Listar todos losa articulos despues de los cambios");
		bo.obtenerArticulos().forEach(printArticuloVO);
	}
}
