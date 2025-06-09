package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;

public class ProjectConfig2 {
    @Bean
    Parrot parrot1(){
        Parrot p = new Parrot();
        p.setName("Koko");
    }
}
