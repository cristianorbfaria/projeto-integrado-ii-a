package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.TipoPergunta;

public class DAOTipoPergunta {
    
	public static List<TipoPergunta> getAll() {
		
		List<TipoPergunta> tiposPerguntas = new ArrayList<TipoPergunta>();
	
		try (Connection conn = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM tipo_pergunta;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				TipoPergunta tiposPergunta = new TipoPergunta();
				tiposPergunta.setId(rs.getInt("id"));
				tiposPergunta.setDescricao(rs.getString("descricao"));
				tiposPerguntas.add(tiposPergunta);
				
			}
			
			DBConnection.destroyConnection(conn);
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return tiposPerguntas;
	}
	
	public static boolean existeTipoPergunta(int id) {
		
		try (Connection conn = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM tipo_pergunta where id = "+ id +";";
			
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
