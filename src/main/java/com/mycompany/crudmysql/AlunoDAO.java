/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crudmysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Operacoes com banco de dados
 * 
 */
public class AlunoDAO {

    public void inserir(Aluno aluno) {

        aluno.setNotafinal(aluno.getSimulado1() + aluno.getSimulado2() + aluno.getAv());

        double somafinal = aluno.getNotafinal() > 10 ? 10 : aluno.getNotafinal();

        String sql = "INSERT INTO alunos (nome, simulado1, simulado2, av, genero, notafinal) VALUES (?,?,?,?,?,?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setDouble(2, aluno.getSimulado1());
            stmt.setDouble(3, aluno.getSimulado2());
            stmt.setDouble(4, aluno.getAv());
            stmt.setInt(5, aluno.getGenero());
            stmt.setDouble(6, somafinal);
            stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("simulado1"),
                        rs.getDouble("simulado2"),
                        rs.getDouble("av"),
                        rs.getInt("genero"),
                        rs.getDouble("notafinal"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public void atualizar(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ? WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getId());
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("ID não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("ID não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> relatorioNotaFinalSuperior7() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos WHERE notafinal > 7";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("simulado1"),
                        rs.getDouble("simulado2"),
                        rs.getDouble("av"),
                        rs.getInt("genero"),
                        rs.getDouble("notafinal"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public List<Aluno> relatorioFemininoNotaFinalSuperior7() {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos WHERE genero = 2 AND notafinal > 7";
        try (Connection conn = Conexao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getDouble("simulado1"),
                        rs.getDouble("simulado2"),
                        rs.getDouble("av"),
                        rs.getInt("genero"),
                        rs.getDouble("notafinal"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public RelatorioTurma relatorioNotaFinalTodosAlunosEMediaTurma() {

    }

}
