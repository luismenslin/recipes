package com.recipes.application.data.repository.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.JdbcRepository;

import java.sql.SQLException;
import java.util.List;

public class RecipeJdbcRepository implements JdbcRepository<Recipe> {


    @Override
    public Recipe findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Recipe> findAll() throws SQLException {
        return null;
    }

    @Override
    public void save(Recipe entity) throws SQLException {

    }

    @Override
    public void update(Recipe entity) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
