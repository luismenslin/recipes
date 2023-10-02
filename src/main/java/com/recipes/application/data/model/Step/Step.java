package com.recipes.application.data.model.Step;

import com.recipes.application.data.model.AbstractEntity;
import com.vaadin.flow.component.textfield.TextArea;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Step extends AbstractEntity {

    @Column(nullable = false)
    private String description;

    public Step(TextArea textArea) {
        this.description = textArea.getValue();
    }
}


