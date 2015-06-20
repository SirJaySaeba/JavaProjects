package tutorial.data;

import static tutorial.helpers.Artist.BeginSession;
import static tutorial.helpers.Artist.QuickLoad;

import org.lwjgl.opengl.Display;

import tutorial.game.elements.Enemy;
import tutorial.game.elements.Player;
import tutorial.helpers.Clock;
import tutorial.helpers.TileGrid;


public class Boot {

	public Boot(){
		
		BeginSession();
		
		int[][] map = {
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0,0},
		};

		final TileGrid grid = new TileGrid(map);
		grid.setTile(0, 1, grid.getTile(1, 4).getType());
		Enemy e = new Enemy(2, 64, 64, 20, QuickLoad("goomba"), grid.getTile(1, 1));
		Wave wave = new Wave(10,e);
		Player player = new Player(grid);
		while(!Display.isCloseRequested()){
			//first update, then draw!
			Clock.update();
			e.update();
			
			grid.drawGrid();
			e.draw();
			wave.update();
			player.setTile();
			Display.update();
			Display.sync(50);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Boot();
	}

}
