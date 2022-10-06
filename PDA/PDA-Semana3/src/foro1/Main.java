package foro1;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import compartido.ConexionBD;

public class Main {

	public static void main(String[] args) {
		try {
//			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
//			Long id = Math.round(Long.parseLong(format.format(new Date())) * Math.random());

//			List<Long> numbers = new LinkedList<>();
//			for (int i = 0; i < 10000; i++) {
//				Long n = Math.round(Long.parseLong(format.format(new Date())) * Math.random());
//				if (numbers.contains(n)) {
//					System.out.println(i + " Numero repetido: " + n);
//					break;
//				}
//				numbers.add(n);
//			}
//			System.out.println(numbers.size());
//			System.exit(0);
			
			for(int i = 0; i < 1000000; i++) {
				// Para poner el formato de un Date en algo parseable a un Long
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSSSS");
				
				// La fecha actual parseada a Long
				Long n =  Long.parseLong(format.format(new Date()));
				
				// Un numero aleatorio 
				Random rand = new Random(System.currentTimeMillis());
				
				// Y nuestro ID final
				Long id = n * rand.nextLong();
				
				// Para un mero ejemplo, utilizaria una tabla de test
				String sql = "INSERT INTO test (id_test, valor) values(?, ?)";
				PreparedStatement ps = ConexionBD.getConnection().prepareStatement(sql);
				ps.setLong(1, id);
				ps.setString(2, "Valor irrepetible");
				ps.executeUpdate();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
