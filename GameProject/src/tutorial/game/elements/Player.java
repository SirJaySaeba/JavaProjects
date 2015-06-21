package tutorial.game.elements;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import tutorial.data.TileType;
import tutorial.helpers.Artist;
import tutorial.helpers.TileGrid;

public class Player {

	private final TileGrid grid;
	private final TileType[] types;
	private int index;

	public Player(TileGrid grid) {
		this.grid = grid;
		this.types = new TileType[2];
		this.types[0] = TileType.TileClean;
		this.types[1] = TileType.TileRed;
		this.index = 0;
	}

	public void setTile() {
		grid.setTile((int) Math.floor(Mouse.getX() / 64), (int) Math.floor((Artist.HEIGHT - Mouse.getY() - 1) / 64),
				types[index]);
	}

	public void update() {
		if (Mouse.isButtonDown(0)) {
			setTile();
		}
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
		}
	}

	private void moveIndex() {
		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}

}
