package com.mycompany.crudmysql;

import java.util.List;

public class RelatorioTurma {
    private List<Aluno> alunos;
    private double mediaTurma;

    public RelatorioTurma(List<Aluno> alunos, double mediaTurma) {
        this.alunos = alunos;
        this.mediaTurma = mediaTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public double getMediaTurma() {
        return mediaTurma;
    }
}
