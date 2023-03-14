package com.example.demo.game.examples;

import com.example.demo.game.GameRunner;
import com.example.demo.game.gameConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.game")
public class DepInjLauncherApp {

      //No need of creating manual beans
//    @Bean
//    public GameRunner gameRunner(gameConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner
//    }
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(DepInjLauncherApp.class)){
            context.getBean(gameConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
