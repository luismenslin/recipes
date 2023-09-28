package com.recipes.application.data.model.Recipe;

import com.recipes.application.data.model.AbstractEntity;
import com.recipes.application.data.model.Step.Step;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe extends AbstractEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column
    private String image;

    @Column(nullable = false)
    private String ingredients;

    @OneToMany
    @Column(nullable = false)
    private List<Step> steps;

    public Recipe(TextField title, TextArea description, TextArea ingredients, TextField image) {
        this.title = title.getValue();
        this.description = description.getValue();
        this.ingredients = ingredients.getValue();
        this.image = image.getValue();
    }
}
