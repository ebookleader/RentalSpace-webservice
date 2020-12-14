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
import java.util.List;

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
        //userAccountName
        if(user != null) {
            model.addAttribute("userAccountName", user.getName());
        }
        //product list
        model.addAttribute("products", productsService.findAllDesc());
        addSidebarAttribute(model);
        return "products/space_list";
    }

//    @GetMapping("/space/list/{category}")
//    public String spaceListCategory(Model model, @PathVariable String category, @LoginUser SessionUser user) {
//        if(user != null) {
//            model.addAttribute("userAccountName", user.getName());
//        }
//        addSidebarAttribute(model);
//        model.addAttribute("products", productsService)
//    }

    private void addSidebarAttribute(Model model) {
        //city sidebar num
        String[] cityList = {"서울특별시", "인천광역시", "대전광역시", "대구광역시", "부산광역시", "광주광역시", "울산광역시",
                "세종특별자치도", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주도"
        };
        for(int i=0;i<17;i++) {
            model.addAttribute("city"+i, productsService.findEachNumByCity(cityList[i]));
        }
        //category sidebar num
        String[] categoryList = {"악기", "노래/녹음", "댄스", "뮤지컬", "쿠킹", "스터디"};
        for(int i=0;i<6;i++) {
            model.addAttribute("category"+i, productsService.findEachNumByCategory(categoryList[i]));
        }
        // price sidebar num
        Integer[] priceList = {0, 10000, 35000, 70000, 100000};
        for(int i=0;i<5;i++) {
            if (i==4) {
                model.addAttribute("price"+i, productsService.findEachNumByPriceMax(priceList[i]));
            }
            else {
                model.addAttribute("price"+i, productsService.findEachNumByPrice(priceList[i], priceList[i+1]));
            }
        }
        // rating sidebar num
        for(int i=5;i>=0;i--) {
            model.addAttribute("rating"+i, productsService.findEachNumByRating((double)i));
        }
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

