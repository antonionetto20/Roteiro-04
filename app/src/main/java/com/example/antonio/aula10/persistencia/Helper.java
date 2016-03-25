package com.example.antonio.aula10.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.antonio.aula10.util.Aluno;
import com.example.antonio.aula10.util.Disciplina;
import com.example.antonio.aula10.util.Professor;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class Helper extends OrmLiteSqliteOpenHelper{
    private static final String NOME = "ayty";
    private static final int VERSAO = 2;

    public Helper(Context context) {
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Professor.class);
            TableUtils.createTable(connectionSource, Aluno.class);
            TableUtils.createTable(connectionSource, Disciplina.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, Aluno.class, true);
            TableUtils.dropTable(connectionSource, Professor.class, true);
            TableUtils.dropTable(connectionSource, Disciplina.class, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
