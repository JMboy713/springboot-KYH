package com.backend.springbootdeveloper.singleton;

import com.backend.springbootdeveloper.AppConfig;
import com.backend.springbootdeveloper.member.MemberRepository;
import com.backend.springbootdeveloper.member.MemberServiceImpl;
import com.backend.springbootdeveloper.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {
    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository2 = memberService.getMemberRepository();
        MemberRepository memberRepository1 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepo"+memberRepository1);
        System.out.println("orderService -> memberRepo"+memberRepository2);
        System.out.println("memberRepository"+memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
