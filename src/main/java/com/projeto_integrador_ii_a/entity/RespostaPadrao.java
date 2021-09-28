package com.projeto_integrador_ii_a.entity;

import javax.persistence.*;

@Entity
@Table(name = "resposta_padrao")
public class RespostaPadrao {
    @Id
    @Column(name = "id_resposta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResposta;

    @Column(name = "valor_discursiva")
    private String valorDiscursiva;

    @Column(name = "valor_v_ou_f")
    private String valorVouF;

    @Column(name = "valor_x")
    private String valorX;

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

    public int getIdResposta() {
        return this.idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public String getValorDiscursiva() {
        return this.valorDiscursiva;
    }

    public void setValorDiscursiva(String valorDiscursiva) {
        this.valorDiscursiva = valorDiscursiva;
    }

    public String getValorVouF() {
        return this.valorVouF;
    }

    public void setValorVouF(String valorVouF) {
        this.valorVouF = valorVouF;
    }

    public String getValorX() {
        return this.valorX;
    }

    public void setValorX(String valorX) {
        this.valorX = valorX;
    }

}
