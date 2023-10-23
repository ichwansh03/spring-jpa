package com.ichwan.jpa.entity.onetomany;

import com.ichwan.jpa.entity.onetoone.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;

    @ManyToMany(mappedBy = "likes")
    private Set<User> likedBy;

    @ManyToOne
    @JoinColumn(
            name = "brand_id",
            referencedColumnName = "id"
    )
    private Brand brand;

    private String name;

    private Long price;

    private String description;
}
