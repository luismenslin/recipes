package com.recipes.application.data.model.Recipe;

import com.recipes.application.data.model.AbstractEntity;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(nullable = false)
    private String steps;

    @Column
    private Boolean favorite;

    public Recipe(TextField title, TextArea description, TextArea ingredients, TextField image, TextArea steps) {
        this.title = title.getValue();
        this.description = description.getValue();
        this.ingredients = ingredients.getValue();
        this.image = image.getValue();
        this.steps = steps.getValue();
    }
}
