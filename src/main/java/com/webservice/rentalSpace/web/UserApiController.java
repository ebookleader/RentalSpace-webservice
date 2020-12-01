package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.domain.user.UserRepository;
import com.webservice.rentalSpace.service.user.UserService;
import com.webservice.rentalSpace.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    // enroll seller
    @PutMapping("/api/v1/user/{email}")
    public Long updateUserSeller(@PathVariable String email, @RequestBody UserUpdateRequestDto requestDto) {
        return userService.updateToSeller(email);
    }
}
