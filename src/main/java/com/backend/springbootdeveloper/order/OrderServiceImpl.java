package com.backend.springbootdeveloper.order;

import com.backend.springbootdeveloper.discount.DiscountPolicy;
import com.backend.springbootdeveloper.discount.FixDiscountPolicy;
import com.backend.springbootdeveloper.discount.RateDiscountPolicy;
import com.backend.springbootdeveloper.member.Member;
import com.backend.springbootdeveloper.member.MemberRepository;
import com.backend.springbootdeveloper.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    /*private final MemberRepository memberRepository = new MemoryMemberRepository();// 멤버 변수
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();// 고정 할인 정책
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();// 비율 할인 정책
    private DiscountPolicy discountPolicy;*/

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
