package com.comdolidoli.shoppingmall.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.comdolidoli.shoppingmall.demo.dto.MemberDto;
import com.comdolidoli.shoppingmall.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/")
    public String index() {
        log.info("request get localhost:8080/ success");
        return "/index";
    }

    @GetMapping("/user/signup")
    public String dispSignup() {
        log.info("request get localhost:8080/user/signup success");
        return "/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);
        log.info("request post localhost:8080/user/signup success");
        log.info(memberDto.toString());
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String dispLogin() {
        log.info("request get localhost:8080/user/login success");
        return "/login";
    }

    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        log.info("request get localhost:8080/user/login/result success");

        return "/loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String dispLogout() {
        log.info("request get localhost:8080/user/logout/result success");
        return "/logout";
    }
    @GetMapping("/user/denied")
    public String dispDenied() {
        log.info("request get localhost:8080/user/denied success");
        return "/denied";
    }

    @GetMapping("/user/info")
    public String dispMyInfo() {
        log.info("request get localhost:8080/user/info success");
        return "/myinfo";
    }

    @GetMapping("/admin")
    public String dispAdmin() {
        log.info("request get localhost:8080/user/admin success");
        return "/admin";
    }
}
