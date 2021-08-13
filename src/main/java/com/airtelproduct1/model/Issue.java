package com.airtelproduct1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString


@Document(collection="Issue1")
public class Issue {
    @Id
    private String description;
    private int count;
    public Issue(String description,int count) {
        this.description = description;
        this.count=count;
    }
    public Issue() {

    }
}
