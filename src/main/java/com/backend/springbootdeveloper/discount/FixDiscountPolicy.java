package com.backend.springbootdeveloper.discount;

import com.backend.springbootdeveloper.member.Grade;
import com.backend.springbootdeveloper.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; // 1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){// enum 객체는 == 를 쓰는것이 맞다.
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}
