package com.example.antonio.aula10.persistencia;

import android.content.Context;

import com.example.antonio.aula10.DAO.DisciplinaDAO;
import com.example.antonio.aula10.util.Aluno;
import com.example.antonio.aula10.DAO.AlunoDAO;
import com.example.antonio.aula10.DAO.ProfessorDAO;
import com.example.antonio.aula10.util.Disciplina;
import com.example.antonio.aula10.util.Professor;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonio on 24/03/2016.
 */
public class DB {
    private Helper helper;//Classe para o controle do banco
    private AlunoDAO alunoDAO;//Classe para o controle da entidade aluno
    private ProfessorDAO professorDAO;//Classe para o controle da entidade professor
    private DisciplinaDAO disciplinaDAO; //Classe para o controle da entidade disciplina

    public DB(Context context) {//recebo o contexto da aplicação no construtor
        helper = new Helper(context);//instanciação do helper utilizando o contexto
        try {//tratamento de excessão
            alunoDAO = new AlunoDAO(helper.getConnectionSource());//instanciação do DAO do aluno
            professorDAO = new ProfessorDAO(helper.getConnectionSource());//instanciação do DAO do professor
            disciplinaDAO = new DisciplinaDAO(helper.getConnectionSource());//instanciação do DAO do disciplina
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //==========================================================================Aluno CRUD
    public void insertAluno(Aluno aluno) throws SQLException {
        alunoDAO.create(aluno);//INSERT
    }
    public void updateAluno(Aluno aluno) throws SQLException {
        alunoDAO.update(aluno);//UPDATE
    }
    public void deleteAluno(Aluno aluno) throws SQLException {
        alunoDAO.delete(aluno);//DELETE
    }
    public List<Aluno> selectAluno() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        alunos = alunoDAO.queryForAll();//SELECT *
        return  alunos;
    }
    public List<Aluno> selectAlunoById(int id) throws SQLException {
        QueryBuilder<Aluno, Integer> builder = alunoDAO.queryBuilder();//INSTANCIAÇÃO DO CONSTRUTOR DA QUERY
        builder.where().idEq(id);//CONSTRUÇÃO DO SQL COM A CLAUSULA WHERE
        PreparedQuery<Aluno> preparedQuery = builder.prepare();//
        List<Aluno> alunos = alunoDAO.query(preparedQuery);//SELECT ESPECÍFICO
        return alunos;
    }
    //===============================================================================Professor CRUD
    public void insertProfessor(Professor professor) throws SQLException {
        professorDAO.create(professor);//INSERT
    }public void updateProfessor(Professor professor) throws SQLException {
        professorDAO.update(professor);//UPDATE
    }
    public void deleteProfessor(Professor professor) throws SQLException {
        professorDAO.delete(professor);//DELETE
    }
    public List<Professor> selectProfessor() throws SQLException {
        List<Professor> professores = new ArrayList<>();
        professores = professorDAO.queryForAll();//SELECT *
        return  professores;
    }
    public List<Professor> selectProfessorById(int id) throws SQLException {
        QueryBuilder<Professor, Integer> builder = professorDAO.queryBuilder();//INSTANCIAÇÃO DO CONSTRUTOR DA QUERY
        builder.where().idEq(id);//CONSTRUÇÃO DO SQL COM A CLAUSULA WHERE
        PreparedQuery<Professor> preparedQuery = builder.prepare();//
        List<Professor> professores = professorDAO.query(preparedQuery);//SELECT ESPECÍFICO
        return professores;
    }

    //===============================================================================Disciplina CRUD
    public void insertDisciplina(Disciplina disciplina) throws SQLException {
        disciplinaDAO.create(disciplina);//INSERT
    }public void updateDisciplina(Disciplina disciplina) throws SQLException {
        disciplinaDAO.update(disciplina);//UPDATE
    }
    public void deleteDisciplina(Disciplina disciplina) throws SQLException {
        disciplinaDAO.delete(disciplina);//DELETE
    }
    public List<Disciplina> selectDisciplina() throws SQLException {
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas = disciplinaDAO.queryForAll();//SELECT *
        return  disciplinas;
    }
    public List<Disciplina> selectDisciplinaById(int id) throws SQLException {
        QueryBuilder<Disciplina, Integer> builder = disciplinaDAO.queryBuilder();//INSTANCIAÇÃO DO CONSTRUTOR DA QUERY
        builder.where().idEq(id);//CONSTRUÇÃO DO SQL COM A CLAUSULA WHERE
        PreparedQuery<Disciplina> preparedQuery = builder.prepare();//
        List<Disciplina> disciplinas = disciplinaDAO.query(preparedQuery);//SELECT ESPECÍFICO
        return disciplinas;
    }

}
