package org.example.springpractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// spring mvc 활성화
@EnableWebMvc
// org.example.springtest.controller를 스캔해서 @Controller, @Service, @Component
// 같은 어노테이션이 붙은 클래스들을 자동으로 Bean으로 등록
@ComponentScan(basePackages = {"org.example.springtest.controller"})
// implements WebMvcConfigurer는 spring mvc 설정을 사용자가 정의하기 위한 인터페이스
public class ServletConfig implements WebMvcConfigurer {
    @Override
    // 클라이언트가 /resource/** 로 요청하면
    // 실제 리소스 위치인 /resources/ 경로에서 정적 파일을 찾도록 설정
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    // jsp view resolver 설정
    @Override
    // 컨트롤러가 리턴한 view 이름을 가지고 실제 jsp 파일을 찾을 수 있도록 도와줌
    public void configureViewResolvers(ViewResolverRegistry registry){
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }
}