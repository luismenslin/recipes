package com.recipes.application.views.step;

import com.recipes.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Step Form")
@Route(value = "step-form", layout = MainLayout.class)
@Uses(Icon.class)
public class StepFormView extends Composite<VerticalLayout> {

    public StepFormView () {
        
    }
}
