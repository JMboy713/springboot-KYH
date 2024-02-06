package com.backend.springbootdeveloper.discount;

import com.backend.springbootdeveloper.member.Member;

public interface DiscountPolicy {
    /*
    @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
