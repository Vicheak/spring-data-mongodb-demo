package com.vicheak.coreapp.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    private String id;
    private String username;
    private String gender;
    private LocalDate birthDate;

}
