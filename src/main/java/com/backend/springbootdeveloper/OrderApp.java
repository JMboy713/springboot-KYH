package com.backend.springbootdeveloper;

import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import com.backend.springbootdeveloper.member.MemberService;
import com.backend.springbootdeveloper.member.MemberServiceImpl;
import com.backend.springbootdeveloper.order.Order;
import com.backend.springbootdeveloper.order.OrderService;
import com.backend.springbootdeveloper.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService= applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService= applicationContext.getBean("orderService", OrderService.class);





        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 찾아서 쓸 수 있게 넣어두자.
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order + ="+order);
        System.out.println("order.cal = "+order.calculatePrice());


    }
}
