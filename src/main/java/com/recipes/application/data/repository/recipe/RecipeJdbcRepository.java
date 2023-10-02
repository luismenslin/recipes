package com.recipes.application.data.repository.recipe;
import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.model.Step.Step;
import com.recipes.application.data.repository.DatabaseManager;
import com.recipes.application.data.repository.JdbcRepository;
import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeJdbcRepository extends DatabaseManager implements JdbcRepository<Recipe> {

    @Override
    public Recipe findById(Integer id) throws SQLException {
        String sql = """
                select id,
                date_created,
                date_updated,
                description,
                image,
                ingredients,
                title
                from recipe
                where id = ?
                """;
        Recipe recipe = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                recipe = new Recipe();
                recipe.setDescription(resultSet.getString("description"));
                recipe.setImage(resultSet.getString("image"));
                recipe.setIngredients(resultSet.getString("ingredients"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar receitas");
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public List<Recipe> findAll() throws SQLException {
        String sql = """
                select id,
                date_created,
                date_updated,
                description,
                image,
                ingredients,
                title
                from recipe
                    """;
        List<Recipe> RecipeList = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(rs.getLong("id"));
                recipe.setDescription(rs.getString("description"));
                recipe.setImage(rs.getString("image"));
                recipe.setIngredients(rs.getString("ingredients"));
                recipe.setTitle(rs.getString("title"));
                RecipeList.add(recipe);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar receitas");
            e.printStackTrace();
        }
        return RecipeList;
    }

    @Override
    public void save(Recipe entity) throws SQLException {

        try (Connection connection = DatabaseManager.getConnection()) {
            String sql = """
                insert into recipe
                    (title,description,image,ingredients,steps,date_created,date_updated)
                        values(?,?,?,?,?,?,?)
                """;

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, entity.getTitle());
        pstm.setString(2, entity.getDescription());
        pstm.setString(3, entity.getImage());
        pstm.setString(4, entity.getIngredients());
        pstm.setString(5, entity.getSteps());
        pstm.setDate(6, new Date(entity.getDateCreated().getYear(),
                entity.getDateCreated().getMonth(),
                entity.getDateCreated().getDay()));
        pstm.setDate(7, new Date(entity.getDateUpdated().getYear(),
                entity.getDateCreated().getMonth(),
                entity.getDateCreated().getDay()));

        pstm.executeUpdate();

        pstm.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void update(Recipe entity) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Ainda não implementado");
    }

    @Override
    public void delete(Long id) throws SQLException, ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Ainda não implementado");
    }

    public void saveStep(Step entity) throws SQLException {

        try (Connection connection = DatabaseManager.getConnection()) {
            String sql = """
                update recipe set
                    steps = ?
                    where id = (select id from recipe order by id desc limit 1)
                """;

            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, entity.getDescription());

            pstm.executeUpdate();

            pstm.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void setFavorite(Long id) throws SQLException {
        String sql = """
                select id,
                date_created,
                date_updated,
                description,
                image,
                ingredients,
                title
                from recipe
                where id = ?
                """;
        Recipe recipe = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                recipe = new Recipe();
                recipe.setDescription(resultSet.getString("description"));
                recipe.setImage(resultSet.getString("image"));
                recipe.setIngredients(resultSet.getString("ingredients"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar receitas");
            e.printStackTrace();
        }
    }
}
