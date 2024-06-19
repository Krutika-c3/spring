package com.learning.spring.tightlyCoupled;

import com.learning.spring.tightlyCoupled.game.GameRunner;
import com.learning.spring.tightlyCoupled.game.MarioGame;

/*
    Coupling: how much work is required in changing something?
    Computer is tightly coupled to table
    Whereas, Laptop is loosely coupled to the table

    Loose coupling is required as:
    - Business requirements change
    - Code changes
    - Frameworks change

    We want Loose Coupling as much as possible
    We want to make functional changes with as less code changes as possible
 */
public class AppGaming {
    public static void main(String[] args) {
        var marioGame = new MarioGame();
        // if we change it to SuperContraGame it won't work as GameRunner is tightly coupled with MarioGame
        // var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();
    }
}
