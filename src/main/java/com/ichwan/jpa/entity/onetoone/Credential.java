package com.ichwan.jpa.entity.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    private String id;

    private String email;

    private String password;

    //sesuai dengan nama field di class user
    @OneToOne(mappedBy = "credential")
    private User user;
}
