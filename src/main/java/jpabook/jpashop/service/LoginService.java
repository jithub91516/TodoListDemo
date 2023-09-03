package jpabook.jpashop.service;

import jpabook.jpashop.common.AES;
import jpabook.jpashop.controller.LoginForm;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.LoginRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;
    public String login(LoginForm form){
        String loginId = form.getLoginId();
        Member member = loginRepository.findByLoginId(loginId);
        boolean isPasswordCorrect = BCrypt.checkpw(form.getPassword(), member.getPassword());

        if(isPasswordCorrect){
            return "success";
        }else{
            return "fail";
        }
    }
}
