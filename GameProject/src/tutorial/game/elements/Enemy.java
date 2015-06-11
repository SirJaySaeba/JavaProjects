package tutorial.game.elements;

import static tutorial.helpers.Artist.DrawQuadTex;
import static tutorial.helpers.Artist.*;

import org.newdawn.slick.opengl.Texture;

public class Enemy {

	float x, y, speed;
	int width, height, health;
	Texture texture;
	Tile startTile;
	
	public Enemy(float speed, int width, int height, int health, Texture texture, Tile startTile) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.health = health;
		this.texture = texture;
		this.startTile = startTile;
	}
	
	public void draw(){
		DrawQuadTex(x,y,width,height, texture);

	}
	
}
