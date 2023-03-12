package com.example.demo;

import com.example.demo.game.ContraGame;
import com.example.demo.game.GameRunner;
import com.example.demo.game.MarioGame;
import com.example.demo.game.PacmanGame;

public class AppBasicGaming {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        var contraGame = new ContraGame();
        var pacmanGame = new PacmanGame();
        var gameRunner = new GameRunner(pacmanGame);
        gameRunner.run();
    }
}

