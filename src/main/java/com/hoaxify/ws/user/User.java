package com.hoaxify.ws.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Data;

@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	

	@UniqueUsername
	@NotNull(message = "{hoaxify.constraints.username.NotNull.message}")
	private String username;
	
	@NotNull(message = "{hoaxify.constraints.displayName.NotNull.message}")
	private String displayName;
	
	@NotNull
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	
	@NotNull
	private String password;
	
	@Override
	public String toString() {
		return "User [usurname=" + username + ", displayName=" + displayName + ", password=" + password + "]";
	}

	
}
