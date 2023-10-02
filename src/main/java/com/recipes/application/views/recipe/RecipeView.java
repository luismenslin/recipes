package com.recipes.application.views.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.recipe.RecipeJdbcRepository;
import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;

@Route(value = "recipe-view", layout = MainLayout.class)
@Uses(Icon.class)
public class RecipeView extends Composite<VerticalLayout> implements HasUrlParameter<Long> {

    private RecipeJdbcRepository repository = new RecipeJdbcRepository();

    @Override
    public void setParameter(BeforeEvent beforeEvent, Long id) {
        Recipe recipe = null;
        try {
            recipe = repository.findById(id);
            constructUI(recipe);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void constructUI(Recipe recipe) {

        VerticalLayout form = new VerticalLayout();
        form.setWidthFull();
        HorizontalLayout body = new HorizontalLayout();
        body.setWidth("50%");
        VerticalLayout verticalBody = new VerticalLayout();
        verticalBody.setWidthFull();
        verticalBody.setPadding(false);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidth("50%");

        Image imagePath = new Image(recipe.getImage(), recipe.getTitle());
        imagePath.setWidthFull();
        imagePath.setMaxHeight("350px");
        imagePath.getStyle().set("border-radius", "20px");
        TextField title = new TextField("Title:");
        title.setWidthFull();
        title.setValue(recipe.getTitle());
        title.setReadOnly(true);
        TextArea description = new TextArea("Descrição:");
        description.setWidthFull();
        description.setValue(recipe.getDescription());
        description.setReadOnly(true);
        TextArea ingredients = new TextArea("Ingredients:");
        ingredients.setWidthFull();
        ingredients.setValue(recipe.getDescription());
        ingredients.setReadOnly(true);

        verticalBody.add(imagePath,title,description,ingredients);
        body.add(verticalBody);
        footer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        form.add(body,footer);
        form.setAlignItems(FlexComponent.Alignment.CENTER);

        getContent().add(form);
    }
}
