package com.example.demo.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.game")
public class App03SpringGame {

      //No need of creating manual beans
//    @Bean
//    public GameRunner gameRunner(gameConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner
//    }
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(App03SpringGame.class)){
            context.getBean(gameConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
