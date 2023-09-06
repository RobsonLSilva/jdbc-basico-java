package robson.jdbc.exemplos.java.Application;

import java.util.List;

import robson.jdbc.exemplos.java.db.Db;
import robson.jdbc.exemplos.java.model.Delete;
import robson.jdbc.exemplos.java.model.Insert;
import robson.jdbc.exemplos.java.model.Select;
import robson.jdbc.exemplos.java.model.Update;
import robson.jdbc.exemplos.java.model.entities.Cliente;

public class App {
    public static void main(String[] args) {
      
        System.out.println("\n=== TEST 1: cliente findAll =====");
        Select select = new Select(Db.getConn());
		List<Cliente> list = select.findAll();

		for (Cliente cliente : list) {
			System.out.println(cliente);
		}
 
        System.out.println("\n-------------------------------------------------------------------------");

        System.out.println("\n=== TEST 2: cliente Insert =====");
        Cliente cliente = new Cliente("Cliente 4", "444.444.444-44", "(44) 4444-4444");
		Insert insert = new Insert(Db.getConn());
        insert.insert(cliente);        
		System.out.println("Inserted! New id = " + cliente.getId());
       
        System.out.println("\n-------------------------------------------------------------------------");

        System.out.println("\n=== TEST 3: cliente Update =====");
        Cliente cliente1 = new Cliente(1,"Cliente 6", "666.666.666-66", "(66) 6666-6666");
		Update update = new Update(Db.getConn());
        update.update(cliente1);        
		System.out.println("Update! id = " + cliente1.getId());

        System.out.println("\n-------------------------------------------------------------------------");

        System.out.println("\n=== TEST 4: cliente Delete =====");
        Delete delete = new Delete(Db.getConn());
        int rowsAffected = delete.delete(1);        
		System.out.println(rowsAffected + " deleted rows");

        System.out.println("\n-------------------------------------------------------------------------");

        Db.closeConn();
    }
}
