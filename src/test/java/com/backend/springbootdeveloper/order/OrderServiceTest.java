package com.backend.springbootdeveloper.order;

import com.backend.springbootdeveloper.AppConfig;
import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import com.backend.springbootdeveloper.member.MemberService;
import com.backend.springbootdeveloper.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();

    }

    @Test
    void createOrder() {
        Long memberId= 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
