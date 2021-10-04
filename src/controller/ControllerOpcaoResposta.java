package controller;

import java.util.List;

import dao.DAOOpcaoResposta;
import model.OpcaoResposta;

public class ControllerOpcaoResposta {
	
	public static List<OpcaoResposta> buscarOpcoesRespostas(int id) {
		
		List<OpcaoResposta> opcaoResposta = DAOOpcaoResposta.buscarOpcoesRespostas(id);
		
		return opcaoResposta;
	}

	public static void cadastrarOpcaoResposta(List<OpcaoResposta> opcoesRespostas) {
		
		DAOOpcaoResposta.cadastrarOpcoesRespostas(opcoesRespostas);
		
	}
	
}
