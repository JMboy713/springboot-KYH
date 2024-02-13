package com.backend.springbootdeveloper.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        int userAPrice= statefulService1.order("UserA",10000);
        //ThreadA : B 사용자 20000원 주문
        int userBPrice = statefulService2.order("UserB",20000);

        //ThreadA : 사용자 A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println(price);

//        org.assertj.core.api.Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
        org.assertj.core.api.Assertions.assertThat(userAPrice).isEqualTo(10000);
                    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }


    }

}