package com.hoaxify.ws.user;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;


@Target({ METHOD })
@Retention(RUNTIME)
@Constraint(validatedBy = { })
public @interface UniqueUsername {


}
