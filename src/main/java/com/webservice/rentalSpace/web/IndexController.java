package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.config.auth.LoginUser;
import com.webservice.rentalSpace.config.auth.dto.SessionUser;
import com.webservice.rentalSpace.service.products.ProductsService;
import com.webservice.rentalSpace.web.dto.ProductsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProductsService productsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        return "index";
    }

    @GetMapping("/space/save")
    public String spaceSave(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        return "products/space_save";
    }

    @GetMapping("/space/list")
    public String spaceList(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        model.addAttribute("products", productsService.findAllDesc());
        return "products/space_list";
    }

    @GetMapping("/space/list/detail/{p_id}")
    public String spaceDetail(@PathVariable Long p_id, Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        model.addAttribute("product", productsService.findById(p_id));
        model.addAttribute("facility", productsService.findProductsFacilityById(p_id));
        model.addAttribute("notice", productsService.findProductsNoticeById(p_id));
        model.addAttribute("policy", productsService.findProductsPolicyById(p_id));
        return "products/space_detail";
    }

    @GetMapping("/space/update/{p_id}")
    public String spaceUpdate(@PathVariable Long p_id, Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        model.addAttribute("product", productsService.findById(p_id));
        return "products/space_update";
    }

    @GetMapping("/basicUser/login")
    public String login_user() {
        return "account/login_user";
    }

    @GetMapping("/seller/enroll")
    public String enroll_seller(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userEmail", user.getEmail());
        }
        return "account/enroll_seller";
    }

    @GetMapping("/seller/enroll/complete")
    public String enroll_seller_complete(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        return "account/enroll_seller_complete";
    }

    @GetMapping("/myPage/home")
    public String myPage_home(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userEmailVerified", user.isEmailVerified());
        }
        return "account/mypage_home";
    }

    @GetMapping("/myPage/user/checkEmail")
    public String myPage_checkEmail(Model model, @LoginUser SessionUser user) {
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
        }
        return "account/mypage_check_email";
    }


//
//    @GetMapping("/mypage/before/changePassword")
//    public String before_changePassword() {
//        return "before_changePassword";
//    }
//
//    @GetMapping("/mypage/changePassword")
//    public String changePassword() {
//        return "changePassword";
//    }
//
//    @GetMapping("/mypage/before/deleteAccount")
//    public String before_deleteAccount() {
//        return "before_deleteAccount";
//    }
//
//    @GetMapping("/mypage/deleteAccount")
//    public String deleteAccount() {
//        return "deleteAccount";
//    }
//
//    @GetMapping("/mypage/likedList")
//    public String liked_list() {
//        return "liked_list";
//    }
//
//    @GetMapping("/mypage/reservation/ongoing")
//    public String ongoing_reservation_list() {
//        return "ongoing_reservation_list";
//    }
//
//    @GetMapping("/mypage/reservation/past")
//    public String past_reservation_list() {
//        return "past_reservation_list";
//    }
//
//    @GetMapping("/mypage/review/write")
//    public String write_review() {
//        return "writeReview";
//    }
//
//    @GetMapping("/mypage/review")
//    public String my_review() {
//        return "myReview";
//    }
//
//    @GetMapping("/mypage/review/delete")
//    public String delete_review() {
//        return "deleteReview";
//    }

}

