package tutorial.data;

import java.util.ArrayList;
import java.util.List;
import static tutorial.helpers.Clock.*;

import tutorial.game.elements.Enemy;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy enemy;
	private List<Enemy> enemyList;
	
	public Wave(float spawnTime, Enemy enemyType) {
		this.spawnTime = spawnTime;
		this.enemy = enemyType;
		this.timeSinceLastSpawn = 0;
		this.enemyList = new ArrayList<>();
	}

	public void update(){
		timeSinceLastSpawn += Delta();
		if(timeSinceLastSpawn > spawnTime){
			spawn();
			timeSinceLastSpawn = 0;
		}
		
		for(Enemy e: enemyList){
			e.update();
			e.draw();
		}
	}
	
	private void spawn(){
		enemyList.add(new Enemy(enemy.getSpeed(),enemy.getWidth(), enemy.getHeight(), enemy.getHealth(), enemy.getTexture(),enemy.getStartTile()));
	}
}
