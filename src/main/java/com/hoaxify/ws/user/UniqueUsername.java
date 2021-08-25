package com.hoaxify.ws.user;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;



@Target({ElementType.FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueUserNamValidation.class })//Hangi class ile muhatap olucak
public @interface UniqueUsername {

	String message() default "Username sistemde kayıtlı";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };


}
