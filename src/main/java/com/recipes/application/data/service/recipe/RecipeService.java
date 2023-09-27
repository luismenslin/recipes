package com.recipes.application.data.service.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.recipe.RecipeJdbcRepository;

import java.sql.SQLException;

public class RecipeService {

    private final RecipeJdbcRepository recipeJdbcRepository;

    public RecipeService(RecipeJdbcRepository recipeJdbcRepository) {
        this.recipeJdbcRepository = recipeJdbcRepository;
    }

    public Recipe getRecipeById(int id) throws SQLException {
        return recipeJdbcRepository.findById(id);
    }
}
