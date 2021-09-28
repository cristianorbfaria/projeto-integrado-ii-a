package com.projeto_integrador_ii_a.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.projeto_integrador_ii_a.entity.Pergunta;

public class PerguntaEntityManger {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Projeto-Integrador-II-A");

    public void save(Pergunta pergunta) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pergunta);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public ArrayList<Pergunta> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Pergunta> perguntas = new ArrayList<>();

        entityManager.close();

        return perguntas;
    }
}
