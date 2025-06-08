/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmysql;

/**
 *
 * Entidade Aluno
 */
public class Aluno {
    private int id;
    private String nome;

    private double simulado1;
    private double simulado2;
    private double av;

    private Integer genero;

    private double notafinal;


    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Aluno(String nome, double simulado1, double simulado2, double av, Integer genero, double notafinal) {
        this.nome = nome;
        this.simulado1 = simulado1;
        this.simulado2 = simulado2;
        this.av = av;
        this.genero = genero;
    }

    public Aluno(int id, String nome, double simulado1, double simulado2, double av, Integer genero, double notafinal) {
        this.id = id;
        this.nome = nome;
        this.simulado1 = simulado1;
        this.simulado2 = simulado2;
        this.av = av;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSimulado1() {
        return simulado1;
    }

    public void setSimulado1(double simulado1) {
        this.simulado1 = simulado1;
    }

    public double getSimulado2() {
        return simulado2;
    }

    public void setSimulado2(double simulado2) {
        this.simulado2 = simulado2;
    }

    public double getAv() {
        return av;
    }

    public void setAv(double av) {
        this.av = av;
    }

    public Integer getGenero() {
        return genero;
    }

    public void setGenero(Integer genero) {
        this.genero = genero;
    }

    public double getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(double notafinal) {
        this.notafinal = notafinal;
    }

    @Override
    public String toString() {

        String generoResultado = (genero == 1) ? "Masculino" : "Feminino";

        double notafinal = simulado1 + simulado2 + av;
        double somafinal = notafinal > 10 ? 10 : notafinal;

        return "ID: " + id +
                " | Nome: " + nome +
                " | Simulado 1: " + simulado1 +
                " | Simulado 2: " + simulado2 +
                " | AV: " + av +
                " | Gênero: " + generoResultado +
                " | Nota final: " + somafinal;
    }
}
