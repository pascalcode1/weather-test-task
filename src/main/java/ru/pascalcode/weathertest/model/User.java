package ru.pascalcode.weathertest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * User entity.
 */
@Data
@Table("usr")
public class User {

    @Id
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

}
