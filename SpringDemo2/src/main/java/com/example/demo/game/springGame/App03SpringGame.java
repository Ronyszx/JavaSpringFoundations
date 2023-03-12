package com.example.demo.game.springGame;

import com.example.demo.game.GameRunner;
import com.example.demo.game.gameConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class App03SpringGame {
    public static void main(String[] args) {

        try(var context = new AnnotationConfigApplicationContext(SpringConfigurations.class)){
            context.getBean(gameConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
    }
}
