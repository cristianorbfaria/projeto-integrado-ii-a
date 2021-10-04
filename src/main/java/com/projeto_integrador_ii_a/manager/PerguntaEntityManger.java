package com.projeto_integrador_ii_a.manager;

import java.util.*;
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

    public List<Pergunta> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Pergunta> query = entityManager.createQuery("SELECT p FROM Pergunta p", Pergunta.class);
        List<Pergunta> perguntas = query.getResultList();

        entityManager.close();

        return perguntas;
    }
}
