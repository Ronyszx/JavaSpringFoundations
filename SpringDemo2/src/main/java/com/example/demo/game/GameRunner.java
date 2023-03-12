package com.example.demo.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    gameConsole game;
    public GameRunner(gameConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Game running:"+ game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
