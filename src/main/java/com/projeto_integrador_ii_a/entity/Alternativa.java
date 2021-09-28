package com.projeto_integrador_ii_a.entity;

import javax.persistence.*;

@Entity
@Table(name = "perguntas")
public class Alternativa {
    @Id
    @Column(name = "id_alternativa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlternativa;

    @Column(name = "opcoes")
    private String opcoes;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fk_id_pergunta")
    private int fkIdPergunta;

    @Column(name = "fk_id_tipo")
    private int fkIdTipo;

    public int getFkIdPergunta() {
        return this.fkIdPergunta;
    }

    public void setFkIdPergunta(int fkIdPergunta) {
        this.fkIdPergunta = fkIdPergunta;
    }

    public int getFkIdTipo() {
        return this.fkIdTipo;
    }

    public void setFkIdTipo(int fkIdTipo) {
        this.fkIdTipo = fkIdTipo;
    }

    public int getIdAlternativa() {
        return this.idAlternativa;
    }

    public void setIdAlternativa(int idAlternativa) {
        this.idAlternativa = idAlternativa;
    }

    public String getOpcoes() {
        return this.opcoes;
    }

    public void setOpcoes(String opcoes) {
        this.opcoes = opcoes;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}