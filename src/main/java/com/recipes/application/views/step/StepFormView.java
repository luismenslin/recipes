package com.recipes.application.views.step;

import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.login.LoginI18n;
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
        HorizontalLayout header = new HorizontalLayout();
        HorizontalLayout body = new HorizontalLayout();
        HorizontalLayout footer = new HorizontalLayout();


        Button button = new Button("Complete with steps");
        button.setWidth("30%");
        button.addClickListener(e -> {
            title.add(new TextField("Title:"));
            description.add(new TextArea("Description:"));
            getContent().add(
                    title.get(title.toArray().length - 1),
                    description.get(description.toArray().length-1)
            );
        });

        header.add(new H3("Teste"));
        body.add(new TextArea("Teste"));
        footer.add(button);
        form.add(header, body, footer);

        getContent().add(form);
    }
}
