package com.projeto_integrador_ii_a;

import java.util.*;
import com.projeto_integrador_ii_a.models.*;

public class App {
    public static void main(String[] args) {
        // Criando uma pergunta
        Pergunta pergunta = new Pergunta();

        Tipo tipo = new Tipo();
        tipo.setIdTipo(0);
        tipo.setTipo("Discursiva");

        RespostaPadrao respostaPadrao = new RespostaPadrao();
        respostaPadrao.setIdResposta(0);
        respostaPadrao.setValorDiscursiva("Pedro");

        pergunta.setIdPergunta(1);
        pergunta.setNumeroPergunta(0);
        pergunta.setEnunciado("Qual o nome do Pedro?");
        pergunta.setRespostaPadrao(respostaPadrao);
        pergunta.setTipo(tipo);

        Pergunta.save(pergunta);

        // Listando todas as perguntas do banco de dados
        ArrayList<Pergunta> perguntas = Pergunta.findAll();

        for (int i = 0; i < perguntas.size(); i++) {
            Pergunta perguntaDB = perguntas.get(i);
            System.out.println(perguntaDB.getEnunciado() + " : " + perguntaDB.getIdPergunta());
        }
    }
}
