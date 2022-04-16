package com.vti.entity.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
		ElementType.PARAMETER, ElementType.TYPE_USE })
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { DepartmentIDNotExistsValidator.class })

public @interface DepartmentNotExists {
	String message() default "{Department.form.name.NotExists}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
