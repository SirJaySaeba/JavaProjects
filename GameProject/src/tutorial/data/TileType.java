package tutorial.data;

public enum TileType {

	TileRed("tileRED", false), TileClean("tile", true);
	private final String textureName;
	private final boolean buildable;
	public final static int TILE_SIZE = 64;
	
	public String getTextureName() {
		return textureName;
	}

	public boolean isBuildable() {
		return buildable;
	}

	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}
	
	
}
