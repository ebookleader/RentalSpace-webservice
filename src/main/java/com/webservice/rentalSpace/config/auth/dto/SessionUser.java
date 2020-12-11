package com.webservice.rentalSpace.config.auth.dto;

import com.webservice.rentalSpace.domain.user.User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    private boolean emailVerified;

    public SessionUser(){}

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
        this.emailVerified = user.isEmailVerified(); //true or false
    }
}
