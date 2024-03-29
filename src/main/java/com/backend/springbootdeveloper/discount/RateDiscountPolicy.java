package com.backend.springbootdeveloper.discount;

import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 20;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade()== Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }

    }
}
