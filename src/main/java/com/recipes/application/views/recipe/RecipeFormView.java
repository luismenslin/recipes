package com.recipes.application.views.recipe;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.data.repository.recipe.RecipeJdbcRepository;
import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;

@PageTitle("Recipe Form")
@Route(value = "recipe-form", layout = MainLayout.class)
@Uses(Icon.class)
public class RecipeFormView extends Composite<VerticalLayout> {

    private final RecipeJdbcRepository repository = new RecipeJdbcRepository();

    public RecipeFormView () {
        VerticalLayout form = new VerticalLayout();
            form.setWidthFull();
        HorizontalLayout header = new HorizontalLayout();
            header.setWidth("50%");
        HorizontalLayout body = new HorizontalLayout();
            body.setWidth("50%");
        VerticalLayout verticalBody = new VerticalLayout();
            verticalBody.setWidthFull();
            verticalBody.setPadding(false);
        HorizontalLayout footer = new HorizontalLayout();
            footer.setWidth("50%");

        TextField inputTitle = new TextField("Titulo:");
            inputTitle.setWidthFull();
        TextArea inputDescription = new TextArea("Descrição:");
            inputDescription.setWidthFull();
        TextArea inputIngredients = new TextArea("Ingredientes:");
            inputIngredients.setWidthFull();
        TextField inputImagePath = new TextField("Caminho da imagem:");
            inputImagePath.setWidthFull();
        TextArea inputSteps = new TextArea("Passo a passo:");
            inputSteps.setWidthFull();

        Button button = new Button("Cadastrar receita!");
            button.setWidth("30%");
            button.addClickListener(e -> {
                try {
                    repository.save(new Recipe(inputTitle,inputDescription,inputIngredients,inputImagePath, inputSteps));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                UI.getCurrent().navigate(MyRecipesView.class);
        });

        header.add(new H3("Criar receita"));
        verticalBody.add(inputTitle,inputDescription, inputIngredients,inputImagePath,inputSteps);
        body.add(verticalBody);
        footer.add(button);
            footer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        form.add(header,body,footer);
        form.setAlignItems(FlexComponent.Alignment.CENTER);

        getContent().add(form);
    }
}
