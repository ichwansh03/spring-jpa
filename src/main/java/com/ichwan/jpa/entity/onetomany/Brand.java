package com.ichwan.jpa.entity.onetomany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    private String id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;
}

