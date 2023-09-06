package robson.jdbc.exemplos.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import robson.jdbc.exemplos.java.db.Db;
import robson.jdbc.exemplos.java.db.DbException;
import robson.jdbc.exemplos.java.model.entities.Cliente;

public class Select {
    private Connection conn;

    public Select(Connection conn) {
        this.conn = conn;
    }

    public List<Cliente> findAll(){
        String sql = "SELECT * FROM clientes ORDER BY nome";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            List<Cliente> list = new ArrayList<>();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                list.add(obj);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally{
            Db.closeStatement(ps);
            Db.closeResultSet(rs);
        }
    }
}
