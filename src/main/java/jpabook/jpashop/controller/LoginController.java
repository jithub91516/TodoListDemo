package jpabook.jpashop.controller;

import jpabook.jpashop.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @GetMapping("/")
    public String loginInit(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/")
    public String login(@Valid LoginForm form,Model model){

        String res = loginService.login(form);
        if(res.equals("success")){
            return "home";
        }else{
            model.addAttribute("error", "Login Failed. Invalid ID or Password.");
            return "login";
        }

    }
}
