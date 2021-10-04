package controller;

import java.util.List;

import dao.DAOPergunta;
import model.Pergunta;

public class ControllerPergunta {

	public static int cadastrarPergunta(Pergunta pergunta) {
		int idPergunta = 0;
		
		idPergunta = DAOPergunta.cadastrarPerguntas(pergunta);
		
		return idPergunta;
		
	}
	
	public static List<Pergunta> buscarTodos() {
		
		List<Pergunta> perguntas = DAOPergunta.buscarTodos();
		
		return perguntas;
	}
	

}
