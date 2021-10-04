package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Questinario;

public class DAOQuestinario {
	
	public static List<Questinario> buscarTodos() {
		
		List<Questinario> questinarios = new ArrayList<Questinario>();
	
		try (Connection conn = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM questionario;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			Questinario questionario = new Questinario();
			
			while(rs.next()){
				
				questionario.setId(rs.getInt("id"));
				questionario.setDescricao(rs.getString("descricao"));
				questinarios.add(questionario);
				
			}
			
			DBConnection.destroyConnection(conn);
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return questinarios;
	}
	
	public static boolean existeQuestinario(int id) {
	
		try (Connection conn = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM questionario where id = "+ id +";";
			
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			
			int n = 0;
			if (rs.next()) {
			    n = rs.getInt(1);
			}
			
			if ( n > 0 ) {
			   return true;  
			} else {
				return false;
			}
			
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return false;
		
	}

}
