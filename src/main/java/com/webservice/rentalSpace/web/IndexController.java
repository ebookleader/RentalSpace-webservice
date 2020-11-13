package com.webservice.rentalSpace.web;

import com.webservice.rentalSpace.service.products.ProductsService;
import com.webservice.rentalSpace.web.dto.ProductsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProductsService productsService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/space/save")
    public String spaceSave() {
        return "space_save";
    }

    @GetMapping("/space/list")
    public String spaceList(Model model) {
        model.addAttribute("products", productsService.findAllDesc());
        return "space_list";
    }

    @GetMapping("/space/detail/{p_id}")
    public String spaceDetail(@PathVariable Long p_id, Model model) {
        ProductsResponseDto dto = productsService.findById(p_id);
        model.addAttribute("product", dto);
        model.addAttribute("facility", productsService.findProductsFacilityById(p_id));
        return "space_detail";
    }

//    @GetMapping("/user/login")
//    public String login_user() {
//
//        return "login_user";
//    }
//
//    @GetMapping("/signup")
//    public String signup_user() {
//        return "signup_user";
//    }
//
//    @GetMapping("/space/list")
//    public String space_list() {
//
//        return "space_list";
//    }
//
//    @GetMapping("/space/detail")
//    public String space_detail() {
//        return "space_detail";
//    }
//
//    @GetMapping("/space/payment")
//    public String space_payment() {
//        return "payment";
//    }
//
//    @GetMapping("/mypage/home")
//    public String mypage_home() {
//        return "mypage_home";
//    }
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

