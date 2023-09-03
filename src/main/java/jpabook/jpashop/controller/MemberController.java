package jpabook.jpashop.controller;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    @GetMapping("/members/new")
     public String createForm(Model medel){
        medel.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
     }

     @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) throws Exception{

        if (result.hasErrors()){
            return "members/createMemberForm";
        }else if(!form.getPassword().equals(form.getPasswordCheck())){
            return "members/createMemberForm";
        }

         Member member = new Member();
         member.setName(form.getName());
         member.setLoginId(form.getLoginId());
         member.setPassword(form.getPassword());
         member.setEmail(form.getEmail());


         memberService.join(member);
         return "redirect:/";
     }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";

    }

    @PostMapping("/members/delete")
    public String deleteMember(@Valid String id, HttpSession session){
        String res = memberService.deleteMember(id);

        return "login";
    }

}

