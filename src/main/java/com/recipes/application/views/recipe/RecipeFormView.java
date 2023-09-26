package com.recipes.application.views.recipe;

import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("Recipe Form")
@Route(value = "recipe-form", layout = MainLayout.class)
@Uses(Icon.class)
public class RecipeFormView extends Composite<VerticalLayout> {

    public RecipeFormView () {
        VerticalLayout form = new VerticalLayout();
            form.setWidthFull();
        HorizontalLayout title = new HorizontalLayout();
        HorizontalLayout description = new HorizontalLayout();
        HorizontalLayout ingredients = new HorizontalLayout();
        HorizontalLayout imagePath = new HorizontalLayout();

        TextField inputTitle = new TextField("Title:");
        TextArea inputDescription = new TextArea("Description:");
        TextArea inputIngredients = new TextArea("Ingredients:");
        TextField inputImagePath = new TextField("Image Path:");




    }
}
