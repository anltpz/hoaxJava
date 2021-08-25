package com.hoaxify.ws.user;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.Shared.GenericResponse;
import com.hoaxify.ws.error.ApiError;



@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	

	@PostMapping("/api/1.0/users")
	@ResponseStatus(value = HttpStatus.CREATED)
	public GenericResponse createUser(@Valid @RequestBody User user)
	{

		userService.save(user);
		 
		return new GenericResponse("User created");
		
	
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ApiError handlerexeption (MethodArgumentNotValidException exeption)
	{
		ApiError apiError = new ApiError(400, "Validation Eror", "api/1.0/users");
		Map<String , String> hata = new HashMap<>();
		
		for (FieldError field : exeption.getBindingResult().getFieldErrors()) {
			hata.put(field.getField(), field.getDefaultMessage());
			
		}
		apiError.setValidationErros(hata);
		
		return apiError;
	}
}
