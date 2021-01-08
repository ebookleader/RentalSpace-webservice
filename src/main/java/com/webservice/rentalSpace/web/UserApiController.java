package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.config.auth.LoginUser;
import com.webservice.rentalSpace.config.auth.dto.SessionUser;
import com.webservice.rentalSpace.domain.user.Role;
import com.webservice.rentalSpace.domain.user.UserRepository;
import com.webservice.rentalSpace.service.user.UserService;
import com.webservice.rentalSpace.web.dto.UserUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final JavaMailSender javaMailSender;

    // enroll seller
    @GetMapping("/api/user/checkIsSeller")
    public boolean checkIsSeller(@LoginUser SessionUser user) {
        boolean result;
        if(user.getRole().equals(Role.SELLER))
            result = true;
        else
            result = false;
        return result;
    }

    @PutMapping("/api/user/enrollSeller")
    public Long updateUserSeller(@LoginUser SessionUser user) {
        String userEmail = user.getEmail();
        return userService.updateToSeller(userEmail);
    }

    // email verify
    @PostMapping("/api/guestUser/email/verify")
    public Long sendMail(String userEmail) {
        return userService.sendVerificationMail(userEmail);
    }

    @PutMapping("/api/guestUser/email/check")
    public boolean checkEmailCode(String inputKey, String userEmail) {
        boolean result = userService.checkEmailCode(inputKey, userEmail);
        return result;
    }
}
