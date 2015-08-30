package tutorial.data;

import static tutorial.helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.List;

import tutorial.game.elements.Enemy;

public class Wave {

	private float timeSinceLastSpawn;
	private final float spawnTime;
	private final Enemy enemy;
	private final List<Enemy> enemyList;

	public Wave(final float spawnTime, final Enemy enemyType) {
		this.spawnTime = spawnTime;
		this.enemy = enemyType;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new ArrayList<>();
	}

	public void update() {
		timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {
			spawn();
			timeSinceLastSpawn = 0;
		}

		for (final Enemy e : enemyList) {
			e.update();
			e.draw();
		}
	}

	private void spawn() {
		enemyList.add(new Enemy(enemy.getSpeed(), enemy.getWidth(), enemy.getHeight(), enemy.getHealth(), enemy
				.getTexture(), enemy.getStartTile(), enemy.getTileGrid()));
	}
}
