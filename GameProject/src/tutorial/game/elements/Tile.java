package tutorial.game.elements;

import static tutorial.helpers.Artist.*;

import org.newdawn.slick.opengl.Texture;

import tutorial.data.TileType;

public class Tile {

	private final float x, y, width, height;
	private final TileType type;
	private final Texture texture;
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public TileType getType() {
		return type;
	}

	public Texture getTexture() {
		return texture;
	}

	public Tile(float x, float y, float width, float height, TileType type) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		this.texture = QuickLoad(type.getTextureName());
	}
	
	public void draw(){
		DrawQuadTex(x,y,width,height, texture);
	}
}