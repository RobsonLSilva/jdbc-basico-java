package robson.jdbc.exemplos.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import robson.jdbc.exemplos.java.db.Db;
import robson.jdbc.exemplos.java.db.DbException;
import robson.jdbc.exemplos.java.model.entities.Cliente;

public class Update {
    private Connection conn;

    public Update(Connection conn) {
        this.conn = conn;
    }

    public void update(Cliente obj){

        String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=? WHERE id=?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpf());
            ps.setString(3, obj.getTelefone());
            ps.setInt(4, obj.getId());

            //ps.execute();
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			}
			else {
				throw new DbException("Unexpected error! No rows affected!");
			}
            
        } catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			Db.closeStatement(ps);
		}
    }     
}