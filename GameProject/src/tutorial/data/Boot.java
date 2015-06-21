package tutorial.data;

import static tutorial.helpers.Artist.BeginSession;
import static tutorial.helpers.Artist.QuickLoad;
import static tutorial.helpers.Artist.getRandomMap;

import org.lwjgl.opengl.Display;

import tutorial.game.elements.Enemy;
import tutorial.game.elements.Player;
import tutorial.helpers.Clock;
import tutorial.helpers.TileGrid;

public class Boot {

	public Boot() {

		BeginSession();

		final TileGrid grid = new TileGrid(getRandomMap());
		grid.setTile(0, 1, grid.getTile(1, 4).getType());
		final Enemy e = new Enemy(2, 64, 64, 20, QuickLoad("goomba"), grid.getTile(0, 5));
		final Wave wave = new Wave(100, e);
		final Player player = new Player(grid);
		while (!Display.isCloseRequested()) {
			// first update, then draw!
			Clock.update();
			e.update();

			grid.drawGrid();
			e.draw();
			wave.update();
			player.update();

			Display.update();
			Display.sync(50);
		}

		Display.destroy();
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		new Boot();
	}

}
