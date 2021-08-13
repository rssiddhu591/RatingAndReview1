package com.airtelproduct1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection="User1")
public class User {
    @Id
    private String name;
    public User(String name) {
        this.name = name;

    }
    public User() {

    }
}
