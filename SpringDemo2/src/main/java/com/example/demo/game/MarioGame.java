package com.example.demo.game;

import org.springframework.stereotype.Component;

public class MarioGame implements gameConsole {

    public void up(){
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("Down in the hole");
    }
    public void right(){
        System.out.println("accelerate");
    }
    public void left(){
        System.out.println("Go back");
    }
}
