package com.backend.springbootdeveloper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.backend.springbootdeveloper",// 탐색을 시작할 위치를 지정.
        basePackageClasses = AutoAppConfig.class,// 시작할 패키지를 지정.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // configuration 설정 정보 모두 컴포넌트 스캔 대상이 되기 때문에 appconfig도 스캔한다. 이를 방지하고자 excludefilter를 사용한다.

)
public class AutoAppConfig {
}
