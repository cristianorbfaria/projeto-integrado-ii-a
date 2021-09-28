package com.projeto_integrador_ii_a.entity;

import javax.persistence.*;

@Entity
@Table(name = "resposta_padrao")
public class Tipo {
    @Id
    @Column(name = "id_tipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "fk_id_pergunta")
    private int fkIdPergunta;

    public int getIdTipo() {
        return this.idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFkIdPergunta() {
        return this.fkIdPergunta;
    }

    public void setFkIdPergunta(int fkIdPergunta) {
        this.fkIdPergunta = fkIdPergunta;
    }

}