package com.webservice.rentalSpace.web.dto;

import com.webservice.rentalSpace.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {
//    private String name;
    private String email;
//    private String picture;
//    private Role role;

    @Builder UserUpdateRequestDto(String email) {
//        this.name = name;
        this.email = email;
//        this.picture = picture;
//        this.role = role;
    }

}
