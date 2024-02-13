package com.backend.springbootdeveloper.singleton;

import com.backend.springbootdeveloper.AppConfig;
import com.backend.springbootdeveloper.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.function.SingletonSupplier;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();
        // 참조값이 다른 것을 확인, -> 객체가 계속해서 jvm에 올라감.
        System.out.println("memberservice1 = "+memberService1);
        System.out.println("memberservice2 = "+memberService2);
        // member1 != member2
        assertThat(memberService1).isNotEqualTo(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1= SingletonService.getInstance();
        SingletonService singletonService2= SingletonService.getInstance();

        System.out.println(singletonService1);
        System.out.println(singletonService2);// 객체 인스턴스가 같다.
        assertThat(singletonService1).isSameAs(singletonService2);
        // same 과 equal
        // same : == , equal : equals 를 오버라이드.

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        // AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);
        // 참조값이 다른 것을 확인, -> 객체가 계속해서 jvm에 올라감.
        System.out.println("memberservice1 = "+memberService1);
        System.out.println("memberservice2 = "+memberService2);
        // member1 != member2
        assertThat(memberService1).isSameAs(memberService2);

    }

}
