package tutorial.helpers;

import tutorial.data.TileType;
import tutorial.game.elements.Tile;

public class TileGrid {

	private static final int TILE_SIZE = TileType.TILE_SIZE;
	private final Tile[][] grid = new Tile[Artist.WIDTH / TILE_SIZE][Artist.HEIGHT / TILE_SIZE];

	public TileGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileClean);
			}
		}
	}

	public TileGrid(final int[][] newMap) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					grid[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileClean);
					break;
				case 1:
					grid[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileRed);
					break;
				default:
					break;
				}
			}
		}
	}

	public void setTile(final int x, final int y, final TileType type) {
		grid[x][y] = new Tile(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE, type);
	}

	public Tile getTile(final int x, final int y) {
		return grid[x][y];
	}

	public void drawGrid() {
		for (final Tile[] element : grid) {
			for (final Tile t : element) {
				t.draw();
			}
		}
	}

}
