package com.wall.dto;

import java.io.Serializable;

import com.wall.entities.User;


public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;
    
    private final String message;
    
    User user;

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AuthenticationResponse(String msg,User user) {
        this.message=msg;
        this.user=user;
    }

    public String getMessage() {
		return message;
	}

}
