package com.learning.spring.looselyCoupledViaInterface;

import com.learning.spring.looselyCoupledViaInterface.game.GameRunner;
import com.learning.spring.looselyCoupledViaInterface.game.MarioGame;

public class AppGaming {
    public static void main(String[] args) {
        // we can make use of different game classes like:
        // var game = new PacmanGame();
        // var game = new SuperContraGame();
        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
