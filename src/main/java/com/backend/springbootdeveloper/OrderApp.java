package com.backend.springbootdeveloper;

import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import com.backend.springbootdeveloper.member.MemberService;
import com.backend.springbootdeveloper.member.MemberServiceImpl;
import com.backend.springbootdeveloper.order.Order;
import com.backend.springbootdeveloper.order.OrderService;
import com.backend.springbootdeveloper.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 찾아서 쓸 수 있게 넣어두자.
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order + ="+order);
        System.out.println("order.cal = "+order.calculatePrice());


    }
}
