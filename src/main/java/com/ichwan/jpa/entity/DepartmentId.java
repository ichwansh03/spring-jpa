package com.ichwan.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class DepartmentId implements Serializable {

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "department_id")
    private String departmentId;
}
