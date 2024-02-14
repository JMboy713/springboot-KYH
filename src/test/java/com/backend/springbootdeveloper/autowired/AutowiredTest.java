package com.backend.springbootdeveloper.autowired;

import com.backend.springbootdeveloper.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        @Autowired(required = false) // 의존관계가 없으면 수정자 메서드가 호출이 안됨.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 ="+noBean1);
        }
        @Autowired// 자동 주입할 대상이 없으면 null 이 호출
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean1 ="+noBean2);
        }
        @Autowired(required = false) //Optional.empty 가 입력된다.
        public void setNoBean2(Optional<Member> member){
            System.out.println("setNoBean3 ="+member);
        }





    }
}
