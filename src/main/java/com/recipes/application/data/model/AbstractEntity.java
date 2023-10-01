package com.recipes.application.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateCreated;

    private Date dateUpdated;

    public AbstractEntity() {
        this.dateCreated = new Date();
        this.dateUpdated = new Date();
    }

    @PreUpdate
    private void setUpdatedDate() {
        this.dateUpdated = new Date();
    }
}
