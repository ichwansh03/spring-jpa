package com.ichwan.jpa;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

public abstract class ValidateContract {

    protected ValidatorFactory factory;

    protected Validator validator;

    protected ExecutableValidator executableValidator;

    @BeforeEach
    void setUp() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        executableValidator = validator.forExecutables();
    }

    @AfterEach
    void tearDown() {
        factory.close();
    }

    void validate(Object object){
        Set<ConstraintViolation<Object>> validate = validator.validate(object);

        for (ConstraintViolation<Object> violation : validate){
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("==============");
        }
    }
}
