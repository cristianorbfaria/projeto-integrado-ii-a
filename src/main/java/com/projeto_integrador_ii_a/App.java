package com.projeto_integrador_ii_a;

import java.util.*;

import com.projeto_integrador_ii_a.manager.PerguntaEntityManger;
import com.projeto_integrador_ii_a.entity.*;

public class App {

    public static void main(String[] args) {
        PerguntaEntityManger perguntaEntityManger = new PerguntaEntityManger();

        List<Pergunta> perguntas = perguntaEntityManger.getAll();

        System.out.println(perguntas.get(0).getEnunciado());
    }
}