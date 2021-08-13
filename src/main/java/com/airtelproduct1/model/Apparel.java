package com.airtelproduct1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection="Apparel1")
public class Apparel {
    @Id
    private String name;
    private int count;
    private double rating;
    public Apparel() {

    }
    public Apparel(String name,double rating,int count) {
        this.name = name;
        this.rating=rating;
        this.count=count;

    }

}
