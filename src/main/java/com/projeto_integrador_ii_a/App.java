package com.projeto_integrador_ii_a;

import com.projeto_integrador_ii_a.manager.PerguntaEntityManger;

public class App {

    public static void main(String[] args) {
        PerguntaEntityManger perguntaEntityManger = new PerguntaEntityManger();

        perguntaEntityManger.getAll();
    }
}