package com.example.antonio.aula10.DAO;

import com.example.antonio.aula10.util.Disciplina;
import com.example.antonio.aula10.util.Professor;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by antonio on 24/03/2016.
 */
public class DisciplinaDAO extends BaseDaoImpl<Disciplina, Integer>{
    public DisciplinaDAO(ConnectionSource connectionSource) throws SQLException {
        super(Disciplina.class);
        setConnectionSource(connectionSource);
        initialize();
    }
    //este método retorna um objeto queryBuilder que serve para que você possa construir seu
    //select utilizando clausulas como o where e operações como o like, o and...
    @Override
    public QueryBuilder<Disciplina, Integer> queryBuilder() {
        return super.queryBuilder();
    }
    //Com este método, você pode fazer os selects específicos utilizando as clausulas construídas
    //utilizando o queryBuilder
    @Override
    public List<Disciplina> query(PreparedQuery<Disciplina> preparedQuery) throws SQLException {
        return super.query(preparedQuery);
    }
}

