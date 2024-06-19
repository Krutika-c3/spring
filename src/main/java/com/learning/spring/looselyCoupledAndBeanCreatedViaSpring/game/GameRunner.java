package com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game;

public class GameRunner {

    GamingConsole game;

    // made use of interface to make relation loosely coupled
    public GameRunner(GamingConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
