package com.ichwan.jpa.entity.onetoone;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;

    private String name;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
    private Credential credential;

    @OneToOne(mappedBy = "user")
    private Wallet wallet;
}
