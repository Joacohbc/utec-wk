package dtos;

import java.util.LinkedList;
import java.util.List;

public class ArticuloBO {
	
	private List<ArticuloVO> articulos;
	
	public ArticuloBO() {
		articulos = new LinkedList<ArticuloVO>();
		articulos.add(new ArticuloVO(0, "Azucar", 35f, TipoIVA.MINIMO));
		articulos.add(new ArticuloVO(1, "Jabon", 42f, TipoIVA.MAXIMO));
		articulos.add(new ArticuloVO(2, "Leche", 38f, TipoIVA.EXENTO));
	}
	
	public void eliminarArticulo(ArticuloVO articuloVO) {
		articulos.remove(articuloVO.getId());
		System.out.println(String.format("El Articulo con el ID %d -- %s fue eliminado correctamente", articuloVO.getId(), articuloVO.getNombre()));
	}
	
	public List<ArticuloVO> obtenerArticulos() {
		return articulos;
	}
	
	public ArticuloVO obtenerArticulo(int id) {
		return articulos.get(id);
	}
	
	public void actualizarArticulos(ArticuloVO articulo) {
		articulos.get(articulo.getId()).setNombre(articulo.getNombre());
		articulos.get(articulo.getId()).setPrecio(articulo.getPrecio());
		articulos.get(articulo.getId()).setIva(articulo.getIva());
		System.out.println(String.format("El Articulo con el ID: %d fue actualizado correctamente", articulo.getId()));
	}
}
