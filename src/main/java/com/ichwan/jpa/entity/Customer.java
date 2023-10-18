package com.ichwan.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String id;

    private String name;

    @Column(name = "primary_email")
    private String primaryEmail;

    private Boolean married;

    private Byte age;
}
