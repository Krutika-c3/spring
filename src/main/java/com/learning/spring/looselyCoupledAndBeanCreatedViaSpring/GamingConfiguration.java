package com.learning.spring.looselyCoupledAndBeanCreatedViaSpring;

import com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game.GameRunner;
import com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game.GamingConsole;
import com.learning.spring.looselyCoupledAndBeanCreatedViaSpring.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}

}
