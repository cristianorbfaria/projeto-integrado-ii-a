package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.Pergunta;

public class DAOPergunta {
	
	public static int cadastrarPerguntas(Pergunta pergunta) {
	
		try (Connection conn = DBConnection.getConnection()) {
			
				int idPergunta= 0;	
				String generatedColumns[] = { "ID" };
				
				String sql = "INSERT INTO pergunta (enunciado, id_questionario, id_tipo_pergunta) VALUES (?,?,?);";
				
				PreparedStatement ps = conn.prepareStatement(sql, generatedColumns);
				
				ps.setString(1, pergunta.getEnunciado());
				ps.setInt(2, pergunta.getIdQuestionario());
				ps.setInt(3, pergunta.getIdTipoPergunta());

				ps.execute();
				
				ResultSet rs = ps.getGeneratedKeys();
				
				if (rs.next()) {
					
				    idPergunta = rs.getInt(1);
				    
				    DBConnection.destroyConnection(conn);
				    
				    return idPergunta;
				    
				} else {
					
					return 0;
					
				}
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return 0;
		
	}
	
	public static List<Pergunta> buscarTodos() {
		
		List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
		try (Connection conn = DBConnection.getConnection()) {
			
			String sql = "SELECT * FROM pergunta;";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				
				Pergunta pergunta = new Pergunta();
				
				pergunta.setId(rs.getInt("id"));
				pergunta.setEnunciado(rs.getString("enunciado"));
				pergunta.setIdQuestionario(rs.getInt("id_questionario"));
				pergunta.setIdTipoPergunta(rs.getInt("id_tipo_pergunta"));
				perguntas.add(pergunta);
				
			}
			
			DBConnection.destroyConnection(conn);
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return perguntas;
	}

}
