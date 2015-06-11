package tutorial.helpers;

import tutorial.data.TileType;
import tutorial.game.elements.Tile;

public class TileGrid {

	private static final int TILE_SIZE = TileType.TILE_SIZE;
	private final Tile[][] grid = new Tile[Artist.WIDTH/TILE_SIZE][Artist.HEIGHT/TILE_SIZE];;
	
	public TileGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = new Tile(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileClean);
			}
		}
	}

	public TileGrid(int[][] newMap){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				switch(newMap[j][i]){
				case 0:
					grid[i][j] = new Tile(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileClean);
					break;
				case 1:
					grid[i][j] = new Tile(i*TILE_SIZE, j*TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.TileRed);					
					break;
				default:
					break;
				}
			}
		}
	}
	
	public void setTile(int x, int y, TileType type){
		grid[x][y] = new Tile(x*TILE_SIZE,y*TILE_SIZE,TILE_SIZE,TILE_SIZE, type);
	}
	
	public Tile getTile(int x, int y){
		return grid[x][y];
	}
	
	public void drawGrid(){
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				Tile t = grid[i][j];
				t.draw();
			}
		}
	}
	
}
