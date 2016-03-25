package com.example.antonio.aula10.util;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by antonio on 24/03/2016.
 */
public class Disciplina {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nome;
    @DatabaseField
    private int qtdeCreditos;
    @ForeignCollectionField
    Collection<Professor> professores = new ArrayList<>();

    public Disciplina(String nome, int qtdeCreditos) {
        this.nome = nome;
        this.qtdeCreditos = qtdeCreditos;
    }

    public void addProfessor(Professor professor){
        this.professores.add(professor);
    }
    public void removerProfessor(Professor professor){
        this.professores.remove(professor);
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdeCreditos() {
        return qtdeCreditos;
    }

    public void setQtdeCreditos(int qtdeCreditos) {
        this.qtdeCreditos = qtdeCreditos;
    }

    public String toString(){
        return "id: "+this.id+"\nnome: "+this.nome+"\nQuantidade de créditos: " +this.qtdeCreditos;
    }
}
