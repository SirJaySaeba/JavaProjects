package tutorial.game.elements;

import static tutorial.helpers.Artist.DrawQuadTex;
import static tutorial.helpers.Clock.Delta;

import org.newdawn.slick.opengl.Texture;

import tutorial.data.TileType;
import tutorial.helpers.TileGrid;

public class Enemy {

	private int width, height, health;
	private float x, y, speed;
	private Texture texture;
	private Tile startTile;
	private boolean first;
	private final TileGrid tileGrid;

	public Enemy(final float speed, final int width, final int height, final int health, final Texture texture,
			final Tile startTile, final TileGrid tileGrid) {
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.startTile = startTile;
		this.speed = speed;
		this.width = width;
		this.height = height;
		this.health = health;
		this.texture = texture;
		this.first = true;
		this.tileGrid = tileGrid;
	}

	public void update() {
		if (first) {
			first = false;
		} else {
			if (continuePath()) {
				x += Delta() * speed;
			}
		}
	}

	private boolean continuePath() {
		final int tileSize = TileType.TILE_SIZE;
		final Tile currentTile = tileGrid.getTile((int) x / tileSize, (int) y / tileSize);
		final Tile nextTile = tileGrid.getTile((int) x / tileSize + 1, (int) y / tileSize);

		if (currentTile.getType() != nextTile.getType()) {
			return false;
		}

		return true;
	}

	public void draw() {
		DrawQuadTex(x, y, width, height, texture);
	}

	public TileGrid getTileGrid() {
		return tileGrid;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(final int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(final int health) {
		this.health = health;
	}

	public float getX() {
		return x;
	}

	public void setX(final float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(final float y) {
		this.y = y;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(final float speed) {
		this.speed = speed;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(final Texture texture) {
		this.texture = texture;
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(final Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(final boolean first) {
		this.first = first;
	}

}
