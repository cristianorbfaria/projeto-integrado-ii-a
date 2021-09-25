package com.projeto_integrador_ii_a.models;

import java.sql.*;
import java.util.*;

import com.projeto_integrador_ii_a.database.Database;

public class Pergunta {
    private int idPergunta;
    private int numeroPergunta;
    private String enunciado;
    private Tipo tipo;
    private RespostaPadrao respostaPadrao;

    public static ArrayList<Pergunta> findAll() {
        try {
            Database db = new Database();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT *");
            sql.append("FROM perguntas");

            ResultSet result = db.executeQuery(sql);
            ArrayList<Pergunta> perguntas = new ArrayList<>();

            while (result.next()) {
                Pergunta pergunta = new Pergunta();
                pergunta.setEnunciado(result.getString("enunciado"));
                pergunta.setIdPergunta(result.getInt("id_pergunta"));
                pergunta.setNumeroPergunta(result.getInt("numero_pergunta"));
                perguntas.add(pergunta);
            }

            return perguntas;
        } catch (Exception error) {
            System.out.println(error);
            return null;
        }
    }

    public static void save(Pergunta pergunta) {
        try {
            Database db = new Database();

            String sqlQuestion = "INSERT INTO perguntas VALUES(" + null + ", " + pergunta.numeroPergunta + ", '"
                    + pergunta.enunciado + "')";
            String sqlType = "INSERT INTO tipos VALUES(" + null + ", '" + pergunta.tipo.getTipo() + "', "
                    + pergunta.idPergunta + ")";
            String sqlresponse = "INSERT INTO resposta_padrao VALUES(" + null + ", '"
                    + pergunta.respostaPadrao.getValorVouF() + "', '" + pergunta.respostaPadrao.getValorX() + "', "
                    + pergunta.idPergunta + ", " + pergunta.tipo.getIdTipo() + ")";

            db.executeUpdate(sqlQuestion);
            System.out.println(sqlQuestion);

            db.executeUpdate(sqlType);
            System.out.println(sqlType);

            db.executeUpdate(sqlresponse);
            System.out.println(sqlresponse);
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public int getIdPergunta() {
        return this.idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public RespostaPadrao getRespostaPadrao() {
        return this.respostaPadrao;
    }

    public void setRespostaPadrao(RespostaPadrao respostaPadrao) {
        this.respostaPadrao = respostaPadrao;
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

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}