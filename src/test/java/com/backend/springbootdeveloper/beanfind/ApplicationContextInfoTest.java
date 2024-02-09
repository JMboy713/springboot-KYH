package com.backend.springbootdeveloper.beanfind;

import com.backend.springbootdeveloper.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈으로 정의된 이름들
        for(String beanDefinitionName : beanDefinitionNames){ // iter 로 각각 가져옴
            Object bean = ac.getBean(beanDefinitionName); // type 을 모르기 때문에 오브젝트가 꺼내짐.
            System.out.println("name = "+beanDefinitionName+" object= "+bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기.")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 빈으로 정의된 이름들
        for(String beanDefinitionName : beanDefinitionNames){ // iter 로 각각 가져옴
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // bean 의 정보를 가져옴.
            // Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            // Role Role_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈

            if (beanDefinition.getRole()== BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName+" object = "+bean);
            }
        }
    }
}
