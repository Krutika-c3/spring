package com.learning.spring.tightlyCoupled.game;

public class GameRunner {

    private MarioGame marioGame;

    // GameRunner is tightly coupled to specific game (MarioGame)
    public GameRunner(MarioGame marioGame) {
        this.marioGame = marioGame;
    }

    public void run() {
        System.out.println("Running game: " + marioGame);
        marioGame.up();
        marioGame.down();
        marioGame.left();
        marioGame.right();
    }
}
