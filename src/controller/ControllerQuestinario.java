package controller;

import java.util.List;

import dao.DAOQuestinario;
import model.Questinario;

public class ControllerQuestinario {
	
	public static List<Questinario> buscarTodosQuestionarios() {
		
		List<Questinario> questinarios = DAOQuestinario.buscarTodos();
		
		return questinarios;
	}
	
	public static boolean existeQuestinario(int id) {
		
		boolean isExist = false;
		
		isExist = DAOQuestinario.existeQuestinario(id);
		
		return isExist;
	}

}
