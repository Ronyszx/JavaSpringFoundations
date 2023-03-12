package com.example.demo.game.springGame;

import com.example.demo.game.GameRunner;
import com.example.demo.game.PacmanGame;
import com.example.demo.game.gameConsole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurations {

    @Bean
    public gameConsole game(){
        var pacman = new PacmanGame();
        return pacman;
    }

    @Bean
    public GameRunner gameRunner(gameConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
