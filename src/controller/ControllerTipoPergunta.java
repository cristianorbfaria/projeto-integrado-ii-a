package controller;

import java.util.List;

import dao.DAOTipoPergunta;
import model.TipoPergunta;

public class ControllerTipoPergunta {
	
	public static List<TipoPergunta> buscarTodosTiposPerguntas() {
		
		List<TipoPergunta> tiposPerguntas = DAOTipoPergunta.getAll();
		
		return tiposPerguntas;
	}
	
	public static boolean existeTipoPergunta(int id) {
		
		boolean isExist = false;
		
		isExist = DAOTipoPergunta.existeTipoPergunta(id);
		
		return isExist;
	}
	
}
