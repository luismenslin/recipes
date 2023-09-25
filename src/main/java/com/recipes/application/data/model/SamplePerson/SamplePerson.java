package com.recipes.application.data.model.SamplePerson;

import com.recipes.application.data.model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SamplePerson extends AbstractEntity {

    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String phone;

    private LocalDate dateOfBirth;

    private String occupation;

    private String role;

    private boolean important;
}
