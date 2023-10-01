package com.recipes.application.data.repository;

import jdk.jshell.spi.ExecutionControl;

import java.sql.SQLException;
import java.util.List;

public interface JdbcRepository<T> {

    T findById(Integer id) throws SQLException;

    List<T> findAll() throws SQLException;

    void save(T entity) throws SQLException;

    void update(T entity) throws SQLException, ExecutionControl.NotImplementedException;

    void delete(Integer id) throws SQLException, ExecutionControl.NotImplementedException;
}
