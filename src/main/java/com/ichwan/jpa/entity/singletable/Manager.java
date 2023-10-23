package com.ichwan.jpa.entity.singletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("MANAGER")
public class Manager extends Employee {

    @Column(name = "total_employee")
    private Integer totalEmployee;

}
