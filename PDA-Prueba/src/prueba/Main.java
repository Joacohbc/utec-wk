package prueba;

import java.util.List;

import prueba.models.Animal;
import prueba.models.Categoria;
import prueba.models.DAOAnimal;
import prueba.models.DAOProductor;
import prueba.models.Productor;

public class Main {
	public static void main(String[] args) {
//		new GUI().setVisible(true);

		try {
			DAOAnimal.eliminarTodo();
			DAOProductor.eliminarTodo();

			Productor p = new Productor();
			p.setId(1);
			p.setNombre("Juan");
			p.setTelefono("095512352");
			DAOProductor.insert(p);

			Productor p1 = new Productor();
			p1.setId(2);
			p1.setNombre("Pedro");
			p1.setTelefono("095326856");
			DAOProductor.insert(p1);

			Productor p2 = new Productor();
			p2.setId(3);
			p2.setNombre("Marcelo");
			p2.setTelefono("0957523423");
			DAOProductor.insert(p2);

			Productor p3 = new Productor();
			p3.setId(4);
			p3.setNombre("Enrique");
			p3.setTelefono("096134223");
			DAOProductor.insert(p3);

			System.out.println("> Todos los productores <");
			List<Productor> productors = DAOProductor.findAll();
			for (Productor productor : productors) {
				System.out.println(productor);
			}
			System.out.println();

			//
			// Animales
			//

			Animal a = new Animal();
			a.setId(1);
			a.setDescripcion("Vaca 190kg");
			a.setCategoria(Categoria.VACUNO);
			a.setProductor(DAOProductor.buscarProductor(1));
			DAOAnimal.insert(a);

			Animal a1 = new Animal();
			a1.setId(2);
			a1.setDescripcion("Vaca 400kg");
			a1.setCategoria(Categoria.VACUNO);
			a1.setProductor(DAOProductor.buscarProductor(2));
			DAOAnimal.insert(a1);

			Animal a2 = new Animal();
			a2.setId(3);
			a2.setDescripcion("Oveja 50kg");
			a2.setCategoria(Categoria.OVINO);
			a2.setProductor(DAOProductor.buscarProductor(3));
			DAOAnimal.insert(a2);

			System.out.println("> Todos los Animales <");
			List<Animal> animals = DAOAnimal.findAll();
			for (Animal animal : animals) {
				System.out.println(animal);
			}
			System.out.println();

			System.out.println("> Modifico el Animal con el ID 2 <");
			System.out.println(DAOAnimal.buscarAnimal(2));
			Animal a1New = new Animal();
			a1New.setDescripcion("Vaca 450kg");
			a1New.setCategoria(Categoria.VACUNO);
			a1New.setProductor(DAOProductor.buscarProductor(3));
			DAOAnimal.update(2, a1New);
			System.out.println(DAOAnimal.buscarAnimal(2));
			System.out.println();

			System.out.println("> Elimino el Animal con el ID 3 <");
			animals = DAOAnimal.findAll();
			for (Animal animal : animals) {
				System.out.println(animal);
			}
			System.out.println();

			DAOAnimal.delete(3);

			animals = DAOAnimal.findAll();
			for (Animal animal : animals) {
				System.out.println(animal);
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
