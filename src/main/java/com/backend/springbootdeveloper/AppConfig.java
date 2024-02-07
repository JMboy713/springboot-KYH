package com.backend.springbootdeveloper;

import com.backend.springbootdeveloper.discount.DiscountPolicy;
import com.backend.springbootdeveloper.discount.FixDiscountPolicy;
import com.backend.springbootdeveloper.member.*;
import com.backend.springbootdeveloper.order.OrderService;
import com.backend.springbootdeveloper.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository()); // 생성자 주입. 생성자를 통해서 뭐가 들어갈지 정해줌.
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }


}
