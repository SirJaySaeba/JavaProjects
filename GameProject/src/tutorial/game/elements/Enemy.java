package tutorial.game.elements;

import static tutorial.helpers.Artist.DrawQuadTex;
import static tutorial.helpers.Clock.*;

import org.newdawn.slick.opengl.Texture;

public class Enemy {

	private int width, height, health;
	private float x, y, speed;
	private Texture texture;
	private Tile startTile;
	private boolean first;
	
	public Enemy(float speed, int width, int height, int health, Texture texture, Tile startTile) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.startTile = startTile;
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.health = health;
		this.texture = texture;
		this.first = true;
	}
	
	public void update(){
		if(first){
			first = false;
		}else{			
			x += Delta() * speed;
		}
	}
	
	public void draw(){
		DrawQuadTex(x,y,width,height, texture);

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	
}
