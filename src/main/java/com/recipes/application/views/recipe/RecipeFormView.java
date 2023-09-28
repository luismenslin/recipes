package com.recipes.application.views.recipe;

import com.recipes.application.views.MainLayout;
import com.recipes.application.views.step.StepFormView;
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

@PageTitle("Recipe Form")
@Route(value = "recipe-form", layout = MainLayout.class)
@Uses(Icon.class)
public class RecipeFormView extends Composite<VerticalLayout> {

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

        TextField inputTitle = new TextField("Title:");
            inputTitle.setWidthFull();
        TextArea inputDescription = new TextArea("Description:");
            inputDescription.setWidthFull();
        TextArea inputIngredients = new TextArea("Ingredients:");
            inputIngredients.setWidthFull();
        TextField inputImagePath = new TextField("Image Path:");
            inputImagePath.setWidthFull();

        Button button = new Button("Complete with steps");
            button.setWidth("30%");
            button.addClickListener(e -> {
            UI.getCurrent().navigate(StepFormView.class);
        });

        header.add(new H3("Recipe Form"));
        verticalBody.add(inputTitle,inputDescription, inputIngredients,inputImagePath);
        body.add(verticalBody);
        footer.add(button);
            footer.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        form.add(header,body,footer);
        form.setAlignItems(FlexComponent.Alignment.CENTER);

        getContent().add(form);
    }
}
