package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.config.auth.LoginUser;
import com.webservice.rentalSpace.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ResolvableType;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        return "account/login_user";
    }

}
