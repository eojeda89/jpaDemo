package com.example.jpademo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * A DTO for the {@link com.example.jpademo.entities.Project} entity
 */
@Data
public class ProjectResponse implements Serializable {
    @Positive(message = "The id must be a positive number.")
    private final Long id;
    @NotBlank(message = "The name must not be a blank string")
    private final String name;
    private final String description;
    @Max(message = "The maximum value is 5", value = 5)
    @Min(message = "The minimum value is 0", value = 0)
    private final Integer type;
}