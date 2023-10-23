package com.ichwan.jpa.entity.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("VP")
public class VicePresident extends Employee {

    @Column(name = "total_manager")
    private Integer totalManager;
}
