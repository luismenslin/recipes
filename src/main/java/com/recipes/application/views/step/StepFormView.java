package com.recipes.application.views.step;

import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
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

import java.util.ArrayList;
import java.util.List;

@PageTitle("Steps")
@Route(value = "step-form", layout = MainLayout.class)
@Uses(Icon.class)
public class StepFormView extends Composite<VerticalLayout> {

    public StepFormView () {
        List<TextField> title = new ArrayList<>();
        List<TextArea> description = new ArrayList<>();
        VerticalLayout form = new VerticalLayout();
        form.setWidthFull();
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("50%");
        VerticalLayout body = new VerticalLayout();
        body.setWidth("50%");
        setStyle(body);
        HorizontalLayout footer = new HorizontalLayout();
        footer.setWidth("50%");

        H3 formTitle = new H3("Enter the steps");
            formTitle.setWidthFull();
        TextField firstStep= new TextField("Step:");
            firstStep.setWidthFull();
        TextArea firstDescription = new TextArea("Description:");
            firstDescription.setWidthFull();
        title.add(firstStep);
        description.add(firstDescription);

        Button buttonAnotherStep = new Button("Another step");
        buttonAnotherStep.addClickListener(e -> {
            title.add(setStyle(new TextField("Step:")));
            description.add(this.setStyle(new TextArea("Description:")));
            body.add(
                    setStyle(
                    new VerticalLayout(
                            title.get(title.toArray().length-1),
                            description.get(title.toArray().length-1)
                    )));
        });

        Button buttonSubmit = new Button("Submit");

        header.add(formTitle);
        body.add(setStyle(new VerticalLayout(title.get(0), description.get(0))));
        footer.add(buttonAnotherStep, buttonSubmit);

        form.add(header,body,footer);
        form.setAlignItems(FlexComponent.Alignment.CENTER);
        getContent().add(form);
    }

    private TextField setStyle(TextField component) {
        component.setWidthFull();
        return component;
    }

    private TextArea setStyle(TextArea component) {
        component.setWidthFull();
        return component;
    }

    private VerticalLayout setStyle(VerticalLayout layout) {
        layout.setPadding(false);
        return layout;
    }
}
