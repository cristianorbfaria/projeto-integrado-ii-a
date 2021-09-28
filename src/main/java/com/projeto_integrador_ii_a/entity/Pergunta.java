package com.projeto_integrador_ii_a.entity;

import javax.persistence.*;

@Entity
@Table(name = "perguntas")
public class Pergunta {
    @Id
    @Column(name = "id_pergunta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPergunta;

    @Column(name = "numero_pergunta")
    private int numeroPergunta;

    @Column(name = "enunciado")
    private String enunciado;

    public int getIdPergunta() {
        return this.idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public int getNumeroPergunta() {
        return this.numeroPergunta;
    }

    public void setNumeroPergunta(int numeroPergunta) {
        this.numeroPergunta = numeroPergunta;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

}