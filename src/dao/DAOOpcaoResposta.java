package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import model.OpcaoResposta;

public class DAOOpcaoResposta {

	public static void cadastrarOpcoesRespostas(List<OpcaoResposta> opcoesRespostas) {
		
		try (Connection conn = DBConnection.getConnection()) {
			
			for(int i=0; i < opcoesRespostas.size(); i++) {
				
				String sql = "INSERT INTO opcao_resposta (descricao, id_pergunta) VALUES (?,?);";
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, opcoesRespostas.get(i).getDescricao());
				ps.setInt(2, opcoesRespostas.get(i).getIdPergunta());

				ps.execute();
				
			}
			
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
	}
	
	public static List<OpcaoResposta> buscarOpcoesRespostas(int id) {
	
		try (Connection conn = DBConnection.getConnection()) {
			
			List<OpcaoResposta> opcoesRespostas = new ArrayList<OpcaoResposta>();
			
			String sql = "SELECT * FROM opcao_resposta WHERE id_pergunta="+ id +";";
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				
				OpcaoResposta opcaoResposta = new OpcaoResposta();
				opcaoResposta.setId(rs.getInt("id"));
				opcaoResposta.setDescricao(rs.getString("descricao"));
				opcoesRespostas.add(opcaoResposta);
				
			}
			
			DBConnection.destroyConnection(conn);
			return opcoesRespostas;
			
	   	  
	   	} catch (SQLException ex) {
	       System.out.println(ex.getMessage());
	   	}
		
		return null;
		
	}
	
}
