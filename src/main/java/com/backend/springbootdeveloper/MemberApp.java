package com.backend.springbootdeveloper;

import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import com.backend.springbootdeveloper.member.MemberService;
import com.backend.springbootdeveloper.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Bean 들을 다 관리해주는 컨테이너
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 메서드 이름으로 등록됨.  paramegter (메서드 이름, 반환 타입)

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = "+memberA.getName());
        System.out.println("findMember = "+findMember.getName());

    }
}
