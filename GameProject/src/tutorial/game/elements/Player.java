package tutorial.game.elements;

import org.lwjgl.input.Mouse;

import tutorial.data.TileType;
import tutorial.helpers.Artist;
import tutorial.helpers.TileGrid;
import tutorial.helpers.Artist.*;

public class Player {

	private TileGrid grid;

	public Player(TileGrid grid) {
		this.grid = grid;
	}
	
	public void setTile(){
		grid.setTile((int)Math.floor(Mouse.getX()/64), (int)Math.floor((Artist.HEIGHT - Mouse.getY() -1)/64), TileType.TileRed);
	}
	
}
