package com.recipes.application.data.repository;

import java.sql.SQLException;
import java.util.List;

public interface JdbcRepository<T> {

    T findById(int id) throws SQLException;

    List<T> findAll() throws SQLException;

    void save(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    void delete(int id) throws SQLException;
}
