package com.backend.springbootdeveloper;

import com.backend.springbootdeveloper.discount.DiscountPolicy;
import com.backend.springbootdeveloper.discount.FixDiscountPolicy;
import com.backend.springbootdeveloper.discount.RateDiscountPolicy;
import com.backend.springbootdeveloper.member.*;
import com.backend.springbootdeveloper.order.OrderService;
import com.backend.springbootdeveloper.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    // @Bean -> memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemberRepository -> new MemoryMemberRepository()

    @Bean

    public MemberService memberService() {
        System.out.println("call Appconfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입. 생성자를 통해서 뭐가 들어갈지 정해줌.
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call Appconfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call Appconfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();// 비율 할인 정책으로 변경
    }


}
