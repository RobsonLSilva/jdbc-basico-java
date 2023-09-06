package robson.jdbc.exemplos.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import robson.jdbc.exemplos.java.db.Db;
import robson.jdbc.exemplos.java.db.DbException;

public class Delete {
    
    private Connection conn;

    public Delete(Connection conn){
        this.conn = conn;
    }

    public int delete(int id){
        int rowsAffected = 0;
        String sql = "DELETE FROM clientes WHERE id=?";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            //ps.execute();
            rowsAffected = ps.executeUpdate();     
        } catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			Db.closeStatement(ps);
		}
        return rowsAffected;
    }
}
