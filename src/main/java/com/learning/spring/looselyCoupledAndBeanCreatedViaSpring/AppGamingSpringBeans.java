package com.learning.spring.looselyCoupledAndBeanCreatedViaSpring;

import com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game.GameRunner;
import com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGamingSpringBeans {
    public static void main(String[] args) {
        try (var context =
                     new AnnotationConfigApplicationContext
                             (GamingConfiguration.class)) {

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();

        }
    }
}
