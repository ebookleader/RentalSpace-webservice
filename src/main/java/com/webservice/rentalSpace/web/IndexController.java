package com.webservice.rentalSpace.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user/login")
    public String login_user() {

        return "login_user";
    }

    @GetMapping("/signup")
    public String signup_user() {
        return "signup_user";
    }

    @GetMapping("/space/list")
    public String space_list() {

        return "space_list";
    }

    @GetMapping("/space/detail")
    public String space_detail() {
        return "space_detail";
    }

    @GetMapping("/space/payment")
    public String space_payment() {
        return "payment";
    }

    @GetMapping("/mypage/home")
    public String mypage_home() {
        return "mypage_home";
    }

    @GetMapping("/mypage/before/changePassword")
    public String before_changePassword() {
        return "before_changePassword";
    }

    @GetMapping("/mypage/changePassword")
    public String changePassword() {
        return "changePassword";
    }

    @GetMapping("/mypage/before/deleteAccount")
    public String before_deleteAccount() {
        return "before_deleteAccount";
    }

    @GetMapping("/mypage/deleteAccount")
    public String deleteAccount() {
        return "deleteAccount";
    }

    @GetMapping("/mypage/likedList")
    public String liked_list() {
        return "liked_list";
    }

    @GetMapping("/mypage/reservation/ongoing")
    public String ongoing_reservation_list() {
        return "ongoing_reservation_list";
    }

}

