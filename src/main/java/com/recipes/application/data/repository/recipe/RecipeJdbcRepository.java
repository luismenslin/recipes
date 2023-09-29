package com.recipes.application.data.repository.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.JdbcRepository;
import com.recipes.application.data.repository.DatabaseManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RecipeJdbcRepository implements JdbcRepository<Recipe> {


    @Override
    public Recipe findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<Recipe> findAll() throws SQLException {
        return null;
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
        pstm.setString(5,"steps vazios");
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
    public void update(Recipe entity) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {

    }
}
