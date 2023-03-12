package com.example.demo;

import com.example.demo.game.GameRunner;
import com.example.demo.game.PacmanGame;
import com.example.demo.game.gameConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App02HelloSpring {
    @Bean
    public gameConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(){
        var gameRunner = new GameRunner(game());
        return gameRunner;
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(App02HelloSpring.class);

        context.getBean(gameConsole.class).up();
        context.getBean(GameRunner.class).run();
    }
}

